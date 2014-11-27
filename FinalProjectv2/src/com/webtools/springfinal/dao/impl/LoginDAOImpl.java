package com.webtools.springfinal.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.webtools.springfinal.bean.PatientBean;
import com.webtools.springfinal.bean.PhysicianBean;
import com.webtools.springfinal.bean.UserAccountBean;
import com.webtools.springfinal.bean.UserInfoBean;
import com.webtools.springfinal.dao.LoginDAO;
import com.webtools.springfinal.dao.exception.LoginDAOException;
import com.webtools.springfinal.logger.LogMessage;
import com.webtools.springfinal.service.exception.InvalidLoginException;

public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO{

	public void insertAndUpdateUser(UserInfoBean userInfo) throws LoginDAOException
	{
		getHibernateTemplate().saveOrUpdate(userInfo);
	}
	
	public void insertPatient(UserInfoBean user) throws Exception
	{
		getHibernateTemplate().saveOrUpdate(user);
		/*Session session=null;
		Transaction tx=null;
		try
		{
			session=super.getSessionFactory().openSession();
			tx=session.beginTransaction();
			session.save(patient);
		}
		catch(HibernateException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			tx.rollback();
			throw new LoginDAOException(e.getMessage());
		}
		finally
		{
			if(!tx.wasRolledBack())
			{
				tx.commit();
			}
			session.close();
		}
		return ;*/
	}
	
		
	public void insertUserAccount(UserAccountBean userAccount) throws LoginDAOException
	{
		Session session=null;
		Transaction tx=null;
		try
		{
			session=super.getSessionFactory().openSession();
			tx=session.beginTransaction();
			session.save(userAccount);
		}
		catch(HibernateException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			tx.rollback();
			throw new LoginDAOException(e.getMessage());
		}
		finally
		{
			if(!tx.wasRolledBack())
			{
				tx.commit();
			}
			session.close();
		}
	}

	
	
	public UserInfoBean getUserInfo(UserAccountBean userAccount) throws LoginDAOException
	{
		Session session=null;
		Transaction tx=null;
		UserInfoBean userInfo=null;
		try
		{
			session=super.getSessionFactory().openSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("FROM UserInfoBean WHERE userAccount=?");
			query.setParameter(0, userAccount);
			userInfo=(UserInfoBean)query.uniqueResult();
			
		}
		catch(HibernateException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			tx.rollback();
			throw new LoginDAOException(e.getMessage());
		}
		finally
		{
			if(!tx.wasRolledBack())
			{
				tx.commit();
			}
			session.close();
		}
		return userInfo;
	}
	
	public UserAccountBean validateUser(UserAccountBean userAccount) throws LoginDAOException,InvalidLoginException
	{
		Session session=null;
		Transaction tx=null;
		try
		{
			/*Properties properties=new Properties();
			properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			properties.setProperty("hibernate.connection.driver_class", "oracle.jdbc.OracleDriver");
			properties.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@abhijit:1521/orcl");
			properties.setProperty("hibernate.connection.username", "webtools");
			properties.setProperty("hibernate.connection.password", "webtools");
			properties.setProperty("show_sql", "true");
			Configuration configuration=new Configuration().setProperties(properties);
			configuration.addResource("com/webtools/springfinal/dao/impl/Hospital.hbm.xml");
			sessionFactory=configuration.buildSessionFactory();*/
			session=super.getSessionFactory().openSession();
		
			tx=session.beginTransaction();
			Query accountQuery=session.createQuery("from UserAccountBean WHERE userName=? and password=?");
			accountQuery.setString(0, userAccount.getUserName());
			accountQuery.setString(1, userAccount.getPassword());
			Object queryResult=accountQuery.uniqueResult();
			
			if(queryResult==null)
			{
				throw new InvalidLoginException("Invalid Login Name/Password Entered");
			}
			else
			{
				userAccount=(UserAccountBean)queryResult;
			}
			

		}
		catch(HibernateException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			tx.rollback();
			throw new LoginDAOException(e.getMessage());
		}
		finally
		{
			if(!tx.wasRolledBack())
			{
				tx.commit();
			}
			session.close();
		}
		return userAccount;
	}
	
	
	public List validateUserByUserName(String username) throws DataAccessException {
		return getHibernateTemplate().findByNamedQueryAndNamedParam("com.webtools.springfinal.bean.account.SearchByuserName", "username", username);
	}
	

	public List searchUserByUserName(String username) throws DataAccessException {
		return getHibernateTemplate().findByNamedQueryAndNamedParam("com.webtools.springfinal.bean.physician.SearchByuserName", "username", username!=null?username.toUpperCase():"");
	}
	
	public PhysicianBean getPhysician(UserAccountBean userAccount) throws LoginDAOException
	{
		Session session=null;
		Transaction tx=null;
		PhysicianBean userInfo=null;
		try
		{
			session=super.getSessionFactory().openSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("FROM PhysicianBean WHERE userAccount=?");
			query.setEntity(0, userAccount);
			userInfo=(PhysicianBean)query.uniqueResult();
			
		}
		catch(HibernateException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			tx.rollback();
			throw new LoginDAOException(e.getMessage());
		}
		finally
		{
			if(!tx.wasRolledBack())
			{
				tx.commit();
			}
			session.close();
		}
		return userInfo;
	}
	
	
	public PatientBean getPatient(UserAccountBean userAccount) throws LoginDAOException
	{
		Session session=null;
		Transaction tx=null;
		PatientBean userInfo=null;
		try
		{
			session=super.getSessionFactory().openSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("FROM PatientBean WHERE accountID=?");
			query.setLong(0, userAccount.getAccountID());
			userInfo=(PatientBean)query.uniqueResult();
			
		}
		catch(HibernateException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			tx.rollback();
			throw new LoginDAOException(e.getMessage());
		}
		finally
		{
			if(!tx.wasRolledBack())
			{
				tx.commit();
			}
			session.close();
		}
		return userInfo;
	}
	

}
