package com.webtools.springfinal.bean;

import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.webtools.generic.AbstractDTO;

public class AppointmentBean extends AbstractDTO{

	private Long appointmentId;
	private PatientBean patientbean;
	@NotEmpty(message="No Nature of Illness is entered")	
	private String natureOfIllness;
	@NotEmpty(message="No Symptoms is entered")	
	private String symptoms;
	private Date illnessStartDate;
	private Date creationDate=new Date();
	private String appointmentType;
	private String physicianCategory;
	private String physicianName;
	private Long physicianID;
	/**
	 * @return the physicianID
	 */
	public Long getPhysicianID() {
		return physicianID;
	}
	/**
	 * @param physicianID the physicianID to set
	 */
	public void setPhysicianID(Long physicianID) {
		this.physicianID = physicianID;
	}
	/**
	 * @return the physicianName
	 */
	public String getPhysicianName() {
		return physicianName;
	}
	/**
	 * @param physicianName the physicianName to set
	 */
	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}
	/**
	 * @return the appointmentList
	 */

	private PhysicianBean physician;
	private List<DiagnosisBean> diagnosisList;
	/**
	 * @return the diagnosisList
	 */
	public List<DiagnosisBean> getDiagnosisList() {
		return diagnosisList;
	}
	/**
	 * @param diagnosisList the diagnosisList to set
	 */
	public void setDiagnosisList(List<DiagnosisBean> diagnosisList) {
		this.diagnosisList = diagnosisList;
	}
	/**
	 * @return the physician
	 */
	public PhysicianBean getPhysician() {
		return physician;
	}
	/**
	 * @param physician the physician to set
	 */
	public void setPhysician(PhysicianBean physician) {
		this.physician = physician;
	}
	/**
	 * @return the symptoms
	 */
	public String getSymptoms() {
		return symptoms;
	}
	/**
	 * @param symptoms the symptoms to set
	 */
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	/**
	 * @return the illnessStartDate
	 */
	public Date getIllnessStartDate() {
		return illnessStartDate;
	}
	/**
	 * @param illnessStartDate the illnessStartDate to set
	 */
	public void setIllnessStartDate(Date illnessStartDate) {
		this.illnessStartDate = illnessStartDate;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the appointmentType
	 */
	public String getAppointmentType() {
		return appointmentType;
	}
	/**
	 * @param appointmentType the appointmentType to set
	 */
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	/**
	 * @return the physicianCategory
	 */
	public String getPhysicianCategory() {
		return physicianCategory;
	}
	/**
	 * @param physicianCategory the physicianCategory to set
	 */
	public void setPhysicianCategory(String physicianCategory) {
		this.physicianCategory = physicianCategory;
	}
	/**
	 * @return the appointmentId
	 */
	public Long getAppointmentId() {
		return appointmentId;
	}
	/**
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	/**
	 * @return the patientbean
	 */
	public PatientBean getPatientbean() {
		return patientbean;
	}
	/**
	 * @param patientbean the patientbean to set
	 */
	public void setPatientbean(PatientBean patientbean) {
		this.patientbean = patientbean;
	}
	/**
	 * @return the natureOfIllness
	 */
	public String getNatureOfIllness() {
		return natureOfIllness;
	}
	/**
	 * @param natureOfIllness the natureOfIllness to set
	 */
	public void setNatureOfIllness(String natureOfIllness) {
		this.natureOfIllness = natureOfIllness;
	}
	
}
