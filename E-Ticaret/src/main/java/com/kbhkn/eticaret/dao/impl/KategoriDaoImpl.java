package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.KategoriDAO;
import com.kbhkn.eticaret.model.AltKategori;
import com.kbhkn.eticaret.model.Kategori;
import com.kbhkn.eticaret.model.UstKategori;

@Repository
public class KategoriDaoImpl implements KategoriDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addAltKategori(AltKategori altKategori) {
		getSession().save(altKategori);
	}

	@Override
	public AltKategori getAltKategoriById(Integer altKategoriId) {
		return (AltKategori) getSession().get(AltKategori.class, altKategoriId);
	}

	@Override
	public void updateAltKategori(AltKategori altKategori) {
		getSession().update(altKategori);
	}

	@Override
	public void deleteAltKategori(Integer altKategoriId) {
		AltKategori altKategori = getAltKategoriById(altKategoriId);
		if(altKategori != null)
			getSession().delete(altKategori);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AltKategori> getAllAltKategoris() {
		return (List<AltKategori>) getSession().createCriteria(AltKategori.class).list();
	}
	
	@Override
	public void addKategori(Kategori kategori) {
		getSession().save(kategori);
	}

	@Override
	public Kategori getKategoriById(Integer kategoriId) {
		return (Kategori) getSession().get(Kategori.class, kategoriId);
	}

	@Override
	public void updateKategori(Kategori kategori) {
		getSession().update(kategori);
	}

	@Override
	public void deleteKategori(Integer kategoriId) {
		Kategori kategori = getKategoriById(kategoriId);
		if(kategori != null)
			getSession().delete(kategori);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Kategori> getAllKategoris() {
		return (List<Kategori>) getSession().createCriteria(Kategori.class).list();
	}

	@Override
	public void addUstKategori(UstKategori ustKategori) {
		getSession().save(ustKategori);
	}

	@Override
	public UstKategori getUstKategoriById(Integer ustKategoriId) {
		return (UstKategori) getSession().get(UstKategori.class, ustKategoriId);
	}

	@Override
	public void updateUstKategori(UstKategori ustKategori) {
		getSession().update(ustKategori);
	}

	@Override
	public void deleteUstKategori(Integer ustKategoriId) {
		UstKategori ustKategori = getUstKategoriById(ustKategoriId);
		if(ustKategori != null)
			getSession().delete(ustKategori);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UstKategori> getAllUstKategoris() {
		return (List<UstKategori>) getSession().createCriteria(UstKategori.class).list();
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
