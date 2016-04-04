package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.Marka;

public interface MarkaService {
	public void addMarka(Marka marka);

	public Marka getMarkaById(Integer markaId);

	public void updateMarka(Marka marka);

	public void deleteMarka(Integer markaId);

	public List<Marka> getAllMarkas();
}
