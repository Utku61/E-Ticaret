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

import com.kbhkn.eticaret.model.Yetki;
import com.kbhkn.eticaret.service.YetkiService;

@Controller
@RequestMapping("/admin/yetkis/")
@SessionAttributes("logonUser")
public class YetkiController {
	private static final Logger logger = LoggerFactory.getLogger(YetkiController.class);
	
	@Autowired
	private YetkiService yetkiService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllYetkis(HttpSession session, ModelMap model) {
		model.addAttribute("yetki", new Yetki());
		model.addAttribute("allYetkis", yetkiService.getAllYetkis());
		model.addAttribute("name", "Hakan");
		logger.info("Yetkiler listelendi.");
		return "admin/yetki";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addYetki(@Valid Yetki yetki, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("Hatalı yetki eklemesi yapıldı.");
			return "admin/yetkis/list";
		}
		yetkiService.addYetki(yetki);
		logger.info("{} isimli yeni yetki eklendi.", yetki.toString());
		return "redirect:/admin/yetkis/list";
	}

	@RequestMapping(value = "/deleteyetki/{yetkiID}", method = RequestMethod.GET)
	public String deleteYetki(@PathVariable("yetkiID") Integer yetkiID) {
		yetkiService.deleteYetki(yetkiID);
		logger.info("{} nolu ID'ye sahip yetkiID kaldırıldı.", yetkiID);
		return "redirect:/admin/yetkis/list";
	}

	@RequestMapping(value = "/yetkiguncelle", method = RequestMethod.POST)
	public String editYetki(@Valid Yetki yetki, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} nolu ID'ye sahip yetki güncelleme sırasında hata oluştu", yetki.getYetkiNo());
			return "admin/yetkis/list";
		}

		yetkiService.updateYetki(yetki);
		logger.info("{} nolu yetki güncellendi. Yeni özellikleri: {}", yetki.getYetkiNo() , yetki.toString());
		return "redirect:/admin/yetkis/list";
	}
	
	public void setYetkiService(YetkiService yetkiService) {
		this.yetkiService = yetkiService;
	}
}
