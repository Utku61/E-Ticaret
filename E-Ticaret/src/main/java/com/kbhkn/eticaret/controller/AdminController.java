package com.kbhkn.eticaret.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kbhkn.eticaret.model.Admin;
import com.kbhkn.eticaret.service.AdminService;
import com.kbhkn.eticaret.util.IPGetir;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String adminLogin(HttpServletRequest req, ModelMap model) {
		model.addAttribute("admin",new Admin());
		logger.info("Admin login sayfaına ulaşıldı. Tarih: {},  IP: {}", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()), IPGetir.getClientRealIpAdress(req));
		return "admin/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminCheck(HttpServletRequest req, ModelMap model, @Valid Admin admin, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("Admin loginde hata! {}", admin.toString());
			return "admin/login";
		}
		Admin kontrol = adminService.getAdminControl(admin.getEposta(), admin.getParola());
		if(kontrol != null){
			req.getSession().setAttribute("admin", kontrol);
			return "redirect:/admin/index";
		}
		return "admin/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String adminLogout(HttpServletRequest req, ModelMap model) {
		logger.info("Admin çıkış yaptı. Tarih:{} ", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		req.getSession().invalidate();
		return "redirect:/admin/login";
	}
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
}
