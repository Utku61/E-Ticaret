package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.SiparisDAO;
import com.kbhkn.eticaret.model.Siparis;

@Repository
public class SiparisDaoImpl implements SiparisDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addSiparis(Siparis siparis) {
		getSession().save(siparis);
	}

	@Override
	public Siparis getSiparisById(Integer siparisId) {
		return (Siparis) getSession().get(Siparis.class, siparisId);
	}

	@Override
	public void updateSiparis(Siparis siparis) {
		getSession().update(siparis);
	}

	@Override
	public void deleteSiparis(Integer siparisId) {
		getSession().delete(getSiparisById(siparisId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Siparis> getAllSipariss() {
		return (List<Siparis>) getSession().createCriteria(Siparis.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
