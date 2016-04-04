package com.kbhkn.eticaret.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kbhkn.eticaret.service.YetkiService;

@Controller
public class YetkiController {
	private static final Logger logger = LoggerFactory.getLogger(YetkiController.class);

	@Autowired
	private YetkiService yetkiService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllYetkissPage(Model model) {
//		yetkiService.addYetki(new Yetki("şiğüöç"));
		model.addAttribute("allYetkis", yetkiService.getAllYetkis());
		logger.info("Welcome home! The client locale is {}.", model);
		return "home";
	}

	public void setYetkiService(YetkiService yetkiService) {
		this.yetkiService = yetkiService;
	}
}
