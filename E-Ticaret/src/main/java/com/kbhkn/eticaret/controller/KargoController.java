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

import com.kbhkn.eticaret.model.Kargo;
import com.kbhkn.eticaret.service.KargoService;

@Controller
@RequestMapping("/admin/kargos")
@SessionAttributes("logonUser")
public class KargoController {
	private static final Logger logger = LoggerFactory.getLogger(KargoController.class);
	
	@Autowired
	private KargoService kargoService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllKargos(HttpSession session, ModelMap model) {
		model.addAttribute("kargo", new Kargo());
		model.addAttribute("allKargos", kargoService.getAllKargos());
		logger.info("Kargolar listelendi.");
		return "admin/kargo";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addKargo(@Valid Kargo kargo, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			logger.info("Hatalı kargo eklemesi yapıldı.");
			return "admin/kargo";
		}
		
		kargoService.addKargo(kargo);
		logger.info("{} kargo şirketi eklendi.", kargo.getAd());
		return "redirect:/admin/kargos/list";
	}
	
	@RequestMapping(value = "/deletekargo/{kargoId}", method = RequestMethod.GET)
	public String deleteKargo(@PathVariable("kargoId") Integer kargoId) {
		kargoService.deleteKargo(kargoId);
		logger.info("{}'ye sahip kargo şirketi kaldırıldı.", kargoId);
		return "redirect:/admin/kargos/list";
	}

	@RequestMapping(value = "/kargoguncelle", method = RequestMethod.POST)
	public String editKargo(@Valid Kargo kargo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} şirketini güncelleme sırasında hata oluştu", kargo.getAd());
			return "admin/kargo";
		}
		
		kargoService.updateKargo(kargo);
		logger.info("{} şirketi güncellendi. Yeni açıklaması: {}", kargo.getAd(), kargo.getAciklama());
		return "redirect:/admin/kargos/list";
	}
	
	public void setKargoService(KargoService kargoService) {
		this.kargoService = kargoService;
	}
}
