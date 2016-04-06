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

import com.kbhkn.eticaret.model.Sehir;
import com.kbhkn.eticaret.service.SehirService;

@Controller
@RequestMapping("/admin/sehirs")
@SessionAttributes("logonUser")
public class SehirController {
	private static final Logger logger = LoggerFactory.getLogger(SehirController.class);

	@Autowired
	private SehirService sehirService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllSehirs(HttpSession session, ModelMap model) {
		model.addAttribute("sehir", new Sehir());
		model.addAttribute("allSehirs", sehirService.getAllSehirs());
		logger.info("Şehirler listelendi.");
		return "admin/sehirs/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addSehir(@Valid Sehir sehir, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("Hatalı şehir eklemesi yapıldı.");
			return "admin/sehirs/list";
		}

		sehirService.addSehir(sehir);
		logger.info("{} şehiri eklendi.", sehir.getSehirAdi());
		return "redirect:/admin/sehirs/list";
	}

	@RequestMapping(value = "/deletesehir/{sehirID}", method = RequestMethod.GET)
	public String deleteSehir(@PathVariable("sehirID") Integer sehirID) {
		sehirService.deleteSehir(sehirID);
		logger.info("{}'ye sahip şehir kaldırıldı.", sehirID);
		return "redirect:/admin/sehirs/list";
	}

	@RequestMapping(value = "/sehirguncelle/{sehirID}", method = RequestMethod.POST)
	public String editSehir(@Valid Sehir sehir, BindingResult result, @PathVariable("sehirID") Integer sehirID, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} şehrini güncelleme sırasında hata oluştu", sehir.getSehirAdi());
			return "admin/sehirs/list";
		}

		sehirService.updateSehir(sehir);
		logger.info("{} şehri güncellendi. Yeni şehir: {}", sehir.getSehirAdi(),sehirService.getSehirById(sehirID).getSehirAdi());
		return "redirect:/admin/sehirs/list";
	}

	public void setSehirService(SehirService sehirService) {
		this.sehirService = sehirService;
	}
}
