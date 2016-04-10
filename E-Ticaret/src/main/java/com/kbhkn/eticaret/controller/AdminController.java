package com.kbhkn.eticaret.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kbhkn.eticaret.service.AdminService;

@Controller
@RequestMapping("/admin")
@SessionAttributes("logonUser")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listAllSiparis(HttpSession session, ModelMap model) {
		model.addAttribute("checkSiparisList", adminService.getBekleyenSiparisKontrol());
		logger.info("Admin dashboard'a düştü");
		return "admin/index";
	}
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
}
