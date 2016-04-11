package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Query;
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
		Urun urun = getUrunById(urunId);
		if(urun != null)
			getSession().delete(urun);
	}
	
	@Override
	public String getImageByUrunId(Integer urunId) {
		String resim = getUrunById(urunId).getResim();
		return (resim == null) ? null : resim;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Urun> getUrunByKategoriId(Integer kategoriId) {
		Query query = getSession().createQuery("from Urun where KatagoriID = :id");
		query.setParameter("id", kategoriId);
		return (List<Urun>)query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Urun> searchUrun(String urunAdi) {
		Query query = getSession().createQuery("from Urun where UrunAdi LIKE CONCAT('%', :urunAdi, '%')");
		query.setParameter("urunAdi", urunAdi);
		return (List<Urun>) query.list();
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
