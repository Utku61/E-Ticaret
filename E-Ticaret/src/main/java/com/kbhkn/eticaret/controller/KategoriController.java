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

import com.kbhkn.eticaret.model.Katagori;
import com.kbhkn.eticaret.service.KategoriService;

@Controller
@RequestMapping("/admin/kategoris")
@SessionAttributes("logonUser")
public class KategoriController {
	private static final Logger logger = LoggerFactory.getLogger(KategoriController.class);

	@Autowired
	private KategoriService kategoriService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllKategoris(HttpSession session, ModelMap model) {
		model.addAttribute("kategori", new Katagori());
		model.addAttribute("allKategoris", kategoriService.getAllKatagoris());
		logger.info("Kategoriler listelendi.");
		return "admin/kategoris/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addKategori(@Valid Katagori katagori, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			logger.info("Hatalı katagori eklemesi yapıldı. Hatalı kategori adı: {}", katagori.getKatagoriAdi());
			return "admin/kategoris/list";
		}
		
		kategoriService.addKatagori(katagori);
		logger.info("{} kategorisi eklendi.", katagori.getKatagoriAdi());
		return "redirect:/admin/kategoris/list";
	}
	
	@RequestMapping(value = "/deletekatagori/{katagoriID}", method = RequestMethod.GET)
	public String deleteKategori(@PathVariable("katagoriID") Integer katagoriID) {
		kategoriService.deleteKatagori(katagoriID);
		logger.info("{}'ye sahip kategori kaldırıldı.", katagoriID);
		return "redirect:/admin/kategoris/list";
	}

	@RequestMapping(value = "/katagoriguncelle/{katagoriID}", method = RequestMethod.POST)
	public String editKategori(@Valid Katagori katagori, BindingResult result, @PathVariable("katagoriID") Integer katagoriID, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} kategorisini güncelleme sırasında hata oluştu", katagori.getKatagoriAdi());
			return "admin/kategoris/list";
		}
		
		kategoriService.updateKatagori(katagori);
		logger.info("{} kategorisi güncellendi. Yeni Kategori adı: {}", katagori.getKatagoriAdi(), kategoriService.getKatagoriById(katagori.getKatagoriID()).getKatagoriAdi());
		return "redirect:/admin/kategoris/list";
	}

	public void setKategoriService(KategoriService kategoriService) {
		this.kategoriService = kategoriService;
	}
}
