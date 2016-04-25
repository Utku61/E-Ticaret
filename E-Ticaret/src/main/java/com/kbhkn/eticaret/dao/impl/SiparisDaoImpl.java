package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Query;
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
		Query query = getSession().createQuery("UPDATE FROM Siparis set KargoID = :kargoID ,SiparisDurumID = :siparisDurumID, TeslimTarihi = :teslimTarihi WHERE SiparisID = :siparisID");
		query.setParameter("kargoID", siparis.getKargo().getKargoID());
		query.setParameter("siparisDurumID", siparis.getSiparisDurum().getSiparisDurumID());
		query.setParameter("teslimTarihi", siparis.getTeslimTarihi());
		query.setParameter("siparisID", siparis.getSiparisID());
		query.executeUpdate();
	}

	@Override
	public void deleteSiparis(Integer siparisId) {
		Siparis siparis = getSiparisById(siparisId);
		if(siparis != null)
			getSession().delete(siparis);
	}
	
	public int getSiparisCount(){
		Query query = getSession().createQuery("select count(s) from Siparis s where SiparisDurumID = 3");
		return ((Long)query.uniqueResult()).intValue();
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
