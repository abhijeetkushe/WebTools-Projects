package com.webtools.springfinal.controller;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.webtools.mail.util.MailDTO;
import com.webtools.mail.util.MailUtil;
import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.bean.MedicineBean;
import com.webtools.springfinal.bean.PatientBean;
import com.webtools.springfinal.bean.PhysicianBean;
import com.webtools.springfinal.bean.UserInfoBean;
import com.webtools.springfinal.logger.LogMessage;
import com.webtools.springfinal.service.HealthCareFacade;
import com.webtools.springfinal.service.LoginService;
import com.webtools.springfinal.service.exception.AppointmentServiceException;
@Controller
public class CreateAppointmentController {
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat("dd-MMM-yyyy"),false));
    } 
  
	private LoginService loginService;
	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(method=RequestMethod.GET,value="/createAppointment.html")
	public String createAppointment(Map model,HttpServletRequest request)
	{
		PatientBean patientbean=(PatientBean)request.getSession().getAttribute("userInfo");
		
		AppointmentBean appointment=new AppointmentBean();
		appointment.setPatientbean(patientbean);
		model.put("appointment",appointment);
		return "createAppointment";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/createAppointment.html")
	public ModelAndView postAppointment(AppointmentBean appointmentBean,HttpServletRequest request)
	{
		
		PatientBean patientbean=(PatientBean)request.getSession().getAttribute("userInfo");
		PhysicianBean physician=null;
		List physicianList=(List)request.getSession().getAttribute("physicianList");
		for(int i=0;i<physicianList.size();i++)
		{
			physician=(PhysicianBean)physicianList.get(i);
			if(physician.getUserID().equals(appointmentBean.getPhysicianID()))
			{
				break;
			}	
		}	
		if(patientbean.getAppointmentList()!=null)
		{	
			patientbean.getAppointmentList().add(appointmentBean);
		}	
		appointmentBean.setPatientbean(patientbean);
		appointmentBean.setPhysician(physician);
		if(physician.getAppointmentList()==null)
		{
			
			physician.setAppointmentList(new ArrayList<AppointmentBean>(10));
		}
		physician.getAppointmentList().add(appointmentBean);
		

		try
		{
			loginService.createAndUpdateAppointment(appointmentBean);
		}	
		catch(AppointmentServiceException exception)
		{
			LogMessage.logErrorMessage(exception.getMessage(), "ERROR");
		}
		generateMailDTO(patientbean,physician,appointmentBean,request);
		return new ModelAndView("loginConfirm","userInfo",patientbean);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/createDiagnosis.html")
	public String createDiagnosis(Map model,HttpServletRequest request)
	{
		String aptNo=request.getParameter("aptno");
		PhysicianBean physicianBean=(PhysicianBean)request.getSession().getAttribute("userInfo");
		int appointmentId=Integer.parseInt(aptNo!=null&&!"".equals(aptNo.trim())?aptNo:"0");
		AppointmentBean appointment=new AppointmentBean();
		for(AppointmentBean temp:physicianBean.getAppointmentList())
		{
			if(temp!=null && temp.getAppointmentId()==appointmentId)
			{
				appointment=temp;
				break;
			}	
			else
			{
				continue;
			}
		}	
		
		List<MedicineBean> medicineList=new ArrayList<MedicineBean>(10);
		medicineList.add(new MedicineBean());
		DiagnosisBean diagnosis=new DiagnosisBean();
		diagnosis.setMedicineList(medicineList);
		diagnosis.setAppointment(appointment);
		request.getSession().setAttribute("appointmentBean", appointment);
		request.getSession().setAttribute("diagnosis", diagnosis);
		model.put("diagnosis",diagnosis);
		return "diagnoseAppointment";
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/createDiagnosis.html")
	public ModelAndView postDiagnosis(DiagnosisBean diagnosisbean,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		AppointmentBean appointmentBean=(AppointmentBean)session.getAttribute("appointmentBean");
		diagnosisbean.setAppointment(appointmentBean);
		if(appointmentBean.getDiagnosisList()==null)
		{
			appointmentBean.setDiagnosisList(new ArrayList<DiagnosisBean>());
		}
		appointmentBean.getDiagnosisList().add(diagnosisbean);

		try
		{
			loginService.createAndUpdateDiagnosis(diagnosisbean);
		}	
		catch(AppointmentServiceException exception)
		{
			LogMessage.logErrorMessage(exception.getMessage(), "ERROR");
		}		
		request.getSession().setAttribute("diagnosis", diagnosisbean);
		//loginService.
		return new ModelAndView("loginConfirm","userInfo",session.getAttribute("userInfo"));
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/ajax/addMedList.html")
	public void checkUserExists(HttpServletRequest request,HttpServletResponse response)
	{
		boolean userexists=false;
		String medCount=request.getParameter("medCount");
		DiagnosisBean diagnosisBean=(DiagnosisBean)request.getSession().getAttribute("diagnosis");
		if(diagnosisBean.getMedicineList()==null)
		{
			List<MedicineBean> medicineList=new ArrayList<MedicineBean>(10);
			medicineList.add(new MedicineBean());

			diagnosisBean.setMedicineList(medicineList);
		}
		request.setAttribute("medrowCount", diagnosisBean.getMedicineList().size());
		diagnosisBean.getMedicineList().add(new MedicineBean());
		request.getSession().removeAttribute("diagnosis");
		request.getSession().setAttribute("diagnosis",diagnosisBean);
		request.setAttribute("medicineList", diagnosisBean.getMedicineList());
		try
		{
			request.getRequestDispatcher("/WEB-INF/jsps/ajax/addMedicine.jsp").forward(request, response);
		}
		catch(IOException e)
		{
			LogMessage.logStackTrace(e);
		}
		catch(ServletException e)
		{
			LogMessage.logStackTrace(e);
		}
		catch(Throwable e)
		{
			LogMessage.logStackTrace(e);
		}
		
				
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ajax/getChart.html")
	public void getChartDetails(HttpServletRequest request,HttpServletResponse response) {
		try
		{
			request.getRequestDispatcher("/WEB-INF/jsps/ajax/generateDiagXml.jsp").forward(request, response);
		}
		catch(IOException e)
		{
			LogMessage.logStackTrace(e);
		}
		catch(ServletException e)
		{
			LogMessage.logStackTrace(e);
		}
		catch(Throwable e)
		{
			LogMessage.logStackTrace(e);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ajax/getPhysician.html")
	public void getPhysicianDetails(HttpServletRequest request,HttpServletResponse response) {
		try
		{
			String physicianName=request.getParameter("userNameVal");
			List list=loginService.searchUserByUserName(physicianName);
			if(list!=null && list.size()>0)
			{
				request.getSession().setAttribute("physicianList", list);
			}	
			request.getRequestDispatcher("/WEB-INF/jsps/ajax/getPhysicianDetails.jsp").forward(request, response);
		}
		catch(IOException e)
		{
			LogMessage.logStackTrace(e);
		}
		catch(ServletException e)
		{
			LogMessage.logStackTrace(e);
		}
		catch(Throwable e)
		{
			LogMessage.logStackTrace(e);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ajax/getMap.html")
	public @ResponseBody String getMapDetails(HttpServletRequest request,HttpServletResponse response) {
		try
		{
			String user=request.getParameter("userNameVal");
			List physicianList=(List)request.getSession().getAttribute("physicianList");
			PhysicianBean physician=null;
			for(int i=0;i<physicianList.size();i++)
			{
				physician=(PhysicianBean)physicianList.get(i);
				if(physician.getUserID().equals(Long.parseLong(user)))
				{
					break;
				}	
			}	
			
			PatientBean patientbean=(PatientBean)request.getSession().getAttribute("userInfo");
			//request.getSession().setAttribute("physician",physician);
			addLatitudeAndLongitude( request,response,patientbean);
			addLatitudeAndLongitude(request,response,physician);
			
			request.getSession().setAttribute("patientName", patientbean.getFirstName()+" "+patientbean.getLastName());
			//request.getSession().setAttribute("patientAddr", patientbean.getAddressLine1()+",+"+patientbean.getCity()+",+"+patientbean.getState()+",+"+patientbean.getZipCode());
			request.getSession().setAttribute("physicianName", physician.getFirstName()+" "+physician.getLastName());
			//request.getSession().setAttribute("physicianAddr", physician.getAddressLine1()+",+"+physician.getCity()+",+"+physician.getState()+",+"+physician.getZipCode());
			//request.getRequestDispatcher("/WEB-INF/jsps/ajax/getAddressXml.jsp").forward(request, response);
		}
		/*catch(IOException e)
		{
			LogMessage.logStackTrace(e);
		}
		catch(ServletException e)
		{
			LogMessage.logStackTrace(e);
		}*/
		catch(Throwable e)
		{
			LogMessage.logStackTrace(e);
		}
		return "true";
	}
	
	private void addLatitudeAndLongitude(HttpServletRequest request,HttpServletResponse response,UserInfoBean infoBean)
	{
		URL xmlSource;
		try {
			String add=(infoBean.getAddressLine1()+",+"+infoBean.getCity()+",+"+infoBean.getState()+",+"+infoBean.getZipCode()).replaceAll("[\\s]+","+");
			String address="http://where.yahooapis.com/geocode?appid=X.Yi4S_V34F5dlmH4jb3b_CRid2FuuMcIJTEjU2Xm_Xr7lPMvkuDUmtAyGChbEEluHH.EA--&q="+add;
			//address=response.encodeUrl(address);
			
			//String address="http://where.yahooapis.com/geocode?appid=X.Yi4S_V34F5dlmH4jb3b_CRid2FuuMcIJTEjU2Xm_Xr7lPMvkuDUmtAyGChbEEluHH.EA--&line1=38%20Clearway%20Street,%20Apt%2001&line2=Boston,MA,02115";
			//xmlSource = new URL("http://where.yahooapis.com/geocode?location=701+First+Ave,+Sunnyvale,+CA&appid=X.Yi4S_V34F5dlmH4jb3b_CRid2FuuMcIJTEjU2Xm_Xr7lPMvkuDUmtAyGChbEEluHH.EA--");
			xmlSource = new URL(address);
		
		
			HttpClient client=new HttpClient();
			GetMethod get=new GetMethod(xmlSource.toString());
			client.executeMethod(get);
			String string=get.getResponseBodyAsString();
			LogMessage.logDebugMessage(string, "INFO");
			if(infoBean instanceof PatientBean)
			{	
				request.getSession().setAttribute("patientLat",getValues(string,"/ResultSet/Result/latitude"));
				request.getSession().setAttribute("patientLong",getValues(string,"/ResultSet/Result/longitude"));
				request.getSession().setAttribute("patientLoc",add);
				
			}
			else if(infoBean instanceof PhysicianBean)
			{
				request.getSession().setAttribute("physicianLat",getValues(string,"/ResultSet/Result/latitude"));
				request.getSession().setAttribute("physicianLong",getValues(string,"/ResultSet/Result/longitude"));
				request.getSession().setAttribute("physicianLoc",add);				
			}	

			//return	get.getResponseBodyAsString();		
			} catch (MalformedURLException e) {
				LogMessage.logStackTrace(e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LogMessage.logStackTrace(e);
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				LogMessage.logStackTrace(e);
			}
			
        return ;
		
	}
	
	private String getValues(String string,String xpathString) throws XPathExpressionException
	{
		XPathFactory xpacFac=XPathFactory.newInstance();
		XPath xpac=xpacFac.newXPath();
		//XPathExpression xPress=xpac.compile("/rss/channel/item");
		XPathExpression xPress=xpac.compile(xpathString);
		Reader fis=new StringReader(string);
		InputSource  source=new InputSource(fis);		
		Node node=(Node)xPress.evaluate( source, XPathConstants.NODE);
		int i=0;
		String value=node.getFirstChild().getNodeValue();;
		
		return value;
	}
	
	private String getXml()
	{
		URL xmlSource;
		try {
			xmlSource = new URL("http://localhost:8085/HealthCarev1/test3.jsp");
		
			HttpClient client=new HttpClient();
			GetMethod get=new GetMethod(xmlSource.toString());
			client.executeMethod(get);
			return	get.getResponseBodyAsString();		
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        return null;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/mail.html")
	public void getEmail(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		PatientBean patient=null;
		PhysicianBean physician=null;
		AppointmentBean appointment=null;
		
		
		 appointment=(AppointmentBean)request.getSession().getAttribute("app");
		 physician=(PhysicianBean)request.getSession().getAttribute("physician");
		 patient=(PatientBean)request.getSession().getAttribute("patient");
		 request.getRequestDispatcher("/mail.jsp").forward(request, response);
		 
	}
	
	public void generateMailDTO(PatientBean patient,PhysicianBean physician,AppointmentBean appointment,HttpServletRequest request)
	{
		MailDTO mailDTO=new MailDTO();
		mailDTO.setAddressTO(patient.getEmail());
		mailDTO.setSubject("Your Appointment has been scheduled");
		mailDTO.setFromAddress("www.healthcareservices.care@gmail.com");
		
		request.getSession().setAttribute("app", appointment);
		request.getSession().setAttribute("patient", patient);
		request.getSession().setAttribute("physician", physician);		
		URL xmlSource;
		try {
			xmlSource = new URL("http://localhost:8085/HealthCarev1/mail.html");
		
			HttpClient client=new HttpClient();
			GetMethod get=new GetMethod(xmlSource.toString());
			client.executeMethod(get);			
			mailDTO.setMailBody("Dear "+patient.getFullName()+",\\nAppointment has been confirmed with"+physician.getFullName());
			MailUtil.sendMail(mailDTO);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
