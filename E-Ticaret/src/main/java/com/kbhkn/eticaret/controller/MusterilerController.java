package com.kbhkn.eticaret.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.kbhkn.eticaret.service.KategoriService;
import com.kbhkn.eticaret.service.MusteriService;
import com.kbhkn.eticaret.service.SehirService;
import com.kbhkn.eticaret.service.UrunService;

@Controller
@RequestMapping("/musteri")
@SessionAttributes("logonUser")
public class MusterilerController {
	private static final Logger logger = LoggerFactory.getLogger(MusterilerController.class);

	@Autowired
	private MusteriService musteriService;
	
	@Autowired
	private KategoriService kategoriService;
	
	@Autowired
	private SehirService sehirService;
	
	@Autowired
	private UrunService urunService;
	
	@RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
	public String listUruns(HttpSession session, ModelMap model) {
		model.addAttribute("urunler", urunService.getAllUruns());
		model.addAttribute("allUstKategoris", kategoriService.getAllUstKategoris());
		model.addAttribute("allSehirs", sehirService.getAllSehirs());
		model.addAttribute("kategoriService",kategoriService);
		return "musteri/index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String musteriKayit(ModelMap model){
		model.addAttribute("musteri", new Musteri());
		model.addAttribute("allSehirs", sehirService.getAllSehirs());
		return "musteri/register";
	}
	
	@RequestMapping(value = "/musterilogin", method = RequestMethod.GET)
	public String redirectRegister(){
		return "redirect:/musteri/register";
	}
	
	@RequestMapping(value = "/musterilogin", method = RequestMethod.POST)
	public String loginMusteri(ModelMap model, HttpServletRequest request) {
		Musteri loginUser = musteriService.getMusteriControl(request.getParameter("eposta"), request.getParameter("parola"));
		if(loginUser != null){
			ArrayList<Urun> sepet = new ArrayList<Urun>();
			request.getSession().setAttribute("sepet", sepet);
			request.getSession().setAttribute("musteri", loginUser);
			return "redirect:/musteri/index";
		}else{
			model.addAttribute("loginStatus", "E-Posta adresiniz veya şifre hatalı");
			model.addAttribute("musteri", new Musteri());
			model.addAttribute("allSehirs", sehirService.getAllSehirs());
			return "musteri/register";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String adminLogout(HttpSession session, ModelMap model) {
		Object musteri = session.getAttribute("musteri");
		if(musteri != null){
			logger.info("Müşteri çıkış yaptı. Tarih:{} , Musteri Bilgileri: {}", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()), ((Musteri)musteri).toString());
			session.invalidate();
		}
		return "redirect:/musteri/register";
	}
	
	@RequestMapping(value = "/altKatagoriUrun/{altKategoriID}", method = RequestMethod.GET)
	public String listAltKategoris(@PathVariable("altKategoriID") Integer altKategoriID, ModelMap model) {
		List<Urun> uruns = urunService.getUrunByAltKategoriId(altKategoriID);
		
		model.addAttribute("allUstKategoris", kategoriService.getAllUstKategoris());
		model.addAttribute("kategoriService",kategoriService);
		
		if(uruns.isEmpty()){
			model.addAttribute("message","Bu katagoride ürün bulunmamaktadır.");
			logger.info("{} nolu kategoride ürünün olmadığı tespit edildi!", altKategoriID);
			return "musteri/index";
		}
		
		model.addAttribute("urunler", uruns);
		logger.info("Ürüne göre kategoriler listelendi.");
		return "musteri/index";
	}
	
	@RequestMapping(value = "/katagoriUrun/{kategoriID}", method = RequestMethod.GET)
	public String listKategoris(@PathVariable("kategoriID") Integer kategoriID, ModelMap model) {
		List<Urun> uruns = urunService.getUrunByKategoriId(kategoriID);
		
		model.addAttribute("allUstKategoris", kategoriService.getAllUstKategoris());
		model.addAttribute("kategoriService",kategoriService);
		
		if(uruns.isEmpty()){
			model.addAttribute("message","Bu katagoride ürün bulunmamaktadır.");
			logger.info("{} nolu kategoride ürünün olmadığı tespit edildi!", kategoriID);
			return "musteri/index";
		}
		
		model.addAttribute("urunler", uruns);
		logger.info("Ürüne göre kategoriler listelendi.");
		return "musteri/index";
	}	

	@RequestMapping(value = "/ustKatagoriUrun/{ustKategoriID}", method = RequestMethod.GET)
	public String listUstKategoris(@PathVariable("ustKategoriID") Integer ustKategoriID, ModelMap model) {
		List<Urun> uruns = urunService.getUrunByUstKategoriId(ustKategoriID);
		
		model.addAttribute("allUstKategoris", kategoriService.getAllUstKategoris());
		model.addAttribute("kategoriService",kategoriService);
		
		if(uruns.isEmpty()){
			model.addAttribute("message","Bu katagoride ürün bulunmamaktadır.");
			logger.info("{} nolu üst kategoride ürünün olmadığı tespit edildi!", ustKategoriID);
			return "musteri/index";
		}
		
		model.addAttribute("urunler", uruns);
		logger.info("Ürüne göre kategoriler listelendi.");
		return "musteri/index";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addMusteri(@Valid Musteri newMusteri, BindingResult result, HttpServletRequest req,  ModelMap model) {
		newMusteri.setKayitTarihi(new Date());
		newMusteri.setIPAdress(com.kbhkn.eticaret.util.IPGetir.getClientRealIpAdress(req));
		if (result.hasErrors()) {
			logger.info("Yeni müşteri kaydı sırasında bilgiler eksik yada yanlış girildi: {}", newMusteri.toString());
			model.addAttribute("kayitStatus", "Lütfen eksik yada yanlış girmeyiniz!");
			model.addAttribute("allSehirs", sehirService.getAllSehirs());
			return "musteri/register";
		}
		musteriService.addMusteri(newMusteri);
		logger.info("Yeni müşteri eklendi. ID: {}", newMusteri.getMusteriID());
		return "redirect:/musteri/index";
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

	public void setKategoriService(KategoriService kategoriService) {
		this.kategoriService = kategoriService;
	}

	public void setSehirService(SehirService sehirService) {
		this.sehirService = sehirService;
	}
}
