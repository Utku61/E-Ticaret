package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.MarkaDAO;
import com.kbhkn.eticaret.model.Marka;

@Repository
public class MarkaDaoImpl implements MarkaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addMarka(Marka marka) {
		getSession().save(marka);
	}

	@Override
	public Marka getMarkaById(Integer markaId) {
		return (Marka) getSession().get(Marka.class, markaId);
	}

	@Override
	public void updateMarka(Marka marka) {
		getSession().update(marka);
	}

	@Override
	public void deleteMarka(Integer markaId) {
		getSession().delete(getMarkaById(markaId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marka> getAllMarkas() {
		return (List<Marka>) getSession().createCriteria(Marka.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
