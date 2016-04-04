package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.MarkaDAO;
import com.kbhkn.eticaret.model.Marka;
import com.kbhkn.eticaret.service.MarkaService;

@Service
public class MarkaServiceImpl implements MarkaService {
	
	@Autowired
	private MarkaDAO markaDao;

	@Transactional
	public void addMarka(Marka marka) {
		markaDao.addMarka(marka);
	}

	@Transactional
	public Marka getMarkaById(Integer markaId) {
		return markaDao.getMarkaById(markaId);
	}

	@Transactional
	public void updateMarka(Marka marka) {
		markaDao.updateMarka(marka);
	}

	@Transactional
	public void deleteMarka(Integer markaId) {
		markaDao.deleteMarka(markaId);
	}

	@Transactional
	public List<Marka> getAllMarkas() {
		return markaDao.getAllMarkas();
	}

	public void setMarkaDao(MarkaDAO markaDao) {
		this.markaDao = markaDao;
	}
}
