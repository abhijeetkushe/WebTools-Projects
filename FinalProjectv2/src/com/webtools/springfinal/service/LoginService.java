package com.webtools.springfinal.service;

import java.util.List;

import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.bean.UserAccountBean;
import com.webtools.springfinal.bean.UserInfoBean;
import com.webtools.springfinal.dao.exception.LoginDAOException;
import com.webtools.springfinal.service.exception.AppointmentServiceException;
import com.webtools.springfinal.service.exception.InvalidLoginException;
import com.webtools.springfinal.service.exception.LoginServiceException;

public interface LoginService {

	public void checkAndInsertUpdateUser(UserInfoBean userInfo) throws LoginServiceException;
	public UserAccountBean validateUser(UserAccountBean userAccount) throws LoginServiceException,InvalidLoginException;
	public void insertUserAccount(UserAccountBean userAccount) throws LoginServiceException;
	public UserInfoBean getUserInfo(UserAccountBean userAccount) throws LoginServiceException;
	public boolean checkUserExists(String userName) throws LoginServiceException;
	
	public void createAndUpdateAppointment(AppointmentBean appointment) throws AppointmentServiceException;
	public void createAndUpdateDiagnosis(DiagnosisBean diagnosis) throws AppointmentServiceException;
	public List searchUserByUserName(String username)throws AppointmentServiceException;
}
