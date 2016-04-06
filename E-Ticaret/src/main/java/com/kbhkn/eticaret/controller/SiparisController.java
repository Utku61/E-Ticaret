package com.kbhkn.eticaret.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kbhkn.eticaret.model.Siparis;
import com.kbhkn.eticaret.service.SiparisService;

@Controller
@RequestMapping("/admin/siparis")
@SessionAttributes("logonUser")
public class SiparisController {
	private static final Logger logger = LoggerFactory.getLogger(SiparisController.class);
	
	@Autowired
	private SiparisService siparisService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllSiparis(HttpSession session, ModelMap model) {
		model.addAttribute("siparis", new Siparis());
		model.addAttribute("allSipariss", siparisService.getAllSipariss());
		logger.info("Siparişler listelendi.");
		return "admin/siparis/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addSiparis(@Valid Siparis siparis, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("Hatalı sipariş eklemesi yapıldı.");
			return "admin/siparis/list";
		}

		siparisService.addSiparis(siparis);
		logger.info("{} numaralı ID'ye sahip sipariş verildi.", siparis.getSiparisID());
		return "redirect:/admin/siparis/list";
	}

	@RequestMapping(value = "/deletesiparis/{siparisID}", method = RequestMethod.GET)
	public String deleteSiparis(@PathVariable("siparisID") Integer siparisID) {
		siparisService.deleteSiparis(siparisID);
		logger.info("{} nolu ID'ye sahip sipariş kaldırıldı.", siparisID);
		return "redirect:/admin/siparis/list";
	}

	@RequestMapping(value = "/siparisguncelle/{siparisID}", method = RequestMethod.POST)
	public String editSiparis(@Valid Siparis siparis, BindingResult result, @PathVariable("siparisID") Integer siparisID, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} nolu ID'ye sahip siparişi güncelleme sırasında hata oluştu", siparisID);
			return "admin/siparis/list";
		}

		siparisService.updateSiparis(siparis);
		logger.info("{} nolu sipariş güncellendi. Yeni özellikleri: {}", siparisID ,siparis.toString());
		return "redirect:/admin/siparis/list";
	}
	
	public void setSiparisService(SiparisService siparisService) {
		this.siparisService = siparisService;
	}
}
