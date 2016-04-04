package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.KategoriDAO;
import com.kbhkn.eticaret.model.Katagori;
import com.kbhkn.eticaret.service.KategoriService;

public class KategoriServiceImpl implements KategoriService {

	@Autowired
	private KategoriDAO kategoriDAO;
	
	@Transactional
	public void addKatagori(Katagori katagori) {
		kategoriDAO.addKatagori(katagori);
	}

	@Transactional
	public Katagori getKatagoriById(Integer kategoriId) {
		return kategoriDAO.getKatagoriById(kategoriId);
	}

	@Transactional
	public void updateKatagori(Katagori katagori) {
		kategoriDAO.updateKatagori(katagori);
	}

	@Transactional
	public void deleteKatagori(Integer kategoriId) {
		kategoriDAO.deleteKatagori(kategoriId);
	}

	@Transactional
	public List<Katagori> getAllKatagoris() {
		return kategoriDAO.getAllKatagoris();
	}

	public void setKategoriDAO(KategoriDAO kategoriDAO) {
		this.kategoriDAO = kategoriDAO;
	}
}
