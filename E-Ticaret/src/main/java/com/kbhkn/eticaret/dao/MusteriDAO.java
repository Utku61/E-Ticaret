package com.kbhkn.eticaret.dao;

import java.util.List;

import com.kbhkn.eticaret.model.Musteri;

public interface MusteriDAO {
	public void addMusteri(Musteri musteri);

	public Musteri getMusteriById(Integer musteriId);

	public void updateMusteri(Musteri musteri);

	public void deleteMusteri(Integer musteriId);
	
	public Musteri getMusteriControl(String username, String password);

	public List<Musteri> getAllMusteris();
}
