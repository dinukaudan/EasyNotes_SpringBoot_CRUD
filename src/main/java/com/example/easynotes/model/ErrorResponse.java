package com.example.easynotes.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author udan
 *
 */
@Entity
public class ErrorResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String errorResponseIs;
	private String content;
	private String title;
	private String errorCode;
	private String errorDescription;
	public String getErrorResponseIs() {
		return errorResponseIs;
	}
	public void setErrorResponseIs(String errorResponseIs) {
		this.errorResponseIs = errorResponseIs;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ErrorResponse [errorResponseIs=" + errorResponseIs + ", content=" + content + ", title=" + title
				+ ", errorCode=" + errorCode + ", errorDescription=" + errorDescription + "]";
	}
	

}
