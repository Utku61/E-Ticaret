package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.Kargo;

public interface KargoService {
	public void addKargo(Kargo kargo);

	public Kargo getKargoById(Integer kargoId);

	public void updateKargo(Kargo kargo);

	public void deleteKargo(Integer kargoId);

	public List<Kargo> getAllKargos();
}
