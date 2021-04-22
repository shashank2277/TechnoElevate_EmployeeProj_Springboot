package com.te.springboot.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeConfigController {
//	@ExceptionHandler(EmployeeExp.class)
//	public String handleExp(EmployeeExp exp, HttpServletRequest request) {
//		request.setAttribute("err", exp.getMessage());
//		return "errPage";
//	}
}
