package com.webtools.springfinal.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.bean.InsuranceBean;
import com.webtools.springfinal.bean.PatientBean;
import com.webtools.springfinal.bean.PhysicianBean;
import com.webtools.springfinal.bean.UserAccountBean;
import com.webtools.springfinal.bean.UserInfoBean;
import com.webtools.springfinal.logger.LogMessage;
import com.webtools.springfinal.service.LoginService;
import com.webtools.springfinal.service.exception.InvalidLoginException;
import com.webtools.springfinal.service.exception.LoginServiceException;
import com.webtools.springfinal.view.DiagnosisPdfView;

@Controller
public class UserCreateController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd-MMM-yyyy"), false));
	}
	


	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET, value = "/login.html")
	public String loginPage(Map model) {
		model.put("userAccount", new UserAccountBean());
		return "loginUser2";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editUser.html")
	public ModelAndView editUser(@Valid UserInfoBean ubean,BindingResult result, PatientBean patient,
			PhysicianBean physcian, HttpServletRequest request) {
			if(request.getSession().getAttribute("userInfo")!=null)
		{
			UserInfoBean temp=(UserInfoBean)request.getSession().getAttribute("userInfo");
			if("PATIENT".equals(temp.getUserType()))
			{
				patient.setAppointmentList(((PatientBean)temp).getAppointmentList());
				ubean=patient;
			}
			else
			{
				physcian.setAppointmentList(((PhysicianBean)temp).getAppointmentList());
				ubean=physcian;
			}
			ubean.setUserAccount(temp.getUserAccount());
			ubean.setUserType(temp.getUserType());
			ubean.getUserAccount().setUserType(temp.getUserType().equals("PATIENT")?"ROLE_PATIENT":"ROLE_DOCTOR");
			if(ubean.getUserImage()==null)
			{
				ubean.setUserImage(temp.getUserImage());
			}
			ubean.setUserID(temp.getUserID());
			ubean.setMode("edit");
			
		try {
				Set<String> roleSet = new LinkedHashSet<String>();
				roleSet.add(ubean.getUserAccount().getUserType());
				ubean.getUserAccount().setRoles(roleSet);
				loginService.checkAndInsertUpdateUser(ubean);
				// createImage(ubean.getUserImage());

			} catch (LoginServiceException e) {
				LogMessage.logErrorMessage(LogMessage.returnStackTrace(e),
						"ERROR");
				return new ModelAndView("createUser", "userInfo", ubean);
			}
			}
		
		return new ModelAndView("loginConfirm", "userInfo", ubean);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createUser.html")
	public ModelAndView createUser(@Valid UserInfoBean ubean,BindingResult result1,  PatientBean patient,
			 PhysicianBean physcian, HttpServletRequest request,HttpServletResponse response) {
		if(result1.hasErrors())
		{
			/*if(ubean instanceof PatientBean)
			{
				ubean=patient;
			}
			else
			{
				ubean=physcian;
			}*/
			return new ModelAndView("createUser", "userInfo", ubean);	
		}	
		if (request.getParameter("onChange") != null) {
			if ("ROLE_PATIENT".equals(ubean.getUserAccount().getUserType())) {
				UserAccountBean userAcc = ubean.getUserAccount();
				ubean = new PatientBean();
				List<InsuranceBean> insuranceList = new ArrayList<InsuranceBean>();
				insuranceList.add(new InsuranceBean());
				((PatientBean) ubean).setInsuranceList(insuranceList);
				ubean.setUserAccount(userAcc);

			} else if ("ROLE_DOCTOR".equals(ubean.getUserAccount()
					.getUserType())) {
				UserAccountBean userAcc = ubean.getUserAccount();
				ubean = new PhysicianBean();
				ubean.setUserAccount(userAcc);
			}
			request.getSession().setAttribute("userInfo", ubean);
			return new ModelAndView("createUser", "userInfo", ubean);
		}else {
			if(request.getSession().getAttribute("enableCaptha")==null)
			{	
				request.getSession().setAttribute("enableCaptha", "true");
				request.getSession().setAttribute("userInfo", ubean);
				return new ModelAndView("createUser", "userInfo", ubean);
			}
			else
			{
				if(ubean.getCapthaText()!=null && !"".equals(ubean.getCapthaText()))
				{
					boolean result=verifyCaptcha(ubean.getCapthaText(),request);
					if(!result)
					{
						request.getSession().setAttribute("userInfo", ubean);
						request.setAttribute("captchaError","The entered response doesnot match with the Image text" );
						return new ModelAndView("createUser", "userInfo", ubean);

					}
						
				}	
			
				request.getSession().removeAttribute("enableCaptha");
			if ("ROLE_PATIENT".equals(ubean.getUserAccount().getUserType())) {
				ubean = patient;
			} else if ("ROLE_DOCTOR".equals(ubean.getUserAccount()
					.getUserType())) {
				ubean = physcian;
			}
			ubean.setMode("add");
			try {
				Set<String> roleSet = new LinkedHashSet<String>();
				roleSet.add(ubean.getUserAccount().getUserType());
				ubean.getUserAccount().setRoles(roleSet);
				loginService.checkAndInsertUpdateUser(ubean);

				// createImage(ubean.getUserImage());

			} catch (LoginServiceException e) {
				LogMessage.logErrorMessage(LogMessage.returnStackTrace(e),
						"ERROR");
				return new ModelAndView("createUser", "userInfo", ubean);
			}
			}
		}
		return new ModelAndView("loginConfirm", "userInfo", ubean);
	}
	/*@RequestMapping(method = RequestMethod.POST, value = "/createUser.html")
	public ModelAndView createUser(UserInfoBean ubean, PatientBean patient,
			PhysicianBean physcian, HttpServletRequest request) {
		if(request.getSession().getAttribute("userInfo")!=null)
		{
			UserInfoBean temp=(UserInfoBean)request.getSession().getAttribute("userInfo");
			if("PATIENT".equals(temp.getUserType()))
			{
				patient.setAppointmentList(((PatientBean)temp).getAppointmentList());
				ubean=patient;
			}
			else
			{
				ubean=physcian;
			}
			ubean.setUserAccount(temp.getUserAccount());
			ubean.setUserType(temp.getUserType());
			ubean.getUserAccount().setUserType(temp.getUserType().equals("PATIENT")?"ROLE_PATIENT":"ROLE_DOCTOR");
			if(ubean.getUserImage()==null)
			{
				ubean.setUserImage(temp.getUserImage());
			}
			ubean.setUserID(temp.getUserID());
			ubean.setMode("edit");
			
		}
		else
		{
			ubean.setMode("add");
		}	
			
		if (request.getParameter("onChange") != null) {
			if ("ROLE_PATIENT".equals(ubean.getUserAccount().getUserType())) {
				UserAccountBean userAcc = ubean.getUserAccount();
				ubean = new PatientBean();
				List<InsuranceBean> insuranceList = new ArrayList<InsuranceBean>();
				insuranceList.add(new InsuranceBean());
				((PatientBean) ubean).setInsuranceList(insuranceList);
				ubean.setUserAccount(userAcc);

			} else if ("ROLE_DOCTOR".equals(ubean.getUserAccount()
					.getUserType())) {
				UserAccountBean userAcc = ubean.getUserAccount();
				ubean = new PhysicianBean();
				ubean.setUserAccount(userAcc);
			}
			request.getSession().setAttribute("userInfo", ubean);
			return new ModelAndView("createUser", "userInfo", ubean);
		} else {
			if(request.getSession().getAttribute("enableCaptha")==null)
			{	
				request.getSession().setAttribute("enableCaptha", "true");
				request.getSession().setAttribute("imageID",new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"HealthCarev1");
				request.getSession().setAttribute("userInfo", ubean);
				return new ModelAndView("createUser", "userInfo", ubean);
			}
			else
			{
				if(ubean.getCapthaText()!=null && !"".equals(ubean.getCapthaText()))
				{
					boolean result=verifyCaptcha(ubean.getCapthaText(),request);
					if(!result)
					{
						request.getSession().setAttribute("userInfo", ubean);
						request.setAttribute("captchaError","The entered response doesnot match with the Image text" );
						return new ModelAndView("createUser", "userInfo", ubean);

					}
						
				}	
			
				request.getSession().removeAttribute("enableCaptha");
			if ("ROLE_PATIENT".equals(ubean.getUserAccount().getUserType())) {
				ubean = patient;
			} else if ("ROLE_DOCTOR".equals(ubean.getUserAccount()
					.getUserType())) {
				ubean = physcian;
			}
			try {
				Set<String> roleSet = new LinkedHashSet<String>();
				roleSet.add(ubean.getUserAccount().getUserType());
				ubean.getUserAccount().setRoles(roleSet);
				loginService.checkAndInsertUpdateUser(ubean);
				// createImage(ubean.getUserImage());

			} catch (LoginServiceException e) {
				LogMessage.logErrorMessage(LogMessage.returnStackTrace(e),
						"ERROR");
				return new ModelAndView("createUser", "userInfo", ubean);
			}
			}
		}
		return new ModelAndView("loginConfirm", "userInfo", ubean);
	}*/

	@RequestMapping(method = RequestMethod.GET, value = "/ajax/addInsList.html")
	public void checkUserExists(HttpServletRequest request,
			HttpServletResponse response) {
		boolean userexists = false;
		String totalInsCount = request.getParameter("totalInsCount");
		PatientBean patientBean = (PatientBean) request.getSession()
				.getAttribute("userInfo");
		if (patientBean.getInsuranceList() == null) {
			List<InsuranceBean> insuranceList = new ArrayList<InsuranceBean>();
			insuranceList.add(new InsuranceBean());
			patientBean.setInsuranceList(insuranceList);
		}
		patientBean.getInsuranceList().add(new InsuranceBean());
		request.getSession().removeAttribute("userInfo");
		request.getSession().setAttribute("userInfo", patientBean);
		request.setAttribute("insuranceList", patientBean.getInsuranceList());
		try {
			request.getRequestDispatcher("/WEB-INF/jsps/ajax/addInsurance.jsp")
					.forward(request, response);
		} catch (IOException e) {
			LogMessage.logStackTrace(e);
		} catch (ServletException e) {
			LogMessage.logStackTrace(e);
		} catch (Throwable e) {
			LogMessage.logStackTrace(e);
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/createUser.html")
	public String getCreateUser(Map model) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfoBean p = new UserInfoBean();
		model.put("userInfo", p);
		return "createUser";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit.html")
	public String getEditUser(Map model,HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfoBean p = new UserInfoBean();
		model.put("userInfo", request.getSession().getAttribute("userInfo"));
		return "editUser";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/loginConfirm.html")
	public String confirmPage(Map model, HttpServletRequest request,HttpServletResponse response) {
		UserAccountBean ubean = new UserAccountBean();
		try {
			Object obj = SecurityContextHolder.getContext().getAuthentication()
					.getCredentials();
			ubean.setPassword((String) obj);
			ubean.setUserName(SecurityContextHolder.getContext()
					.getAuthentication().getName());
			ubean = loginService.validateUser(ubean);
			UserInfoBean userbean = loginService.getUserInfo(ubean);
			// createImage(userbean.getUserImage());
			userbean.setUserAccount(ubean);
			HttpSession session = request.getSession();

			session.setAttribute("userInfo", userbean);
			//integrateFaceBook(request,response);
		} catch (LoginServiceException e) {
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
		} catch (InvalidLoginException e) {
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			model.put("userAccount", ubean);
			request.setAttribute("invalidLogin", "true");
			return "loginUser2";
		}
		return "loginConfirm";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login.html")
	public String loginUser(Map model, UserAccountBean ubean,
			HttpServletRequest request) {
		try {
			ubean = loginService.validateUser(ubean);
			UserInfoBean userbean = loginService.getUserInfo(ubean);
			userbean.setUserAccount(ubean);
			model.put("userInfo", userbean);
			request.getSession().setAttribute("userInfo", userbean);
		} catch (LoginServiceException e) {
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
		} catch (InvalidLoginException e) {
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			model.put("userAccount", ubean);
			request.setAttribute("invalidLogin", "true");
			return "loginUser";
		}
		return "loginConfirm";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/logout.html")
	public String logoutUser(Map model, HttpServletRequest request) {
		SecurityContextHolder.clearContext();
		request.getSession().invalidate();
		return "loginUser";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ajax/checkUser.html")
	public @ResponseBody
	String checkUserExists(HttpServletRequest request) {
		boolean userexists = false;
		String username = request.getParameter("username");
		try {
			userexists = loginService.checkUserExists(username);
		} catch (LoginServiceException e) {
			LogMessage.logStackTrace(e);
		}
		return Boolean.toString(userexists);
	}

	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService
	 *            the loginService to set
	 */
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/displayImage.html")
	public void displayImage(HttpServletRequest request,
			HttpServletResponse response) {
		UserAccountBean ubean = new UserAccountBean();
		try {
			Object obj = SecurityContextHolder.getContext().getAuthentication()
					.getCredentials();
			ubean.setPassword((String) obj);
			ubean.setUserName(SecurityContextHolder.getContext()
					.getAuthentication().getName());
			ubean = loginService.validateUser(ubean);
			UserInfoBean userbean = loginService.getUserInfo(ubean);

			byte[] imgData = userbean.getUserImage();
			// display the image
			// response.setContentType("application/msword");
			response.setContentType("image/jpeg");
			OutputStream o = response.getOutputStream();
			o.write(imgData);
			o.flush();
			o.close();
		} catch (Exception e) {
			LogMessage.logStackTrace(e);
		}

	}

	//@RequestMapping(method = RequestMethod.GET, value = "/generatePdf.html")
	public void generatePdf(HttpServletRequest request,
			HttpServletResponse response) {
		Document document = new Document();
		try {
			response.setContentType("application/pdf");
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			document.add(new Paragraph("Hello Kiran"));
			document.add(new Paragraph(new Date().toString()));
		} catch (Exception e) {
			LogMessage.logStackTrace(e);
		}
		document.close();

	}
	@RequestMapping(method = RequestMethod.GET, value = "/generatePdf.html")
	public ModelAndView generateDiagnosisPdf(Map model,HttpServletRequest request) {
		String aptno=request.getParameter("aptno");
		List<DiagnosisBean> diagnosisList=null;
		UserInfoBean userInfo=(UserInfoBean)request.getSession().getAttribute("userInfo");
		if(userInfo instanceof PatientBean)
		{
			PatientBean patient=(PatientBean)userInfo;
			List<AppointmentBean> appointmentList=patient.getAppointmentList();
			for(AppointmentBean appointment:appointmentList)
			{
				if(appointment!=null && Long.valueOf(aptno).equals(appointment.getAppointmentId()))
				{
					diagnosisList=appointment.getDiagnosisList();
				}
			}			
		}	
		else if(userInfo instanceof PhysicianBean)
		{
			PhysicianBean physician=(PhysicianBean)userInfo;
			List<AppointmentBean> appointmentList=physician.getAppointmentList();
			for(AppointmentBean appointment:appointmentList)
			{
				if(Long.valueOf(aptno).equals(appointment.getAppointmentId()))
				{
					diagnosisList=appointment.getDiagnosisList();
				}
			}
		}	
		
		return new ModelAndView(new DiagnosisPdfView(),"diagnosisList" ,diagnosisList);
	}

	private boolean verifyCaptcha(String capthaResponse,HttpServletRequest request)
	{
		URL xmlSource;
		try
		{
			//request.getSession().setAttribute("enableCaptha", true);
			String imageID=(String)request.getSession().getAttribute("imageID");
			xmlSource = new URL("http://www.opencaptcha.com/validate.php?img=1123413&ans="+capthaResponse);
			HttpClient client=new HttpClient();
			GetMethod get=new GetMethod(xmlSource.toString());
			client.executeMethod(get);
			String string=get.getResponseBodyAsString();
			return new Boolean("pass".equals(string)?"true":"false");
		} catch (MalformedURLException e) {
			LogMessage.logStackTrace(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LogMessage.logStackTrace(e);
		} 
		return false;
	}
	
/*	@RequestMapping(method = RequestMethod.GET, value = "/facebookRequest.html")
	public void integrateFaceBook(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String url="https://graph.facebook.com/oauth/authorize?client_id=171307999575779&redirect_uri=http://localhost:8085/HealthCarev1/facebookResponse.html";
			response.sendRedirect(url);
		}
		catch(IOException e)
		{
			LogMessage.logStackTrace(e);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/facebookResponse.html")
	public void integrateFaceBookRedirect(HttpServletRequest request,HttpServletResponse response)
	{
		String code=request.getParameter("code");
		String responseString=null;
		if(code!=null)
		{	
			try
			{
				String url="https://graph.facebook.com/oauth/access_token?client_id=171307999575779&redirect_uri=http://localhost:8085/HealthCarev1/facebookResponse.html&client_secret=9fda66d817ace95e6b654560769e1ede&code="+code;
				URL xmlSource=new URL(url);
				HttpClient client=new HttpClient();
				GetMethod get=new GetMethod(xmlSource.toString());
				client.executeMethod(get);
				responseString=get.getResponseBodyAsString();
			}
			catch(IOException e)
			{
				LogMessage.logStackTrace(e);
			}
			String accessToken=responseString.substring(13,responseString.indexOf("&"));
			FacebookTemplate template=new FacebookTemplate(accessToken);
			template.updateStatus("Abhijeet Kushe is using HealthCarev1 Application");
			
		}
	
	}*/
}
