package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.UrunDAO;
import com.kbhkn.eticaret.model.Urun;
import com.kbhkn.eticaret.service.UrunService;

@Service
public class UrunServiceImpl implements UrunService {

	@Autowired
	private UrunDAO urunDao;

	@Transactional
	public void addUrun(Urun urun) {
		urunDao.addUrun(urun);
	}

	@Transactional
	public Urun getUrunById(Integer urunId) {
		return urunDao.getUrunById(urunId);
	}

	@Transactional
	public void updateUrun(Urun urun) {
		urunDao.updateUrun(urun);
	}

	@Transactional
	public void deleteUrun(Integer urunId) {
		urunDao.deleteUrun(urunId);
	}
	
	@Transactional
	public byte[] getImageByUrunId(Integer urunId) {
		return urunDao.getImageByUrunId(urunId);
	}
	
	@Transactional
	public List<Urun> getUrunByKategoriId(Integer kategoriId) {
		return urunDao.getUrunByKategoriId(kategoriId);
	}

	@Transactional
	public List<Urun> searchUrun(String urunAdi) {
		return urunDao.searchUrun(urunAdi);
	}

	@Transactional
	public List<Urun> getAllUruns() {
		return urunDao.getAllUruns();
	}

	public void setUrunDao(UrunDAO urunDao) {
		this.urunDao = urunDao;
	}
}
