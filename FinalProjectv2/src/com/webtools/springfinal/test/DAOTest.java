package com.webtools.springfinal.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.InsuranceBean;
import com.webtools.springfinal.bean.MedicalHistory;
import com.webtools.springfinal.bean.PatientBean;
import com.webtools.springfinal.bean.PhysicianBean;
import com.webtools.springfinal.bean.UserAccountBean;
import com.webtools.springfinal.bean.UserInfoBean;
import com.webtools.springfinal.dao.impl.AppointmentDAOImpl;
import com.webtools.springfinal.dao.impl.LoginDAOImpl;
import com.webtools.springfinal.logger.LogMessage;

public class DAOTest extends TestCase {

	private SessionFactory sessionFactory = null;

	protected void setUp() throws Exception {

		Properties properties = new Properties();
		properties
				.load(new FileInputStream(
						"E:\\ABHIJEET2\\MSIS\\Webtools\\Projects_bkp2\\FinalProjectv2\\src\\com\\webtools\\springfinal\\dao\\hibernate.properties"));
		Configuration configuration = new Configuration()
				.setProperties(properties);
		configuration
				.addResource("com/webtools/springfinal/dao/impl/Hospital.hbm.xml");
		
		sessionFactory = configuration.buildSessionFactory();
	}

	public void testLoginDAO() throws Exception {
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		loginDAO.setSessionFactory(sessionFactory);
		UserInfoBean usrBean = new UserInfoBean();
		usrBean.setFirstName("Abhijeet");
		usrBean.setLastName("Kushe");
		UserAccountBean accountBean = new UserAccountBean();
		accountBean.setUserName("abhijeet.kushe");
		accountBean.setPassword("Tcs@09-10-1984");
		loginDAO.validateUser(accountBean);
		loginDAO.insertAndUpdateUser(usrBean);
	} 

	public void testMain() throws Exception
	{
		
		InsertValuesController.main(null);
	}
	public void testInsertPatient() throws Exception {
		try {
			LoginDAOImpl loginDAO = new LoginDAOImpl();
			loginDAO.setSessionFactory(sessionFactory);
			UserAccountBean accountBean = new UserAccountBean();
			accountBean.setUserName("gautam.telang6");
			accountBean.setPassword("Tcs@09-10-1984");
			Set roles=new HashSet<String>();
			roles.add("ROLE_USER");
			roles.add("ROLE_DOCTOR");
			roles.add("ROLE_PATIENT");
			accountBean.setRoles(roles);			
			PatientBean usrBean = new PatientBean();
			usrBean.setFirstName("Prathamesh");
			usrBean.setLastName("Rane");
			usrBean.setAddressLine1("38 Clearway Street,Apt 01");
			usrBean.setCity("Boston");
			usrBean.setUserAccount(accountBean);
			
			//usrBean.setAllergies("Rash");
			AppointmentBean appointmentBean=new AppointmentBean();
			appointmentBean.setAppointmentType("URGENT");
			appointmentBean.setIllnessStartDate(new Date());
			appointmentBean.setNatureOfIllness("Fever");
			appointmentBean.setPhysicianCategory("ADULT-WOMEN");
			appointmentBean.setSymptoms("");
			appointmentBean.setCreationDate(new Date());
			appointmentBean.setPatientbean(usrBean);
			List<AppointmentBean> appointmentList=new ArrayList<AppointmentBean>(10);
			//usrBean.setAppointmentList(appointmentList);
			
			List<MedicalHistory> medicalHistoryList=new ArrayList<MedicalHistory>();
			MedicalHistory history=new MedicalHistory();
			history.setStartDate(new Date());
			history.setEndDate(new Date());
			history.setIllness("Fever");
			history.setPatientbean(usrBean);
			medicalHistoryList.add(history);
			usrBean.setMedicalHistoryList(medicalHistoryList);
			
			List<InsuranceBean> insuranceList=new ArrayList<InsuranceBean>();
			InsuranceBean insurance=new InsuranceBean();
			insurance.setEndDate(new Date());
			insurance.setInsuranceName("Tata AIG");
			insurance.setPatientBean(usrBean);
			insurance.setPolicyName("LITTAID");
			insuranceList.add(insurance);
			usrBean.setInsuranceList(insuranceList);
			
			
			//history.setStartDate(startDate);
						//loginDAO.validateUser(accountBean);
			loginDAO.insertPatient(usrBean);
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
			throw e;
		}
	}
	
	
	public void testInsertPhysician() throws Exception {
		try {
			LoginDAOImpl loginDAO = new LoginDAOImpl();
			loginDAO.setSessionFactory(sessionFactory);
			UserAccountBean accountBean = new UserAccountBean();
			accountBean.setUserName("prasad.shirodkar1");
			accountBean.setPassword("Tcs@09-10-1984");
			Set roles=new HashSet<String>();
			roles.add("ROLE_USER");
			roles.add("ROLE_DOCTOR");
			roles.add("ROLE_PATIENT");
			accountBean.setRoles(roles);			
			PhysicianBean usrBean = new PhysicianBean();
			usrBean.setFirstName("Prathamesh");
			usrBean.setLastName("Rane");
			usrBean.setAddressLine1("38 Clearway Street,Apt 01");
			usrBean.setCity("Boston");
			usrBean.setUserAccount(accountBean);
			
			//usrBean.setAllergies("Rash");
			AppointmentBean appointmentBean=new AppointmentBean();
			appointmentBean.setAppointmentType("URGENT");
			appointmentBean.setIllnessStartDate(new Date());
			appointmentBean.setNatureOfIllness("Fever");
			appointmentBean.setPhysicianCategory("ADULT-WOMEN");
			appointmentBean.setSymptoms("");
			appointmentBean.setCreationDate(new Date());
			appointmentBean.setPhysician(usrBean);
			List<AppointmentBean> appointmentList=new ArrayList<AppointmentBean>(10);
			usrBean.setAppointmentList(appointmentList);
			/*
			List<MedicalHistory> medicalHistoryList=new ArrayList<MedicalHistory>();
			MedicalHistory history=new MedicalHistory();
			history.setStartDate(new Date());
			history.setEndDate(new Date());
			history.setIllness("Fever");
			history.setPatientbean(usrBean);
			medicalHistoryList.add(history);
			usrBean.setMedicalHistoryList(medicalHistoryList);
			*/
			/*List<InsuranceBean> insuranceList=new ArrayList<InsuranceBean>();
			InsuranceBean insurance=new InsuranceBean();
			insurance.setEndDate(new Date());
			insurance.setInsuranceName("Tata AIG");
			insurance.setPatientBean(usrBean);
			insurance.setPolicyName("LITTAID");
			insuranceList.add(insurance);
			usrBean.setInsuranceList(insuranceList);*/
			
			
			//history.setStartDate(startDate);
						//loginDAO.validateUser(accountBean);
			loginDAO.insertPatient(usrBean);
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
			throw e;
		}
	}
	

	/*
	 * Please enable assertions for this class to run this testcase
	 * */
	public void getUser() throws Exception
	{
		try
		{
			LoginDAOImpl loginDAO = new LoginDAOImpl();
			loginDAO.setSessionFactory(sessionFactory);
			UserAccountBean accountBean = new UserAccountBean();
			accountBean.setUserName("prasad.shirodkar1");
			accountBean.setPassword("Tcs@09-10-1984");
			UserAccountBean returnedaccountBean=loginDAO.validateUser(accountBean);
			this.assertNotNull(returnedaccountBean.getAccountID());
			this.assertEquals(accountBean.getUserName(), returnedaccountBean.getUserName());
			this.assertEquals(accountBean.getPassword(),returnedaccountBean.getPassword());
			UserInfoBean userInfo=loginDAO.getUserInfo(returnedaccountBean);
			assert(userInfo instanceof PhysicianBean):"The userInfo is not an Patient.So the logic failed";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
			
		}
	}
	
	public void testcreateAndUpdateAppointment() throws Exception
	{
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		AppointmentDAOImpl appointmentDAO=new AppointmentDAOImpl();
		loginDAO.setSessionFactory(sessionFactory);
		appointmentDAO.setSessionFactory(sessionFactory);
		
		AppointmentBean appointmentBean=new AppointmentBean();
		appointmentBean.setAppointmentType("IMMEDIATE");
		appointmentBean.setCreationDate(new Date());
		appointmentBean.setPhysicianCategory("ADULT-MEN");
		appointmentBean.setSymptoms("Wound");
		appointmentBean.setIllnessStartDate(new Date());
		appointmentBean.setNatureOfIllness("URGENT");
		appointmentBean.setCreationDate(new Date());
		
		UserAccountBean accountBean = new UserAccountBean();
		accountBean.setUserName("gautam.telang6");
		accountBean.setPassword("Tcs@09-10-1984");
		accountBean=loginDAO.validateUser(accountBean);
		UserInfoBean patientBean=loginDAO.getUserInfo(accountBean);
		if(patientBean instanceof PatientBean)
		{	
			appointmentBean.setPatientbean((PatientBean)patientBean);
		}	
		
		
		appointmentDAO.createAndUpdateAppointment(appointmentBean);
		
		
		
	}
	
	public void testScheduleAppointment() throws Exception
	{
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		AppointmentDAOImpl appointmentDAO=new AppointmentDAOImpl();
		loginDAO.setSessionFactory(sessionFactory);
		appointmentDAO.setSessionFactory(sessionFactory);

		UserAccountBean accountBean = new UserAccountBean();
		accountBean.setUserName("gautam.telang6");
		accountBean.setPassword("Tcs@09-10-1984");
		accountBean=loginDAO.validateUser(accountBean);
		UserInfoBean patientBean=loginDAO.getUserInfo(accountBean);
		
		AppointmentBean appointbean=new AppointmentBean();
		if(patientBean instanceof PatientBean)
		{	
			List<AppointmentBean> appointmentmentList=appointmentDAO.getAppointmentbyPatient((PatientBean)patientBean);
			if(appointmentmentList!=null && appointmentmentList.size()>0)
			{
				appointbean=appointmentmentList.get(0);
			}	
			
		}	
		UserAccountBean accountBean1 = new UserAccountBean();
		accountBean1.setUserName("prasad.shirodkar1");
		accountBean1.setPassword("Tcs@09-10-1984");
		accountBean1=loginDAO.validateUser(accountBean1);
		UserInfoBean physicianBean=loginDAO.getUserInfo(accountBean1);
		if(physicianBean instanceof PhysicianBean)
		{
			appointbean.setPhysician((PhysicianBean)physicianBean);
		}
		appointmentDAO.scheduleAppointment(appointbean);
		//appointmentBean.setPhysician(physicianBean);
		//appointmentDAO.getAppointments();
	}

	public void testCreateAndUpdateDiagnosis() throws Exception
	{
		LoginDAOImpl loginDAO = new LoginDAOImpl();
		AppointmentDAOImpl appointmentDAO=new AppointmentDAOImpl();
		loginDAO.setSessionFactory(sessionFactory);
		appointmentDAO.setSessionFactory(sessionFactory);

		UserAccountBean accountBean = new UserAccountBean();
		accountBean.setUserName("gautam.telang6");
		accountBean.setPassword("Tcs@09-10-1984");
		accountBean=loginDAO.validateUser(accountBean);
		UserInfoBean patientBean=loginDAO.getUserInfo(accountBean);
		
		AppointmentBean appointbean=new AppointmentBean();
		if(patientBean instanceof PatientBean)
		{	
			List<AppointmentBean> appointmentmentList=appointmentDAO.getAppointmentbyPatient((PatientBean)patientBean);
			if(appointmentmentList!=null && appointmentmentList.size()>0)
			{
				appointbean=appointmentmentList.get(0);
			}	
			
		}	
		UserAccountBean accountBean1 = new UserAccountBean();
		accountBean1.setUserName("abhijeet.kushe3");
		accountBean1.setPassword("Tcs@09-10-1984");
		accountBean1=loginDAO.validateUser(accountBean1);
		UserInfoBean physicianBean=loginDAO.getUserInfo(accountBean1);
		if(physicianBean instanceof PhysicianBean)
		{
			appointbean.setPhysician((PhysicianBean)physicianBean);
		}
		appointmentDAO.scheduleAppointment(appointbean);
		//appointmentBean.setPhysician(physicianBean);
		//appointmentDAO.getAppointments();
	}
	
	public void testImage()
	{
		try
		{
			byte[] bytes=new byte[4000];
			InputStream is=new FileInputStream("E:\\ABHIJEET2\\imagesUS\\questionMark.JPG");
			while(-1!=is.read(bytes));
			{
				
				System.out.println("[");
				for(int i=0;i<bytes.length;i++)
				{	
					System.out.print(bytes[i]+",");
				}
				System.out.println("]");
			}
			
		
			/*OutputStream os=new FileOutputStream("C:\\test.jpeg");
			os.write(image);
			os.close();*/
		}
		catch(IOException e)
		{
			LogMessage.logStackTrace(e);
		}
			
	}

	public void testCreateImageFrombyte()
	{
		try
		{
			byte[] byteImage={-1,-40,-1,-32,0,16,74,70,73,70,0,1,1,1,0,96,0,96,0,0,-1,-37,0,67,0,8,6,6,7,6,5,8,7,7,7,9,9,8,10,12,20,13,12,11,11,12,25,18,19,15,20,29,26,31,30,29,26,28,28,32,36,46,39,32,34,44,35,28,28,40,55,41,44,48,49,52,52,52,31,39,57,61,56,50,60,46,51,52,50,-1,-37,0,67,1,9,9,9,12,11,12,24,13,13,24,50,33,28,33,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,-1,-64,0,17,8,0,40,0,50,3,1,34,0,2,17,1,3,17,1,-1,-60,0,31,0,0,1,5,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9,10,11,-1,-60,0,-75,16,0,2,1,3,3,2,4,3,5,5,4,4,0,0,1,125,1,2,3,0,4,17,5,18,33,49,65,6,19,81,97,7,34,113,20,50,-127,-111,-95,8,35,66,-79,-63,21,82,-47,-16,36,51,98,114,-126,9,10,22,23,24,25,26,37,38,39,40,41,42,52,53,54,55,56,57,58,67,68,69,70,71,72,73,74,83,84,85,86,87,88,89,90,99,100,101,102,103,104,105,106,115,116,117,118,119,120,121,122,-125,-124,-123,-122,-121,-120,-119,-118,-110,-109,-108,-107,-106,-105,-104,-103,-102,-94,-93,-92,-91,-90,-89,-88,-87,-86,-78,-77,-76,-75,-74,-73,-72,-71,-70,-62,-61,-60,-59,-58,-57,-56,-55,-54,-46,-45,-44,-43,-42,-41,-40,-39,-38,-31,-30,-29,-28,-27,-26,-25,-24,-23,-22,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-1,-60,0,31,1,0,3,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9,10,11,-1,-60,0,-75,17,0,2,1,2,4,4,3,4,7,5,4,4,0,1,2,119,0,1,2,3,17,4,5,33,49,6,18,65,81,7,97,113,19,34,50,-127,8,20,66,-111,-95,-79,-63,9,35,51,82,-16,21,98,114,-47,10,22,36,52,-31,37,-15,23,24,25,26,38,39,40,41,42,53,54,55,56,57,58,67,68,69,70,71,72,73,74,83,84,85,86,87,88,89,90,99,100,101,102,103,104,105,106,115,116,117,118,119,120,121,122,-126,-125,-124,-123,-122,-121,-120,-119,-118,-110,-109,-108,-107,-106,-105,-104,-103,-102,-94,-93,-92,-91,-90,-89,-88,-87,-86,-78,-77,-76,-75,-74,-73,-72,-71,-70,-62,-61,-60,-59,-58,-57,-56,-55,-54,-46,-45,-44,-43,-42,-41,-40,-39,-38,-30,-29,-28,-27,-26,-25,-24,-23,-22,-14,-13,-12,-11,-10,-9,-8,-7,-6,-1,-38,0,12,3,1,0,2,17,3,17,0,63,0,-9,-85,-101,-104,44,-19,101,-71,-71,-102,56,96,-119,11,-55,36,-116,21,81,64,-55,36,-98,-126,-66,86,-15,-41,-58,-33,16,120,-110,-18,75,109,26,-30,93,39,74,-114,82,98,54,-18,82,121,87,-128,12,-114,15,29,-50,-43,-64,27,-80,119,96,26,-10,95,-114,54,-70,-67,-1,0,-61,-74,-79,-47,-20,110,-81,36,-72,-69,-119,102,-118,-38,38,-111,-68,-79,-106,-50,20,19,-115,-54,-75,-13,79,-4,32,-98,48,-1,0,-95,83,92,-1,0,-63,116,-33,-4,77,0,96,51,22,98,-52,73,98,114,73,-17,73,95,107,124,63,-16,-91,-121,-123,60,39,97,111,109,-89,-59,109,123,45,-76,70,-10,64,-65,60,-78,-19,-53,110,39,-109,-122,45,-128,122,103,3,20,-65,16,-12,-99,35,88,-16,46,-85,22,-76,-79,-117,104,109,-34,117,-107,-79,-104,93,84,-107,117,61,-114,120,-9,-55,29,9,20,1,-13,63,-124,126,48,-8,-81,-62,-105,0,61,-21,-22,-106,68,42,-75,-83,-12,-115,32,85,4,125,-58,-50,80,-32,16,58,-81,60,-87,-64,-81,-85,60,59,-30,13,63,-59,26,21,-82,-81,-90,-53,-66,-38,-31,3,0,113,-71,15,116,96,9,-61,3,-63,21,-16,-91,125,33,-5,53,-91,-32,-16,-18,-72,-18,-51,-10,35,118,-126,33,-98,4,-127,62,127,-48,-57,-7,10,0,-10,-6,40,-94,-128,10,40,-94,-128,57,-33,22,-8,-29,65,-16,69,-92,115,-21,119,77,19,76,-82,109,-31,-114,54,119,-104,-96,4,-86,-32,96,30,64,-53,16,57,28,-118,-7,123,-30,31,-59,77,91,-57,-18,-74,-46,67,29,-106,-109,19,-84,-79,89,-82,28,-121,10,70,-10,-109,0,-109,-13,55,3,3,24,-29,35,39,-36,-2,48,124,56,-42,62,32,-1,0,99,127,100,-36,-40,-61,-10,31,63,-52,-5,83,-70,-25,127,-105,-116,109,86,-2,-31,-21,-114,-43,-49,-4,53,-8,35,-88,-8,95,-59,-55,-85,-8,-126,77,46,-14,27,120,-104,-37,-92,18,59,-107,-101,35,12,67,32,24,3,119,-48,-32,-10,-56,0,-13,-33,8,124,16,-15,79,-120,46,-19,-91,-44,-19,31,74,-46,-28,95,49,-25,-100,-88,-112,-82,113,-75,99,-50,-32,-57,-74,-32,6,6,125,1,-6,-101,74,-46,-20,-76,77,42,-37,76,-45,-96,88,45,45,-93,17,-59,26,-10,3,-41,-44,-98,-92,-98,73,36,-102,-71,69,0,20,81,69,0,69,109,113,21,-27,-84,55,48,62,-8,102,69,-110,54,-63,25,82,50,14,15,61,42,90,40,-86,-102,-76,-102,20,93,-46,103,-107,-4,104,-16,-9,-116,-4,69,109,-92,-37,120,80,93,60,0,78,47,-93,-122,-15,96,87,7,-53,-40,24,51,46,-31,-61,-6,-29,-15,-84,127,-125,62,16,-15,-25,-123,-4,67,114,-66,33,-118,-22,-33,71,54,110,35,-123,-17,-110,88,-60,-59,-48,-126,17,92,-32,-32,55,56,-11,-11,-94,-118,-111,-98,-39,69,20,80,1,69,20,80,7,-1,-39,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
			OutputStream os=new FileOutputStream("C:\\test.jpeg");
			os.write(byteImage);
			os.close();
		}
		catch(IOException e)
		{
			LogMessage.logStackTrace(e);
		}
	}
}
