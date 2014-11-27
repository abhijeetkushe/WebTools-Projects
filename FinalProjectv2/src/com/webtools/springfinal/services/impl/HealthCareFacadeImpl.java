package com.webtools.springfinal.services.impl;

import java.util.List;
import java.util.Map;

import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.bean.MedicineBean;
import com.webtools.springfinal.bean.PhysicianBean;
import com.webtools.springfinal.bean.UserAccountBean;
import com.webtools.springfinal.dao.AppointmentDAO;
import com.webtools.springfinal.dao.exception.AppointmentDAOException;
import com.webtools.springfinal.logger.LogMessage;
import com.webtools.springfinal.service.HealthCareFacade;
import com.webtools.springfinal.service.exception.AppointmentServiceException;

public class HealthCareFacadeImpl implements HealthCareFacade {

	private AppointmentDAO appointmentDAO;
	@Override
	public Map<String, AppointmentBean> getAppointmentDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getCalendarAppointments(UserAccountBean userAccount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAndUpdateAppointment(AppointmentBean appointment)throws AppointmentServiceException {
		try
		{
			appointmentDAO.createAndUpdateAppointment(appointment);
		}
		catch(AppointmentDAOException appointmentDAO)
		{
			LogMessage.logErrorMessage(appointmentDAO.getMessage(), "ERROR");
			throw new AppointmentServiceException(appointmentDAO.getMessage());
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void scheduleAppointment(AppointmentBean appointment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAppointMentFeed(AppointmentBean appointment) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAndUpdateDiagnosis(DiagnosisBean diagnosis) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, DiagnosisBean> viewDiagnosis(AppointmentBean appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getDocumentsAttached(DiagnosisBean appointment) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MedicineBean> getMedicineInfo(String medicineName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDirections(AppointmentBean appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getAllAttachedDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, DiagnosisBean> getDiagnosisDetails(
			AppointmentBean appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendEmail(AppointmentBean appointment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map getAllAttachedDocuments(PhysicianBean physicianBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
