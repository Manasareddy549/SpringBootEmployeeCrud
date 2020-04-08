package com.cap.anurag.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cap.anurag.entity.ErrorInfo;

@ControllerAdvice
public class Exception extends Throwable {
	@ResponseBody
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value={Exception.class })
	protected ErrorInfo handleConflict(Exception ex, HttpServletRequest req)
	{
		String bodyOfResponse=ex.getMessage();
		String url=req.getRequestURL().toString();
		return new ErrorInfo(url,bodyOfResponse);
	}

}