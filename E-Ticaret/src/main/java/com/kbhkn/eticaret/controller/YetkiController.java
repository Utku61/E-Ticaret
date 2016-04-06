package com.kbhkn.eticaret.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kbhkn.eticaret.service.KategoriService;
import com.kbhkn.eticaret.service.UrunService;

@Controller
public class YetkiController {
	private static final Logger logger = LoggerFactory.getLogger(YetkiController.class);

	@Autowired
	private UrunService urunService;
	
	@Autowired
	private KategoriService kategoriService;

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String listAllYetkissPage(Model model) {
		model.addAttribute("allYetkis", kategoriService.getAllKatagoris());
		logger.info("Welcome home! The client locale is {}.", model);
		return "home";
	}
	
	@RequestMapping(value = "/musteri", method = RequestMethod.GET)
	public void SiparisPage(Model model) {
		model.addAttribute("allYetkis", urunService.getImageByUrunId(1));
		logger.info("Welcome home! The client locale is {}.", model.getClass());
		//return "home";
	}

	public void setUrunService(UrunService urunService) {
		this.urunService = urunService;
	}
	
	public void setKategoriService(KategoriService kategoriService) {
		this.kategoriService = kategoriService;
	}
}
