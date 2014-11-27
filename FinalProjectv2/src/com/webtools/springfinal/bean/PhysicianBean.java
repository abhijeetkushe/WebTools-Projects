package com.webtools.springfinal.bean;

import java.util.List;

public class PhysicianBean extends UserInfoBean{

	private long physicianId;
	private String degree="MD";
	private String field="GENTIALS";
	private List<AppointmentBean> appointmentList;
	private String physicianCategory="CHILD";
	private String userType="DOCTOR";
	
	/**
	 * @return the appointmentList
	 */
	public List<AppointmentBean> getAppointmentList() {
		return appointmentList;
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
	 * @param appointmentList the appointmentList to set
	 */
	public void setAppointmentList(List<AppointmentBean> appointmentList) {
		this.appointmentList = appointmentList;
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
	 * @return the physicianId
	 */
	public long getPhysicianId() {
		return physicianId;
	}
	/**
	 * @param physicianId the physicianId to set
	 */
	public void setPhysicianId(long physicianId) {
		this.physicianId = physicianId;
	}
	/**
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}
	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	 
}

