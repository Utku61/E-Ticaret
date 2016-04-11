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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.kbhkn.eticaret.model.AltKategori;
import com.kbhkn.eticaret.model.Kategori;
import com.kbhkn.eticaret.model.UstKategori;
import com.kbhkn.eticaret.service.KategoriService;

@Controller
@EnableWebMvc
@RequestMapping("/admin/kategoris")
public class KategoriController {
	private static final Logger logger = LoggerFactory.getLogger(KategoriController.class);

	@Autowired
	private KategoriService kategoriService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllKategoris(HttpSession session, ModelMap model) {
		model.addAttribute("subCategory", new AltKategori());
		model.addAttribute("category", new Kategori());
		model.addAttribute("upCategory", new UstKategori());
		model.addAttribute("allAltKategoris", kategoriService.getAllAltKategoris());
		model.addAttribute("allKategoris", kategoriService.getAllKategoris());
		model.addAttribute("allUstKategoris", kategoriService.getAllUstKategoris());
		logger.info("Tüm Kategoriler listelendi.");
		return "admin/kategori";
	}
	
	@RequestMapping(value = "/altkategori/new", method = RequestMethod.POST)
	public String addAltKategori(@Valid AltKategori subCategory, BindingResult result, ModelMap model) {
		System.out.println(subCategory.getAltKategoriAdi());
		if (result.hasErrors()) {
			logger.info("Hatalı altKatagori eklemesi yapıldı. Hatalı kategori adı: {}", subCategory.getAltKategoriAdi());
			return "admin/kategori";
		}
		
		kategoriService.addAltKategori(subCategory);
		logger.info("{} altkategorisi eklendi.", subCategory.getAltKategoriAdi());
		return "redirect:/admin/kategoris/list";
	}
	
	@RequestMapping(value = "/kategori/new", method = RequestMethod.POST)
	public String addKategori(@Valid Kategori category, BindingResult result, ModelMap model){
		if (result.hasErrors()) {
			logger.info("Hatalı Katagori eklemesi yapıldı. Hatalı kategori adı: {}", category.getKategoriAdi());
			return "admin/kategori";
		}
		kategoriService.addKategori(category);
		logger.info("{} kategorisi eklendi.", category.getKategoriAdi());
		return "redirect:/admin/kategoris/list";
	}
	
	@RequestMapping(value = "/ustkategori/new", method = RequestMethod.POST)
	public String addUstKategori(@Valid UstKategori upCategory, BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
			logger.info("Hatalı üstKatagori eklemesi yapıldı. Hatalı kategori adı: {}", upCategory.getUstKategoriAdi());
			return "admin/kategori";
		}
		
		kategoriService.addUstKategori(upCategory);
		logger.info("{} üstkategorisi eklendi.", upCategory.getUstKategoriAdi());
		return "redirect:/admin/kategoris/list";
	}
	
	@RequestMapping(value = "/deletealtkatagori/{altKategoriID}", method = RequestMethod.GET)
	public String deleteAltKategori(@PathVariable("altKategoriID") Integer altKategoriID) {
		kategoriService.deleteAltKategori(altKategoriID);
		logger.info("{}'ye sahip altkategori kaldırıldı.", altKategoriID);
		return "redirect:/admin/kategoris/list";
	}
	
	@RequestMapping(value = "/deletekatagori/{katagoriID}", method = RequestMethod.GET)
	public String deleteKategori(@PathVariable("katagoriID") Integer katagoriID) {
		kategoriService.deleteKategori(katagoriID);
		logger.info("{}'ye sahip kategori kaldırıldı.", katagoriID);
		return "redirect:/admin/kategoris/list";
	}
	
	@RequestMapping(value = "/deleteustkatagori/{ustKategoriID}", method = RequestMethod.GET)
	public String deleteUstKategori(@PathVariable("ustKategoriID") Integer ustKategoriID) {
		kategoriService.deleteUstKategori(ustKategoriID);
		logger.info("{}'ye sahip ustkategori kaldırıldı.", ustKategoriID);
		return "redirect:/admin/kategoris/list";
	}
	
	@RequestMapping(value = "/altkatagoriguncelle", method = RequestMethod.POST)
	public String editAltKategori(@Valid AltKategori altKatagori, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} altkategorisini güncelleme sırasında hata oluştu", altKatagori.getAltKategoriAdi());
			return "admin/kategori";
		}
		
		kategoriService.updateAltKategori(altKatagori);
		logger.info("{} altkategorisi güncellendi.", altKatagori.getAltKategoriAdi());
		return "redirect:/admin/kategoris/list";
	}

	@RequestMapping(value = "/katagoriguncelle", method = RequestMethod.POST)
	public String editKategori(@Valid Kategori katagori, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} kategorisini güncelleme sırasında hata oluştu", katagori.getKategoriAdi());
			return "admin/kategori";
		}
		
		kategoriService.updateKategori(katagori);
		logger.info("{} kategorisi güncellendi.", katagori.getKategoriAdi());
		return "redirect:/admin/kategoris/list";
	}
	
	@RequestMapping(value = "/ustkatagoriguncelle", method = RequestMethod.POST)
	public String editUstKategori(@Valid UstKategori ustKatagori, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} üstkategorisini güncelleme sırasında hata oluştu", ustKatagori.getUstKategoriAdi());
			return "admin/kategori";
		}
		
		kategoriService.updateUstKategori(ustKatagori);
		logger.info("{} üstkategorisi güncellendi.", ustKatagori.getUstKategoriAdi());
		return "redirect:/admin/kategoris/list";
	}

	public void setKategoriService(KategoriService kategoriService) {
		this.kategoriService = kategoriService;
	}
}
