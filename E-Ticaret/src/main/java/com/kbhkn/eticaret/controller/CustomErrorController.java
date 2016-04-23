package com.kbhkn.eticaret.controller;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kbhkn.eticaret.util.IPGetir;

@Controller
public class CustomErrorController{
	private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);
	
	@RequestMapping(value = "/error/404", method = RequestMethod.GET)
	public String pageNotFound(HttpServletRequest request) {
		logger.info("404 Hatası işlendi. İstek IP: {}", IPGetir.getClientRealIpAdress(request));
		return "error/404";
	}
	
	@RequestMapping(value = "/error/app-error2", method = RequestMethod.GET)
	public String applicationError(HttpServletRequest request, HttpServletResponse response, Model model) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String exceptionMessage = getExceptionMessage(throwable, statusCode);

		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		
		if (requestUri == null)
			requestUri = "Unknown";

		String message = MessageFormat.format("Hata Kodu: {0}, {1} adresine istek sırasında, {2} hatası oluştu.", statusCode, requestUri, exceptionMessage);
		model.addAttribute("errorMessage", message);
		logger.info("Uygulama Hatası!. İstek IP: {}, Hata: {}", IPGetir.getClientRealIpAdress(request), message);
		return "error/app-error";
	}

	private String getExceptionMessage(Throwable throwable, Integer statusCode) {
		return (throwable != null)  ?  throwable.getMessage() : HttpStatus.valueOf(statusCode).getReasonPhrase();
	}
}
