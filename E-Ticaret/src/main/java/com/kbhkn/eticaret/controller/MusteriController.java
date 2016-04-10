package com.kbhkn.eticaret.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kbhkn.eticaret.service.MusteriService;

@Controller
@RequestMapping("/admin/musteris")
@SessionAttributes("logonUser")
public class MusteriController {
	private static final Logger logger = LoggerFactory.getLogger(MusteriController.class);

	@Autowired
	private MusteriService musteriService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllMusteris(HttpSession session, ModelMap model) {
		model.addAttribute("allMusteris", musteriService.getAllMusteris());
		logger.info("Müşteriler listelendi.");
		return "admin/musteri";
	}
	
	@RequestMapping(value = "/deletemusteri/{musteriID}", method = RequestMethod.GET)
	public String deleteMusteri(@PathVariable("musteriID") Integer musteriID) {
		musteriService.deleteMusteri(musteriID);
		logger.info("{}'ye sahip müşteri kaldırıldı.", musteriID);
		return "redirect:/admin/musteris/list";
	}

	public void setMusteriService(MusteriService musteriService) {
		this.musteriService = musteriService;
	}
}
