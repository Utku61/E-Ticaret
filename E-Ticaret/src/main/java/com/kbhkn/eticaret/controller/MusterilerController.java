package com.kbhkn.eticaret.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.kbhkn.eticaret.model.Musteri;
import com.kbhkn.eticaret.model.Urun;
import com.kbhkn.eticaret.model.Yetki;
import com.kbhkn.eticaret.service.MusteriService;
import com.kbhkn.eticaret.service.UrunService;

@Controller
@RequestMapping("/musteri")
@SessionAttributes("logonUser")
public class MusterilerController {
	private static final Logger logger = LoggerFactory.getLogger(MusterilerController.class);

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private MusteriService musteriService;
	
	@Autowired
	private UrunService urunService;
	
	@RequestMapping(value = "/musterilogin", method = RequestMethod.POST)
	public String loginMusteri(@Valid Musteri musteri, HttpSession session, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("kayitStatus", "Lütfen eksik/yanlış bilgi girmeyiniz!");
			return "musteri/login";
		}
		
		Musteri loginUser = musteriService.getMusteriControl(musteri.getEposta(), musteri.getParola());
		if(loginUser != null){
			ArrayList<Urun> sepet = new ArrayList<Urun>();
			session.setAttribute("sepet", sepet);
			session.setAttribute("musteri", loginUser);
			return "musteri/index";
		}else{
			model.addAttribute("status", "E-Posta adresiniz veya şifre hatalı");
			return "musteri/login";
		}
	}
	
	@RequestMapping(value = "/musterilogin", method = RequestMethod.POST)
	public String siparisVer(@Valid Musteri musteri, HttpSession session, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.addAttribute("kayitStatus", "Lütfen eksik/yanlış bilgi girmeyiniz!");
			return "musteri/login";
		}
		
		Musteri loginUser = musteriService.getMusteriControl(musteri.getEposta(), musteri.getParola());
		if(loginUser != null){
			ArrayList<Urun> sepet = new ArrayList<Urun>();
			session.setAttribute("sepet", sepet);
			session.setAttribute("musteri", loginUser);
			return "musteri/index";
		}else{
			model.addAttribute("status", "E-Posta adresiniz veya şifre hatalı");
			return "musteri/login";
		}
	}
	
	@RequestMapping(value = "/katagoriUrun", method = RequestMethod.GET)
	public String listAllKategoris(HttpSession session, ModelMap model, @PathVariable("katagoriID") Integer katagoriID) {
		List<Urun> uruns = urunService.getUrunByKategoriId(katagoriID);
		if(uruns.isEmpty()){
			model.addAttribute("message","Bu katagoride ürün bulunmamaktadır.");
			logger.info("{} nolu kategoride ürünün olmadığı tespit edildi!", katagoriID);
		}
		model.addAttribute("allKategoris", uruns);
		logger.info("Ürüne göre kategoriler listelendi.");
		return "musteri/index";
	}
	
	@RequestMapping(value = "/kayit", method = RequestMethod.POST)
	public String addMusteri(@Valid Musteri musteri, HttpSession session, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("Yeni müşteri kaydı sırasında bilgiler eksik yada yanlış girildi!");
			model.addAttribute("kayitStatus", "Lütfen eksik bilgi girmeyiniz!");
			return "musteri/index";
		}
		
		musteri.setIPAdress(com.kbhkn.eticaret.util.IPGetir.getClientRealIpAdress(request));
		musteri.setYetki(new Yetki(2));
		
		musteriService.addMusteri(musteri);
		model.addAttribute("kayitStatus", "Kaydınız başarıyla gerçekleştirilmiştir. Giriş yapabilirsiniz.");
		logger.info("Yeni müşteri eklendi. ID: {}", musteri.getMusteriID());
		
		return "musteri/index";
	}
	
	@RequestMapping(value = "/parolaguncelle", method = RequestMethod.POST)
	public String editMusteri(@Valid Musteri musteri, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			logger.info("{} nolu müşteri yanlış bilgi doldurmuştur. Güncelleme sırasında hata oluştu", musteri.getMusteriID());
			model.addAttribute("kayitStatus", "Girdiğiniz bilgileri kontrol ediniz!");
			return "musteri/index";
		}
		
		musteriService.updateMusteri(musteri);
		logger.info("{} 'nolu müşteri parolasını güncellendi. ", musteri.getMusteriID());
		model.addAttribute("kayitStatus", "Parolanız başarıyla güncellendi.");
		return "redirect:/musteri/index";
	}
	
	@RequestMapping(value = "/sepetekle", method = RequestMethod.GET)
	public String addUrun(@PathVariable("urunID") Integer urunID, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Urun> sepet = (List<Urun>) session.getAttribute("sepet");
		sepet.add(urunService.getUrunById(urunID));
		return "redirect:/musteri/index";
	}
	
	@RequestMapping(value = "/urunsil", method = RequestMethod.GET)
	public String deleteUrun(@PathVariable("urunID") Integer urunID, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Urun> sepet = (List<Urun>) session.getAttribute("sepet");
		sepet.remove(urunID);
		return "redirect:/musteri/sepet";
	}
	
	public void setMusteriService(MusteriService musteriService) {
		this.musteriService = musteriService;
	}

	public void setUrunService(UrunService urunService) {
		this.urunService = urunService;
	}
}
