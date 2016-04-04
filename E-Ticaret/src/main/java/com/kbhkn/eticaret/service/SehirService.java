package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.Sehir;

public interface SehirService {
	public void addSehir(Sehir sehir);

	public Sehir getSehirById(Integer sehirId);

	public void updateSehir(Sehir sehir);

	public void deleteSehir(Integer sehirId);

	public List<Sehir> getAllSehirs();
}
