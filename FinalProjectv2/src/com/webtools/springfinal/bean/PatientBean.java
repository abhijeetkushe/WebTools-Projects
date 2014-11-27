package com.webtools.springfinal.bean;

import java.util.List;
import java.util.List;


public class PatientBean extends UserInfoBean {

	private long patientid;
	private List<InsuranceBean> insuranceList;
	
	private String	 allergies;
	private List<MedicalHistory> medicalHistoryList;
	private List<AppointmentBean> appointmentList;
	private String userType="PATIENT";
	/**
	 * @return the appointmentList
	 */
	public List<AppointmentBean> getAppointmentList() {
		return appointmentList;
	}
	/**
	 * @param appointmentList the appointmentList to set
	 */
	public void setAppointmentList(List<AppointmentBean> appointmentList) {
		this.appointmentList = appointmentList;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the medicalHistoryList
	 */
	public List<MedicalHistory> getMedicalHistoryList() {
		return medicalHistoryList;
	}
	/**
	 * @param medicalHistoryList the medicalHistoryList to set
	 */
	public void setMedicalHistoryList(List<MedicalHistory> medicalHistoryList) {
		this.medicalHistoryList = medicalHistoryList;
	}
	/**
	 * @return the patientid
	 */
	public long getPatientid() {
		return patientid;
	}
	/**
	 * @param patientid the patientid to set
	 */
	public void setPatientid(long patientid) {
		this.patientid = patientid;
	}
	/**
	 * @return the insuranceList
	 */
	public List<InsuranceBean> getInsuranceList() {
		return insuranceList;
	}
	/**
	 * @param insuranceList the insuranceList to set
	 */
	public void setInsuranceList(List<InsuranceBean> insuranceList) {
		this.insuranceList = insuranceList;
	}
	/**
	 * @return the allergies
	 */
	public String getAllergies() {
		return allergies;
	}
	/**
	 * @param allergies the allergies to set
	 */
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

}
