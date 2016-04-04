package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.SehirDAO;
import com.kbhkn.eticaret.model.Sehir;

@Repository
public class SehirDaoImpl implements SehirDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addSehir(Sehir sehir) {
		getSession().save(sehir);
	}

	@Override
	public Sehir getSehirById(Integer sehirId) {
		return (Sehir) getSession().get(Sehir.class, sehirId);
	}

	@Override
	public void updateSehir(Sehir sehir) {
		getSession().update(sehir);
	}

	@Override
	public void deleteSehir(Integer sehirId) {
		getSession().delete(getSehirById(sehirId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sehir> getAllSehirs() {
		return (List<Sehir>) getSession().createCriteria(Sehir.class).list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
