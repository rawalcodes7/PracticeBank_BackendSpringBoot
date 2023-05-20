package com.rawal.demo_bank.exception;

import java.time.LocalDateTime;

import lombok.Data;


@Data
public class ErrorInfo  {
	private String ErrorMessage;
	private Integer ErrorCode;
	private LocalDateTime Timestamp;
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public Integer getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(Integer errorCode) {
		ErrorCode = errorCode;
	}
	public LocalDateTime getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		Timestamp = timestamp;
	}
	
	
}
