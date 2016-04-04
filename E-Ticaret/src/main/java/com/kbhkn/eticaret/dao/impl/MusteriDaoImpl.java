package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kbhkn.eticaret.dao.MusteriDAO;
import com.kbhkn.eticaret.model.Musteri;

public class MusteriDaoImpl implements MusteriDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addMusteri(Musteri musteri) {
		getSession().save(musteri);
	}

	@Override
	public Musteri getMusteriById(Integer musteriId) {
		return (Musteri) getSession().get(Musteri.class, musteriId);
	}

	@Override
	public void updateMusteri(Musteri musteri) {
		getSession().update(musteri);
	}

	@Override
	public void deleteMusteri(Integer musteriId) {
		getSession().delete(getMusteriById(musteriId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musteri> getAllMusteris() {
		return (List<Musteri>) getSession().createCriteria(Musteri.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
