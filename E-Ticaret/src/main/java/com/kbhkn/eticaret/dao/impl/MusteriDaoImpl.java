package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.MusteriDAO;
import com.kbhkn.eticaret.model.Musteri;

@Repository
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
	public Musteri getUserByName(String username) {
		return (Musteri) getSession().createCriteria(Musteri.class).add(Restrictions.eq("Eposta", username)).uniqueResult();
	}

	@Override
	public void updateMusteri(Musteri musteri) {
		getSession().update(musteri);
	}

	@Override
	public void deleteMusteri(Integer musteriId) {
		Musteri musteri = getMusteriById(musteriId);
		if(musteri != null)
			getSession().delete(musteri);
	}
	
	@Override
	public Musteri getMusteriControl(String username, String password) {
		Query query = getSession().createQuery("from Musteri where Eposta = :username and Parola = :password");
		query.setString("username", username);
		query.setString("password", password);
		return (Musteri) query.uniqueResult();
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
