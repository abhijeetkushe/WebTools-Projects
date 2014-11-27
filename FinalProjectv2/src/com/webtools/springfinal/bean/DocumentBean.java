package com.webtools.springfinal.bean;

import java.sql.Blob;
import java.util.List;

import com.webtools.generic.AbstractDTO;

public class DocumentBean extends AbstractDTO {

	private Long documentId;
	private String documentdesc;
	private byte[] document;
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
	 * @return the documentId
	 */
	public Long getDocumentId() {
		return documentId;
	}
	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(byte[] document) {
		this.document = document;
	}

	
	/**
	 * @return the documentdesc
	 */
	public String getDocumentdesc() {
		return documentdesc;
	}
	/**
	 * @return the document
	 */
	public byte[] getDocument() {
		return document;
	}
	/**
	 * @param documentdesc the documentdesc to set
	 */
	public void setDocumentdesc(String documentdesc) {
		this.documentdesc = documentdesc;
	}

}
