package com.webtools.springfinal.bean;

import java.util.Date;

import com.webtools.generic.AbstractDTO;

public class MedicalHistory extends AbstractDTO {

	private Long medicalHistoryid;
	private Date startDate;
	private Date endDate;
	private String illness;
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
	private PatientBean patientbean;
	/**
	 * @return the medicalHistoryid
	 */
	public Long getMedicalHistoryid() {
		return medicalHistoryid;
	}
	/**
	 * @param medicalHistoryid the medicalHistoryid to set
	 */
	public void setMedicalHistoryid(Long medicalHistoryid) {
		this.medicalHistoryid = medicalHistoryid;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the illness
	 */
	public String getIllness() {
		return illness;
	}
	/**
	 * @param illness the illness to set
	 */
	public void setIllness(String illness) {
		this.illness = illness;
	}
}
