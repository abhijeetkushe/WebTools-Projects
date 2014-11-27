package com.webtools.springfinal.bean;

import java.sql.Blob;
import java.util.List;

import com.webtools.generic.AbstractDTO;

public class MedicineBean extends AbstractDTO {

	private boolean checked;
	private long medicineId;

	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked
	 *            the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	private long quantity;

	private String medicineName;
	private String medicineIngredients;
	private Blob medicineImage;
	private long quantityPrescribed;
	private DiagnosisBean diagnosis;

	/**
	 * @return the diagnosis
	 */
	public DiagnosisBean getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(DiagnosisBean diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * @return the quantityPrescribed
	 */
	public long getQuantityPrescribed() {
		return quantityPrescribed;
	}

	/**
	 * @param quantityPrescribed
	 *            the quantityPrescribed to set
	 */
	public void setQuantityPrescribed(long quantityPrescribed) {
		this.quantityPrescribed = quantityPrescribed;
	}

	private DiagnosisBean diagnosisBean;

	/**
	 * @return the diagnosisBean
	 */
	public DiagnosisBean getDiagnosisBean() {
		return diagnosisBean;
	}

	/**
	 * @param diagnosisBean
	 *            the diagnosisBean to set
	 */
	public void setDiagnosisBean(DiagnosisBean diagnosisBean) {
		this.diagnosisBean = diagnosisBean;
	}

	/**
	 * @return the medicineName
	 */
	public String getMedicineName() {
		return medicineName;
	}

	/**
	 * @param medicineName
	 *            the medicineName to set
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	/**
	 * @return the medicineIngredients
	 */
	public String getMedicineIngredients() {
		return medicineIngredients;
	}

	/**
	 * @param medicineIngredients
	 *            the medicineIngredients to set
	 */
	public void setMedicineIngredients(String medicineIngredients) {
		this.medicineIngredients = medicineIngredients;
	}

	/**
	 * @return the medicineImage
	 */
	public Blob getMedicineImage() {
		return medicineImage;
	}

	/**
	 * @param medicineImage
	 *            the medicineImage to set
	 */
	public void setMedicineImage(Blob medicineImage) {
		this.medicineImage = medicineImage;
	}

	/**
	 * @return the medicineId
	 */
	public long getMedicineId() {
		return medicineId;
	}

	/**
	 * @param medicineId
	 *            the medicineId to set
	 */
	public void setMedicineId(long medicineId) {
		this.medicineId = medicineId;
	}

	/**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
