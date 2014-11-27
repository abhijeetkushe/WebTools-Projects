package com.webtools.springfinal.dao;

import com.webtools.springfinal.bean.AppointmentBean;
import com.webtools.springfinal.bean.DiagnosisBean;
import com.webtools.springfinal.dao.exception.AppointmentDAOException;

public interface AppointmentDAO {

	void createAndUpdateAppointment(AppointmentBean appointmentBean) throws AppointmentDAOException;
	void scheduleAppointment(AppointmentBean appointment) throws AppointmentDAOException ;
	void createAndUpdateDiagnosis(DiagnosisBean diagbean) throws AppointmentDAOException;

}
