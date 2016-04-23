package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.KategoriDAO;
import com.kbhkn.eticaret.model.AltKategori;
import com.kbhkn.eticaret.model.Kategori;
import com.kbhkn.eticaret.model.UstKategori;
import com.kbhkn.eticaret.service.KategoriService;

@Service
@Transactional
public class KategoriServiceImpl implements KategoriService {

	@Autowired
	private KategoriDAO kategoriDAO;
	
	public void addAltKategori(AltKategori altKategori) {
		kategoriDAO.addAltKategori(altKategori);
	}

	public AltKategori getAltKategoriById(Integer altKategoriId) {
		return kategoriDAO.getAltKategoriById(altKategoriId);
	}

	public void updateAltKategori(AltKategori altKategori) {
		kategoriDAO.addAltKategori(altKategori);
	}

	public void deleteAltKategori(Integer altKategoriId) {
		kategoriDAO.deleteAltKategori(altKategoriId);
	}

	public List<AltKategori> getAllAltKategoris() {
		return kategoriDAO.getAllAltKategoris();
	}
	
	public List<AltKategori> getAltKategoriListByKategoriID(Integer kategoriID) {
		return kategoriDAO.getAltKategoriListByKategoriID(kategoriID);
	}
	
	public void addKategori(Kategori kategori) {
		kategoriDAO.addKategori(kategori);
	}

	public Kategori getKategoriById(Integer kategoriId) {
		return kategoriDAO.getKategoriById(kategoriId);
	}

	public void updateKategori(Kategori kategori) {
		kategoriDAO.updateKategori(kategori);
	}

	public void deleteKategori(Integer kategoriId) {
		kategoriDAO.deleteKategori(kategoriId);
	}

	public List<Kategori> getAllKategoris() {
		return kategoriDAO.getAllKategoris();
	}
	
	public List<Kategori> getKategoriListByUstKategoriID(Integer ustKategoriID) {
		return kategoriDAO.getKategoriListByUstKategoriID(ustKategoriID);
	}
	
	public void addUstKategori(UstKategori ustKategori) {
		kategoriDAO.addUstKategori(ustKategori);
	}

	public UstKategori getUstKategoriById(Integer ustKategoriId) {
		return kategoriDAO.getUstKategoriById(ustKategoriId);
	}

	public void updateUstKategori(UstKategori ustKategori) {
		kategoriDAO.updateUstKategori(ustKategori);
	}

	public void deleteUstKategori(Integer ustKategoriId) {
		kategoriDAO.deleteUstKategori(ustKategoriId);
	}

	public List<UstKategori> getAllUstKategoris() {
		return kategoriDAO.getAllUstKategoris();
	}
	
	public void setKategoriDAO(KategoriDAO kategoriDAO) {
		this.kategoriDAO = kategoriDAO;
	}

}
