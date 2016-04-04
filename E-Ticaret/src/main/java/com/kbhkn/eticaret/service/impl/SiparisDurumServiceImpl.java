package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.SiparisDurumDAO;
import com.kbhkn.eticaret.model.SiparisDurum;
import com.kbhkn.eticaret.service.SiparisDurumService;

@Service
public class SiparisDurumServiceImpl implements SiparisDurumService {

	@Autowired
	private SiparisDurumDAO siparisDurumDao;

	@Transactional
	public void addSiparisDurum(SiparisDurum siparisDurum) {
		siparisDurumDao.addSiparisDurum(siparisDurum);
	}

	@Transactional
	public SiparisDurum getSiparisDurumById(Integer siparisDurumId) {
		return siparisDurumDao.getSiparisDurumById(siparisDurumId);
	}

	@Transactional
	public void updateSiparisDurum(SiparisDurum siparisDurum) {
		siparisDurumDao.updateSiparisDurum(siparisDurum);
	}

	@Transactional
	public void deleteSiparisDurum(Integer siparisDurumId) {
		siparisDurumDao.deleteSiparisDurum(siparisDurumId);
	}

	@Transactional
	public List<SiparisDurum> getAllSiparisDurums() {
		return siparisDurumDao.getAllSiparisDurums();
	}

	public void setSiparisDurumDao(SiparisDurumDAO siparisDurumDao) {
		this.siparisDurumDao = siparisDurumDao;
	}
}
