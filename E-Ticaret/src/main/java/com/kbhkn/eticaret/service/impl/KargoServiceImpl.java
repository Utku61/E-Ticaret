package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.KargoDAO;
import com.kbhkn.eticaret.model.Kargo;
import com.kbhkn.eticaret.service.KargoService;

public class KargoServiceImpl implements KargoService {

	@Autowired
	private KargoDAO kargoDao;
	
	@Transactional
	public void addKargo(Kargo kargo) {
		kargoDao.addKargo(kargo);
	}

	@Transactional
	public Kargo getKargoById(Integer kargoId) {
		return kargoDao.getKargoById(kargoId);
	}

	@Transactional
	public void updateKargo(Kargo kargo) {
		kargoDao.updateKargo(kargo);
	}

	@Transactional
	public void deleteKargo(Integer kargoId) {
		kargoDao.deleteKargo(kargoId);
	}

	@Transactional
	public List<Kargo> getAllKargos() {
		return kargoDao.getAllKargos();
	}

	public void setKargoDao(KargoDAO kargoDao) {
		this.kargoDao = kargoDao;
	}
}
