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

import com.kbhkn.eticaret.model.OdemeSecenek;
import com.kbhkn.eticaret.service.OdemeSecenekService;

@Controller
@RequestMapping("/admin/odemeseceneks")
@SessionAttributes("logonUser")
public class OdemeSecenekController {
	private static final Logger logger = LoggerFactory.getLogger(MusteriController.class);

	@Autowired
	private OdemeSecenekService odemeSecenekService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllOdemeSeceneks(HttpSession session, ModelMap model) {
		model.addAttribute("odemeSecenek", new OdemeSecenek());
		model.addAttribute("allOdemeSeceneks", odemeSecenekService.getAllOdemeSeceneks());
		logger.info("Ödeme Seçenekleri listelendi.");
		return "admin/odemeSecenek";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addOdemeSecenek(@Valid OdemeSecenek odemeSecenek, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			logger.info("Hatalı ödeme seçeneği eklemesi yapıldı.");
			return "admin/odemeSecenek";
		}

		odemeSecenekService.addOdemeSecenek(odemeSecenek);
		logger.info("{} ödeme seçeneği eklendi.", odemeSecenek.getOdemeTipi());
		return "redirect:/admin/odemeseceneks/list";
	}

	@RequestMapping(value = "/deleteodemesecenegi/{odemeSecenekID}", method = RequestMethod.GET)
	public String deleteOdemeSecenek(@PathVariable("odemeSecenekID") Integer odemeSecenekID) {
		odemeSecenekService.deleteOdemeSecenek(odemeSecenekID);
		logger.info("{}'ye sahip ödeme seçeneği kaldırıldı.", odemeSecenekID);
		return "redirect:/admin/odemeseceneks/list";
	}

	@RequestMapping(value = "/odemesecenekguncelleme", method = RequestMethod.POST)
	public String editOdemeSecenek(@Valid OdemeSecenek odemeSecenek, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} ödeme seçeneğini güncelleme sırasında hata oluştu", odemeSecenek.getOdemeTipi());
			return "admin/odemeseceneks/list";
		}

		odemeSecenekService.updateOdemeSecenek(odemeSecenek);
		logger.info("{} ödeme seçeneğini güncellendi. Yeni tip: {}", odemeSecenek.getOdemeTipi(),
				odemeSecenekService.getOdemeSecenekById(odemeSecenek.getOdemeSecenekID()).getOdemeTipi());
		return "redirect:/admin/odemeseceneks/list";
	}

	public void setOdemeSecenekService(OdemeSecenekService odemeSecenekService) {
		this.odemeSecenekService = odemeSecenekService;
	}
}
