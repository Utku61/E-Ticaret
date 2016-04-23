package com.kbhkn.eticaret.dao;

import java.util.List;

import com.kbhkn.eticaret.model.Urun;

public interface UrunDAO {
	public void addUrun(Urun urun);

	public Urun getUrunById(Integer urunId);
	
	public void updateUrun(Urun urun);

	public void deleteUrun(Integer urunId);
	
	public String getImageByUrunId(Integer urunId);

	public List<Urun> getUrunByAltKategoriId(Integer altKategoriId);
	
	public List<Urun> getUrunByKategoriId(Integer kategoriId);
	
	public List<Urun> getUrunByUstKategoriId(Integer ustKategoriId);
	
	public List<Urun> searchUrun(String urunAdi);
	
	public List<Urun> getAllUruns();
}
