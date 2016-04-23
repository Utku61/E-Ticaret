package com.kbhkn.eticaret.dao;

import java.util.List;

import com.kbhkn.eticaret.model.AltKategori;
import com.kbhkn.eticaret.model.Kategori;
import com.kbhkn.eticaret.model.UstKategori;


public interface KategoriDAO {
	
	public void addAltKategori(AltKategori altKategori);

	public AltKategori getAltKategoriById(Integer altKategoriId);

	public void updateAltKategori(AltKategori altKategori);

	public void deleteAltKategori(Integer altKategoriId);

	public List<AltKategori> getAllAltKategoris();
	
	public List<AltKategori> getAltKategoriListByKategoriID(Integer kategoriID);
	
	public void addKategori(Kategori kategori);

	public Kategori getKategoriById(Integer kategoriId);

	public void updateKategori(Kategori kategori);

	public void deleteKategori(Integer kategoriId);

	public List<Kategori> getAllKategoris();
	
	public List<Kategori> getKategoriListByUstKategoriID(Integer ustKategoriID);
	
	public void addUstKategori(UstKategori ustKategori);

	public UstKategori getUstKategoriById(Integer ustKategoriId);

	public void updateUstKategori(UstKategori ustKategori);

	public void deleteUstKategori(Integer ustKategoriId);

	public List<UstKategori> getAllUstKategoris();
}
