package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.KargoDAO;
import com.kbhkn.eticaret.model.Kargo;

@Repository
public class KargoDaoImpl implements KargoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addKargo(Kargo kargo) {
		getSession().save(kargo);
	}

	@Override
	public Kargo getKargoById(Integer kargoId) {
		return (Kargo) getSession().get(Kargo.class, kargoId);
	}

	@Override
	public void updateKargo(Kargo kargo) {
		getSession().update(kargo);
	}

	@Override
	public void deleteKargo(Integer kargoId) {
		Kargo kargo = getKargoById(kargoId);
		if(kargo != null)
			getSession().delete(getKargoById(kargoId));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Kargo> getAllKargos() {
		return (List<Kargo>) getSession().createCriteria(Kargo.class).list(); 
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
