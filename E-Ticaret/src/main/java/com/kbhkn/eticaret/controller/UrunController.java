package com.kbhkn.eticaret.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.kbhkn.eticaret.model.Urun;
import com.kbhkn.eticaret.service.KategoriService;
import com.kbhkn.eticaret.service.UrunService;

@Controller
@RequestMapping("/admin/uruns")
@SessionAttributes("logonUser")
public class UrunController {
	private static final Logger logger = LoggerFactory.getLogger(UrunController.class);
	private static SecureRandom random = new SecureRandom();
	private static String geciciPath = "/home/kbhkn/git/E-Ticaret/E-Ticaret/src/main/webapp";
	
	//session.getServletContext().getRealPath("/") for Deploy Prodections Project
	
	@Autowired
	private UrunService urunService;
	
	@Autowired
	private KategoriService kategoriService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllUruns(HttpSession session, ModelMap model) {
		model.addAttribute("urun", new Urun());
		model.addAttribute("allAltKategoris", kategoriService.getAllAltKategoris());
		model.addAttribute("allKategoris", kategoriService.getAllKategoris());
		model.addAttribute("allUstKategoris", kategoriService.getAllUstKategoris());
		model.addAttribute("allUruns", urunService.getAllUruns());
		logger.info("Ürünler listelendi.");
		return "admin/urun";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addUrun(@RequestParam("file") MultipartFile file, @ModelAttribute("urun") @Valid Urun urun, BindingResult result, ModelMap model, HttpServletRequest req) {
		if (result.hasErrors() || file.isEmpty()) {
			logger.info("Hatalı ürün eklemesi yapıldı.");
			model.addAttribute("allAltKategoris", kategoriService.getAllAltKategoris());
			model.addAttribute("allKategoris", kategoriService.getAllKategoris());
			model.addAttribute("allUstKategoris", kategoriService.getAllUstKategoris());
			model.addAttribute("allUruns", urunService.getAllUruns());
			return "admin/urun";
		}
		String resimUzantisi = FilenameUtils.getExtension(file.getOriginalFilename());
		if (!resimUzantisi.equals("jpg") && !resimUzantisi.equals("png") && !resimUzantisi.equals("jpeg")) {
			logger.info("Gönderilen resim uzantısı bekleneneden farklı! {}",resimUzantisi);
			return "admin/urun";
		}
		String sifrelenmisResimAdi = new BigInteger(130, random).toString(32).substring(0, 10).toUpperCase() + "_" +urun.getUrunAdi() + "."+resimUzantisi;
		urun.setResim(sifrelenmisResimAdi);
		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(geciciPath + "/resources/images/" + sifrelenmisResimAdi)));
	        FileCopyUtils.copy(file.getInputStream(), stream);
			stream.close();
		} catch (Exception e) {
			logger.info("{} Ürünün resmi eklenemedi! Hata: {}", sifrelenmisResimAdi, e.getMessage());
			return "admin/urun";
		}
		
		urunService.addUrun(urun);
		logger.info("{} isimli yeni ürün eklendi.", urun.toString());
		return "redirect:/admin/uruns/list";
	}

	@RequestMapping(value = "/deleteurun/{urunID}", method = RequestMethod.GET)
	public String deleteUrun(@PathVariable("urunID") Integer urunID,HttpSession session) {
		String urunResimAdi = urunService.getUrunById(urunID).getResim();
		urunService.deleteUrun(urunID);
		File resim = new File(geciciPath + "/resources/images/" + urunResimAdi);
		resim.delete();
		logger.info("{} nolu ID'ye sahip ürün kaldırıldı.", urunID);
		return "redirect:/admin/uruns/list";
	}

	@RequestMapping(value = "/urunguncelle", method = RequestMethod.POST)
	public String editUrun(@Valid Urun urun, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} nolu ID'ye sahip ürün güncelleme sırasında hata oluştu", urun.getUrunID());
			return "admin/urun";
		}
		Urun urun2 = urunService.getUrunById(urun.getUrunID());
		if(urun.getResim() == null || urun.getResim().equals(""))
			urun.setResim(urun2.getResim());
		urunService.updateUrun(urun);
		logger.info("{} nolu ürün güncellendi. Yeni özellikleri: {}", urun.getUrunID() ,urun.toString());
		return "redirect:/admin/uruns/list";
	}
	
	public void setUrunService(UrunService urunService) {
		this.urunService = urunService;
	}

	public void setKategoriService(KategoriService kategoriService) {
		this.kategoriService = kategoriService;
	}
}
