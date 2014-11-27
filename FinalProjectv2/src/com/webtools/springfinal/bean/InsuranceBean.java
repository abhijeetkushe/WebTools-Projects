package com.webtools.springfinal.bean;

import java.util.Date;

import com.webtools.generic.AbstractDTO;

public class InsuranceBean extends AbstractDTO {

	private boolean checked;
	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	private Long insuranceId;
	private String insuranceName;
	private String policyName;
	private Date startDate;
	private Date endDate;
	private PatientBean patientBean;
	/**
	 * @return the diagnosisId
	 */
	public Long getInsuranceId() {
		return insuranceId;
	}
	/**
	 * @return the patientBean
	 */
	public PatientBean getPatientBean() {
		return patientBean;
	}
	/**
	 * @param patientBean the patientBean to set
	 */
	public void setPatientBean(PatientBean patientBean) {
		this.patientBean = patientBean;
	}
	/**
	 * @param diagnosisId the diagnosisId to set
	 */
	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}
	/**
	 * @return the insuranceName
	 */
	public String getInsuranceName() {
		return insuranceName;
	}
	/**
	 * @param insuranceName the insuranceName to set
	 */
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	/**
	 * @return the policyName
	 */
	public String getPolicyName() {
		return policyName;
	}
	/**
	 * @param policyName the policyName to set
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
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
	
}
