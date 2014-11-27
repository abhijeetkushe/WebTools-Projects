package com.webtools.springfinal.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.webtools.springfinal.authorities.GrantedAuthorityDoctor;
import com.webtools.springfinal.authorities.GrantedAuthorityPatient;
import com.webtools.springfinal.authorities.GrantedAuthorityUser;
import com.webtools.springfinal.authorities.HealthCareGrantedAuthority;
import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.bean.UserAccountBean;
import com.webtools.springfinal.bean.UserInfoBean;
import com.webtools.springfinal.dao.AppointmentDAO;
import com.webtools.springfinal.dao.LoginDAO;
import com.webtools.springfinal.dao.exception.AppointmentDAOException;
import com.webtools.springfinal.dao.exception.LoginDAOException;
import com.webtools.springfinal.logger.LogMessage;
import com.webtools.springfinal.service.LoginService;
import com.webtools.springfinal.service.exception.AppointmentServiceException;
import com.webtools.springfinal.service.exception.InvalidLoginException;
import com.webtools.springfinal.service.exception.LoginServiceException;



public class LoginServiceImpl implements LoginService,UserDetailsService{

	
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		List users = loginDAO.validateUserByUserName(username);
		if (users.size() == 0)
			throw new UsernameNotFoundException(username);
		com.webtools.springfinal.bean.UserAccountBean user = (com.webtools.springfinal.bean.UserAccountBean) users.get(0);
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), 
				true, true, true, true, this.getGrantedAuthority(user.getRoles()));
	}

	private LoginDAO loginDAO;
	private AppointmentDAO appointmentDAO;
	
	/**
	 * @return the appointmentDAO
	 */
	public AppointmentDAO getAppointmentDAO() {
		return appointmentDAO;
	}

	/**
	 * @param appointmentDAO the appointmentDAO to set
	 */
	public void setAppointmentDAO(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}

	/**
	 * @return the loginDAO
	 */
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	/**
	 * @param loginDAO the loginDAO to set
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	/*
	 * 
	 * Method created for Ajax+Check user name validity Support(non-Javadoc)
	 * @see com.webtools.springfinal.service.LoginService#checkUserExists(java.lang.String)
	 */
	@Override
	public boolean checkUserExists(String userName)
			throws LoginServiceException {
		boolean returnValue=false;
		try
		{
			List list=loginDAO.validateUserByUserName(userName);
			if(list!=null && list.size()>0)
			{
				returnValue=true;
			}	
		}
		catch(DataAccessException e)
		{
			returnValue=true;
		}
		
		return returnValue;
	}

	/* (non-Javadoc)Method which is called if ajax check fails or if the user is directly created without validating userExistance
	 * @see com.webtools.springfinal.service.LoginService#checkAndInsertUpdateUser(com.webtools.springfinal.bean.UserInfoBean)
	 */
	public void checkAndInsertUpdateUser(UserInfoBean userInfo) throws LoginServiceException
	{
		try
		{
			if((userInfo.getMode()!=null && "add".equals(userInfo.getMode()) && userInfo!=null && userInfo.getUserAccount()!=null && !this.checkUserExists(userInfo.getUserAccount().getUserName()))||"edit".equals(userInfo.getMode()))
			{
				loginDAO.insertAndUpdateUser(userInfo);
			}
			else
			{
				LogMessage.logErrorMessage("Invalid User is returned","ERROR"); 
				throw new LoginServiceException("Invalid User");
			}
		}
		catch(LoginDAOException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			throw new LoginServiceException(e.getMessage());
		}
		finally
		{
			
		}
	}
	

	@Override
	public UserInfoBean getUserInfo(UserAccountBean userAccount)
			throws LoginServiceException {
		try
		{
			return loginDAO.getUserInfo(userAccount);
		}
		catch(LoginDAOException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
		
			throw new LoginServiceException(e.getMessage());
		}
		
	}
	
	
	/* (non-Javadoc)Deprecated
	 * @see com.webtools.springfinal.service.LoginService#validateUser(com.webtools.springfinal.bean.UserAccountBean)
	 */
	@Deprecated
	public UserAccountBean validateUser(UserAccountBean userAccount) throws LoginServiceException,InvalidLoginException
	{
		try
		{
			return loginDAO.validateUser(userAccount);
		}
		catch(LoginDAOException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
		
			throw new LoginServiceException(e.getMessage());
		}
		finally
		{
			
		}
	}
	
	@Override
	@Deprecated
	public void insertUserAccount(UserAccountBean userAccount)
			throws LoginServiceException {
		// TODO Auto-generated method stub
		try
		{
			loginDAO.insertUserAccount(userAccount);
		}
		catch(LoginDAOException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
		
			throw new LoginServiceException(e.getMessage());
		} 
		finally
		{
			
		}
	}

	
	private GrantedAuthority[] getGrantedAuthority(Set<String> roles)
	{
		GrantedAuthority[] grantedAuths=new GrantedAuthority[roles.size()];
		int count=0;
		for(String role:roles)
		{
			HealthCareGrantedAuthority hcgAuth=HealthCareGrantedAuthority.getHealthCareGrantedAuthority(role);
			switch(hcgAuth)
			{
				case ROLE_DOCTOR:grantedAuths[count]=new GrantedAuthorityDoctor();break;
				case ROLE_USER:grantedAuths[count]=new GrantedAuthorityUser();break;
				case ROLE_PATIENT:grantedAuths[count]=new GrantedAuthorityPatient();break;
				default:continue;
			}
			count++;
		}	
		return grantedAuths;
	}

	@Override
	public void createAndUpdateAppointment(AppointmentBean appointment)
			throws AppointmentServiceException {
		// TODO Auto-generated method stub
		
		try {
			appointmentDAO.createAndUpdateAppointment(appointment);
		} catch (AppointmentDAOException e) {
			// TODO Auto-generated catch block
			LogMessage.logStackTrace(e);
			throw new AppointmentServiceException(e.getMessage());
		}
	}

	@Override
	public void createAndUpdateDiagnosis(DiagnosisBean diagnosis)throws AppointmentServiceException  {
		// TODO Auto-generated method stub
		try {
			appointmentDAO.createAndUpdateDiagnosis(diagnosis);
		} catch (AppointmentDAOException e) {
			// TODO Auto-generated catch block
			LogMessage.logStackTrace(e);
			throw new AppointmentServiceException(e.getMessage());
		}
//appointmentDAO.
	}
	
	public List searchUserByUserName(String username)throws AppointmentServiceException
	 {
		// TODO Auto-generated method stub
		try {
		return	loginDAO.searchUserByUserName(username);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			LogMessage.logStackTrace(e);
			throw new AppointmentServiceException(e.getMessage());
		}
//appointmentDAO.
	}

}
