package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.KategoriDAO;
import com.kbhkn.eticaret.model.Katagori;

@Repository
public class KatagoriDaoImpl implements KategoriDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addKatagori(Katagori katagori) {
		getSession().save(katagori);
	}

	@Override
	public Katagori getKatagoriById(Integer kategoriId) {
		return (Katagori) getSession().get(Katagori.class, kategoriId);
	}

	@Override
	public void updateKatagori(Katagori katagori) {
		getSession().update(katagori);
	}

	@Override
	public void deleteKatagori(Integer kategoriId) {
		Katagori katagori = getKatagoriById(kategoriId);
		if(katagori != null)
			getSession().delete(katagori);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Katagori> getAllKatagoris() {
		return (List<Katagori>) getSession().createCriteria(Katagori.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
