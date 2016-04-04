package com.kbhkn.eticaret.dao;

import java.util.List;

import com.kbhkn.eticaret.model.Marka;

public interface MarkaDAO {
	public void addMarka(Marka marka);

	public Marka getMarkaById(Integer markaId);

	public void updateMarka(Marka marka);

	public void deleteMarka(Integer markaId);

	public List<Marka> getAllMarkas();
}
