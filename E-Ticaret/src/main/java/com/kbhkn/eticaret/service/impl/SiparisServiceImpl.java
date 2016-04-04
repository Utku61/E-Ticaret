package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.SiparisDAO;
import com.kbhkn.eticaret.model.Siparis;
import com.kbhkn.eticaret.service.SiparisService;

@Service
public class SiparisServiceImpl implements SiparisService {

	@Autowired
	private SiparisDAO siparisDao;

	@Transactional
	public void addSiparis(Siparis siparis) {
		siparisDao.addSiparis(siparis);
	}

	@Transactional
	public Siparis getSiparisById(Integer siparisId) {
		return siparisDao.getSiparisById(siparisId);
	}

	@Transactional
	public void updateSiparis(Siparis siparis) {
		siparisDao.updateSiparis(siparis);
	}

	@Transactional
	public void deleteSiparis(Integer siparisId) {
		siparisDao.deleteSiparis(siparisId);
	}

	@Transactional
	public List<Siparis> getAllSipariss() {
		return siparisDao.getAllSipariss();
	}

	public void setSiparisDao(SiparisDAO siparisDao) {
		this.siparisDao = siparisDao;
	}
}
