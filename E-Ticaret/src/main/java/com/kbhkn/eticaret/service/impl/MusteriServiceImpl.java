package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.MusteriDAO;
import com.kbhkn.eticaret.model.Musteri;
import com.kbhkn.eticaret.service.MusteriService;

@Service
public class MusteriServiceImpl implements MusteriService {

	@Autowired
	private MusteriDAO musteriDAO;

	@Transactional
	public void addMusteri(Musteri musteri) {
		musteriDAO.addMusteri(musteri);
	}

	@Transactional
	public Musteri getMusteriById(Integer musteriId) {
		return musteriDAO.getMusteriById(musteriId);
	}

	@Transactional
	public void updateMusteri(Musteri musteri) {
		musteriDAO.updateMusteri(musteri);
	}

	@Transactional
	public void deleteMusteri(Integer musteriId) {
		musteriDAO.deleteMusteri(musteriId);
	}

	@Transactional
	public Musteri getMusteriControl(String username, String password) {
		return musteriDAO.getMusteriControl(username, password);
	}

	@Transactional
	public List<Musteri> getAllMusteris() {
		return musteriDAO.getAllMusteris();
	}

	public void setMusteriDAO(MusteriDAO musteriDAO) {
		this.musteriDAO = musteriDAO;
	}
}
