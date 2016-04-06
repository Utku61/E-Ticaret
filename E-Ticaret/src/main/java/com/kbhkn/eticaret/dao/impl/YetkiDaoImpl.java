package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.YetkiDAO;
import com.kbhkn.eticaret.model.Yetki;

@Repository
public class YetkiDaoImpl implements YetkiDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addYetki(Yetki yetki) {
		getSession().save(yetki);
	}

	@Override
	public Yetki getYetkiById(Integer yetkiId) {
		return (Yetki) getSession().get(Yetki.class, yetkiId);
	}

	@Override
	public void updateYetki(Yetki yetki) {
		getSession().update(yetki);
	}

	@Override
	public void deleteYetki(Integer yetkiId) {
		Yetki yetki = getYetkiById(yetkiId);
		if(yetki != null)
			getSession().delete(yetki);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Yetki> getAllYetkis() {
		return (List<Yetki>) getSession().createCriteria(Yetki.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
