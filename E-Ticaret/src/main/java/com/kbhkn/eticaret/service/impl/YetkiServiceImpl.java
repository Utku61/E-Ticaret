package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.YetkiDAO;
import com.kbhkn.eticaret.model.Yetki;
import com.kbhkn.eticaret.service.YetkiService;

@Service
public class YetkiServiceImpl implements YetkiService {

	@Autowired
	private YetkiDAO yetkiDao;

	@Transactional
	public void addYetki(Yetki yetki) {
		yetkiDao.addYetki(yetki);
	}

	@Transactional
	public Yetki getYetkiById(Integer yetkiId) {
		return yetkiDao.getYetkiById(yetkiId);
	}

	@Transactional
	public void updateYetki(Yetki yetki) {
		yetkiDao.updateYetki(yetki);
	}

	@Transactional
	public void deleteYetki(Integer yetkiId) {
		yetkiDao.deleteYetki(yetkiId);
	}

	@Transactional
	public List<Yetki> getAllYetkis() {
		return yetkiDao.getAllYetkis();
	}

	public void setYetkiDao(YetkiDAO yetkiDao) {
		this.yetkiDao = yetkiDao;
	}

}
