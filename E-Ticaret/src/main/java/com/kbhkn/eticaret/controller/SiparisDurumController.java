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

import com.kbhkn.eticaret.model.SiparisDurum;
import com.kbhkn.eticaret.service.SiparisDurumService;

@Controller
@RequestMapping("/admin/siparisDurums")
@SessionAttributes("logonUser")
public class SiparisDurumController {
	private static final Logger logger = LoggerFactory.getLogger(SiparisController.class);
	
	@Autowired
	private SiparisDurumService siparisDurumService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllSiparisDurums(HttpSession session, ModelMap model) {
		model.addAttribute("siparisDurum", new SiparisDurum());
		model.addAttribute("allSiparisDurums", siparisDurumService.getAllSiparisDurums());
		logger.info("Sipariş Durumları listelendi.");
		return "admin/siparisDurums/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addSiparisDurum(@Valid SiparisDurum siparisDurum, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("Hatalı sipariş durumu eklemesi yapıldı.");
			return "admin/siparisDurums/list";
		}

		siparisDurumService.addSiparisDurum(siparisDurum);
		logger.info("{} isimli yeni sipariş durumu eklendi.", siparisDurum.getDurum());
		return "redirect:/admin/siparisDurums/list";
	}

	@RequestMapping(value = "/deletesiparisdurum/{siparisDurumID}", method = RequestMethod.GET)
	public String deleteSiparisDurum(@PathVariable("siparisDurumID") Integer siparisDurumID) {
		siparisDurumService.deleteSiparisDurum(siparisDurumID);
		logger.info("{} nolu ID'ye sahip sipariş durumu kaldırıldı.", siparisDurumID);
		return "redirect:/admin/siparisDurums/list";
	}

	@RequestMapping(value = "/siparisdurumguncelle/{siparisDurumID}", method = RequestMethod.POST)
	public String editSiparisDurum(@Valid SiparisDurum siparisDurum, BindingResult result, @PathVariable("siparisDurumID") Integer siparisDurumID, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} nolu ID'ye sahip sipariş durumu güncelleme sırasında hata oluştu", siparisDurumID);
			return "admin/siparisDurums/list";
		}

		siparisDurumService.updateSiparisDurum(siparisDurum);
		logger.info("{} nolu sipariş güncellendi. Yeni özellikleri: {}", siparisDurumID ,siparisDurum.toString());
		return "redirect:/admin/siparisDurums/list";
	}
	
	public void setSiparisDurumService(SiparisDurumService siparisDurumService) {
		this.siparisDurumService = siparisDurumService;
	}
}
