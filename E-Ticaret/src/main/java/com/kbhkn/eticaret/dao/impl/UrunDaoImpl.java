package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.UrunDAO;
import com.kbhkn.eticaret.model.Urun;

@Repository
public class UrunDaoImpl implements UrunDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addUrun(Urun urun) {
		getSession().save(urun);
	}

	@Override
	public Urun getUrunById(Integer urunId) {
		return (Urun) getSession().get(Urun.class, urunId);
	}

	@Override
	public void updateUrun(Urun urun) {
		getSession().update(urun);
	}

	@Override
	public void deleteUrun(Integer urunId) {
		getSession().delete(getUrunById(urunId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Urun> getAllUruns() {
		return (List<Urun>) getSession().createCriteria(Urun.class).list(); 
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
