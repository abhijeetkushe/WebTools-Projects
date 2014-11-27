package com.webtools.springfinal.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.bean.DocumentBean;
import com.webtools.springfinal.bean.PatientBean;
import com.webtools.springfinal.bean.PhysicianBean;
import com.webtools.springfinal.dao.AppointmentDAO;
import com.webtools.springfinal.dao.exception.AppointmentDAOException;
import com.webtools.springfinal.logger.LogMessage;

public class AppointmentDAOImpl extends HibernateDaoSupport implements AppointmentDAO{

	public void createAndUpdateAppointment(AppointmentBean appointmentBean) throws AppointmentDAOException	{
		getHibernateTemplate().saveOrUpdate(appointmentBean);
		/*Session session=null;
		Transaction tx=null;
		try
		{
			session=super.getSessionFactory().openSession();
			tx=session.beginTransaction();
			session.save(appointmentBean);
		}
		catch(HibernateException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			tx.rollback();
			throw new AppointmentDAOException(e.getMessage());
		}
		finally
		{
			if(!tx.wasRolledBack())
			{
				tx.commit();
			}
			session.close();
		}*/
	}
	


public void scheduleAppointment(AppointmentBean appointment) throws AppointmentDAOException 
{
	//this.getHibernateTemplate().update(appointment);
	Session session=null;
	Transaction tx=null;
	try
	{
		session=super.getSessionFactory().openSession();
		tx=session.beginTransaction();
		session.saveOrUpdate(appointment);
	}
	catch(HibernateException e)
	{
		LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
		tx.rollback();
		throw new AppointmentDAOException(e.getMessage());
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


public void createAndUpdateDiagnosis(DiagnosisBean diagbean) throws AppointmentDAOException
{
	this.getHibernateTemplate().saveOrUpdate(diagbean);
	/*Session session=null;
	Transaction tx=null;
	try
	{
		session=super.getSessionFactory().openSession();
		tx=session.beginTransaction();
		session.saveOrUpdate(diagbean);
	}
	catch(HibernateException e)
	{
		LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
		tx.rollback();
		throw new AppointmentDAOException(e.getMessage());
	}
	finally
	{
		if(!tx.wasRolledBack())
		{
			tx.commit();
		}
		session.close();
	}*/
}

public List getDiagnosisDetails(AppointmentBean appointmentBean) throws AppointmentDAOException
{
	try
	{
		//return getHibernateTemplate().findByNamedQueryAndNamedParam("com.webtools.springfinal.bean.DiagnosisBean", "appointment", appointmentBean);
		
		Session session=null;
		Transaction tx=null;
		List returnList=null;
		try
		{
			session=super.getSessionFactory().openSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from DiagnosisBean as diag where diag.appointment = :appointment");
			query.setParameter("appointment", appointmentBean);
			DiagnosisBean diagBean=(DiagnosisBean)query.uniqueResult();
			returnList=new ArrayList(1);
			returnList.add(diagBean);
			return returnList;
		}
		catch(HibernateException e)
		{
			LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
			tx.rollback();
			throw new AppointmentDAOException(e.getMessage());
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
	catch(DataAccessException exception)
	{
		throw new AppointmentDAOException(exception);
	}

}

public List getAllAttachedDocument(PhysicianBean physicianBean) throws AppointmentDAOException
{
	Session session=null;
	Transaction tx=null;
	try
	{
		session=super.getSessionFactory().openSession();
		tx=session.beginTransaction();
		SQLQuery query=session.createSQLQuery("SELECT doc.document_id, doc.document_desc, doc.document"
											+"FROM document doc, diagnosis_documents docdiag, diagnosis diag"
											+"WHERE docdiag.document_id = doc.document_id"
											+"AND diag.diagnosis_id = docdiag.diagnosis_id"
											+"AND diag.user_id = ?");
		query.addEntity(DocumentBean.class);
		query.setLong(0, physicianBean.getUserID());
		List<DocumentBean> documentBeanList=query.list();
		
		return documentBeanList;
	}
	catch(HibernateException e)
	{
		LogMessage.logErrorMessage(LogMessage.returnStackTrace(e), "ERROR");
		tx.rollback();
		throw new AppointmentDAOException(e.getMessage());
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

public List getAppointments()
{
	List<AppointmentBean> returnAppointmentBean=null;
	returnAppointmentBean=getHibernateTemplate().findByNamedQuery("com.webtools.springfinal.bean.appointment.SearchAllAppointment");
	return returnAppointmentBean;
}

public List getAppointmentbyPatient(PatientBean patientBean)
{
	List<AppointmentBean> returnAppointmentBean=null;
	returnAppointmentBean=getHibernateTemplate().findByNamedQueryAndNamedParam("com.webtools.springfinal.bean.appointment.SearchAppointmentByPatient","patient",patientBean);
	return returnAppointmentBean;
}


}