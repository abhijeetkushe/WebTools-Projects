package com.webtools.springfinal.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.webtools.springfinal.bean.UserAccountBean;
import com.webtools.springfinal.bean.UserInfoBean;
import com.webtools.springfinal.dao.exception.LoginDAOException;
import com.webtools.springfinal.service.exception.InvalidLoginException;

public interface LoginDAO {

	public void insertAndUpdateUser(UserInfoBean userInfo) throws LoginDAOException;
	public UserAccountBean validateUser(UserAccountBean userAccount) throws LoginDAOException,InvalidLoginException;
	public UserInfoBean getUserInfo(UserAccountBean userAccount) throws LoginDAOException;
	public void insertUserAccount(UserAccountBean userAccount) throws LoginDAOException;
	public List validateUserByUserName(String userName);
	public List searchUserByUserName(String username) throws DataAccessException;
}
