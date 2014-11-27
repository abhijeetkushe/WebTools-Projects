package com.webtools.springfinal.bean;

import java.util.Date;
import java.util.List;

import com.webtools.generic.AbstractDTO;

public class DiagnosisBean extends AbstractDTO {
	private long diagnosisId;

	private AppointmentBean appointment;
	private Boolean healthCheckRequired;
	private List<MedicineBean> medicineList;
	private String description;
	private List<DocumentBean> documentBeanList;
	private float weight;
	private int bloodPressure;
	private int pulse;
	private double temperature;
	private Date dateDiagnosis=new Date();
	/**
	 * @return the dateDiagnosis
	 */
	public Date getDateDiagnosis() {
		return dateDiagnosis;
	}
	/**
	 * @param dateDiagnosis the dateDiagnosis to set
	 */
	public void setDateDiagnosis(Date dateDiagnosis) {
		this.dateDiagnosis = dateDiagnosis;
	}
	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	/**
	 * @return the bloodPressure
	 */
	public int getBloodPressure() {
		return bloodPressure;
	}
	/**
	 * @param bloodPressure the bloodPressure to set
	 */
	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	/**
	 * @return the pulse
	 */
	public int getPulse() {
		return pulse;
	}
	/**
	 * @param pulse the pulse to set
	 */
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	/**
	 * @return the documentBeanList
	 */
	public List<DocumentBean> getDocumentBeanList() {
		return documentBeanList;
	}
	/**
	 * @param documentBeanList the documentBeanList to set
	 */
	public void setDocumentBeanList(List<DocumentBean> documentBeanList) {
		this.documentBeanList = documentBeanList;
	}
	/**
	 * @param medicineList the medicineList to set
	 */
	public void setMedicineList(List<MedicineBean> medicineList) {
		this.medicineList = medicineList;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the medicineSet
	 */
	public List<MedicineBean> getMedicineList() {
		return medicineList;
	}
	
	/**
	 * @return the diagnosisId
	 */
	public long getDiagnosisId() {
		return diagnosisId;
	}
	/**
	 * @param diagnosisId the diagnosisId to set
	 */
	public void setDiagnosisId(long diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	/**
	 * @return the appointment
	 */
	public AppointmentBean getAppointment() {
		return appointment;
	}
	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(AppointmentBean appointment) {
		this.appointment = appointment;
	}
	/**
	 * @return the healthCheckRequired
	 */
	public Boolean getHealthCheckRequired() {
		return healthCheckRequired;
	}
	/**
	 * @param healthCheckRequired the healthCheckRequired to set
	 */
	public void setHealthCheckRequired(Boolean healthCheckRequired) {
		this.healthCheckRequired = healthCheckRequired;
	} 
}
