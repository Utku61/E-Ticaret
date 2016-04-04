package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.SiparisDurumDAO;
import com.kbhkn.eticaret.model.SiparisDurum;

@Repository
public class SiparisDurumDaoImpl implements SiparisDurumDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addSiparisDurum(SiparisDurum siparisDurum) {
		getSession().save(siparisDurum);
	}

	@Override
	public SiparisDurum getSiparisDurumById(Integer siparisDurumId) {
		return (SiparisDurum) getSession().get(SiparisDurum.class, siparisDurumId);
	}

	@Override
	public void updateSiparisDurum(SiparisDurum siparisDurum) {
		getSession().update(siparisDurum);
	}

	@Override
	public void deleteSiparisDurum(Integer siparisDurumId) {
		getSession().delete(getSiparisDurumById(siparisDurumId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SiparisDurum> getAllSiparisDurums() {
		return (List<SiparisDurum>) getSession().createCriteria(SiparisDurum.class).list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
