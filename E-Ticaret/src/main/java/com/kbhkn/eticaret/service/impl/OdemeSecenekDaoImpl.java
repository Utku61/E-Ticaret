package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.OdemeSecenekDAO;
import com.kbhkn.eticaret.model.OdemeSecenek;

@Service
public class OdemeSecenekDaoImpl implements OdemeSecenekDAO {

	@Autowired
	private OdemeSecenekDAO odemeSecenekDao;

	@Transactional
	public void addOdemeSecenek(OdemeSecenek odemeSecenek) {
		odemeSecenekDao.addOdemeSecenek(odemeSecenek);
	}

	@Transactional
	public OdemeSecenek getOdemeSecenekById(Integer odemeSecenekId) {
		return odemeSecenekDao.getOdemeSecenekById(odemeSecenekId);
	}

	@Transactional
	public void updateOdemeSecenek(OdemeSecenek odemeSecenek) {
		odemeSecenekDao.updateOdemeSecenek(odemeSecenek);
	}

	@Transactional
	public void deleteOdemeSecenek(Integer odemeSecenekId) {
		odemeSecenekDao.deleteOdemeSecenek(odemeSecenekId);
	}

	@Transactional
	public List<OdemeSecenek> getAllOdemeSeceneks() {
		return odemeSecenekDao.getAllOdemeSeceneks();
	}

	public void setOdemeSecenekDao(OdemeSecenekDAO odemeSecenekDao) {
		this.odemeSecenekDao = odemeSecenekDao;
	}
}
