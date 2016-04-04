package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.Urun;

public interface UrunService {
	public void addUrun(Urun urun);

	public Urun getUrunById(Integer urunId);

	public void updateUrun(Urun urun);

	public void deleteUrun(Integer urunId);

	public List<Urun> getAllUruns();
}
