package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.SehirDAO;
import com.kbhkn.eticaret.model.Sehir;
import com.kbhkn.eticaret.service.SehirService;

public class SehirServiceImpl implements SehirService {

	@Autowired
	private SehirDAO sehirDao;

	@Transactional
	public void addSehir(Sehir sehir) {
		sehirDao.addSehir(sehir);
	}

	@Transactional
	public Sehir getSehirById(Integer sehirId) {
		return sehirDao.getSehirById(sehirId);
	}

	@Transactional
	public void updateSehir(Sehir sehir) {
		sehirDao.updateSehir(sehir);
	}

	@Transactional
	public void deleteSehir(Integer sehirId) {
		sehirDao.deleteSehir(sehirId);
	}

	@Transactional
	public List<Sehir> getAllSehirs() {
		return sehirDao.getAllSehirs();
	}

	public void setSehirDao(SehirDAO sehirDao) {
		this.sehirDao = sehirDao;
	}
}
