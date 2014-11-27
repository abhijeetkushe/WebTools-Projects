package com.webtools.springfinal.service;

import java.util.List;
import java.util.Map;

import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.bean.MedicineBean;
import com.webtools.springfinal.bean.PhysicianBean;
import com.webtools.springfinal.bean.UserAccountBean;
import com.webtools.springfinal.service.exception.AppointmentServiceException;

public interface HealthCareFacade {
	
	public Map<String,AppointmentBean> getAppointmentDetails();

	public void createAndUpdateAppointment(AppointmentBean appointment) throws AppointmentServiceException;
	public void scheduleAppointment(AppointmentBean appointment);

	
	public void createAndUpdateDiagnosis(DiagnosisBean diagnosis);
	public void getDocumentsAttached(DiagnosisBean appointment);
	public Map getAllAttachedDocuments(PhysicianBean physicianBean);
	public Map<String,DiagnosisBean> getDiagnosisDetails(AppointmentBean appointment);
	
	//Webservice Calls MedWorm and Google Map
	public List<MedicineBean> getMedicineInfo(String medicineName);
	public String getDirections(AppointmentBean appointment);
	//WebService call for GoogleCalendar
	public void getCalendarAppointments(UserAccountBean userAccount);
	public void getAppointMentFeed(AppointmentBean appointment);
	public void sendEmail(AppointmentBean appointment);

	Map<String, DiagnosisBean> viewDiagnosis(AppointmentBean appointment);

}
