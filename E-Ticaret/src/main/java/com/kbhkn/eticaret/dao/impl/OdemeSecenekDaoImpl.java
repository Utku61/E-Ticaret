package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.OdemeSecenekDAO;
import com.kbhkn.eticaret.model.OdemeSecenek;

@Repository
public class OdemeSecenekDaoImpl implements OdemeSecenekDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addOdemeSecenek(OdemeSecenek odemeSecenek) {
		getSession().save(odemeSecenek);
	}

	@Override
	public OdemeSecenek getOdemeSecenekById(Integer odemeSecenekId) {
		return (OdemeSecenek) getSession().get(OdemeSecenek.class, odemeSecenekId);
	}

	@Override
	public void updateOdemeSecenek(OdemeSecenek odemeSecenek) {
		getSession().update(odemeSecenek);
	}

	@Override
	public void deleteOdemeSecenek(Integer odemeSecenekId) {
		OdemeSecenek odemeSenecek = getOdemeSecenekById(odemeSecenekId);
		if(odemeSenecek != null)
			getSession().delete(odemeSenecek);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OdemeSecenek> getAllOdemeSeceneks() {
		return (List<OdemeSecenek>) getSession().createCriteria(OdemeSecenek.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
