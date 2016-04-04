package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.Katagori;

public interface KategoriService {
	public void addKatagori(Katagori katagori);

	public Katagori getKatagoriById(Integer kategoriId);

	public void updateKatagori(Katagori katagori);

	public void deleteKatagori(Integer kategoriId);

	public List<Katagori> getAllKatagoris();
}
