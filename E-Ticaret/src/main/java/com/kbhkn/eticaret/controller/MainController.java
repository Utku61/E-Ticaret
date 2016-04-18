package com.kbhkn.eticaret.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("logonUser")
public class MainController {
	
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public String listUruns(HttpSession session, ModelMap model) {
		return "redirect:/musteri/index";
	}
}
