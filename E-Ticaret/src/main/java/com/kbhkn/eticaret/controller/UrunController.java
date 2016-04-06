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

import com.kbhkn.eticaret.model.Urun;
import com.kbhkn.eticaret.service.UrunService;

@Controller
@RequestMapping("/admin/uruns")
@SessionAttributes("logonUser")
public class UrunController {
	private static final Logger logger = LoggerFactory.getLogger(UrunController.class);
	
	@Autowired
	private UrunService urunService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllUruns(HttpSession session, ModelMap model) {
		model.addAttribute("urun", new Urun());
		model.addAttribute("allUruns", urunService.getAllUruns());
		logger.info("Ürünler listelendi.");
		return "admin/uruns/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addUrun(@Valid Urun urun, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("Hatalı ürün eklemesi yapıldı.");
			return "admin/uruns/list";
		}

		urunService.addUrun(urun);
		logger.info("{} isimli yeni ürün eklendi.", urun.toString());
		return "redirect:/admin/uruns/list";
	}

	@RequestMapping(value = "/deleteurun/{urunID}", method = RequestMethod.GET)
	public String deleteUrun(@PathVariable("urunID") Integer urunID) {
		urunService.deleteUrun(urunID);
		logger.info("{} nolu ID'ye sahip ürün kaldırıldı.", urunID);
		return "redirect:/admin/uruns/list";
	}

	@RequestMapping(value = "/urunguncelle/{urunID}", method = RequestMethod.POST)
	public String editUrun(@Valid Urun urun, BindingResult result, @PathVariable("urunID") Integer urunID, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} nolu ID'ye sahip ürün güncelleme sırasında hata oluştu", urunID);
			return "admin/uruns/list";
		}

		urunService.updateUrun(urun);
		logger.info("{} nolu ürün güncellendi. Yeni özellikleri: {}", urunID ,urun.toString());
		return "redirect:/admin/uruns/list";
	}
	
	public void setUrunService(UrunService urunService) {
		this.urunService = urunService;
	}
}
