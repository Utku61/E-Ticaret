package com.kbhkn.eticaret.dao;

import java.util.List;

import com.kbhkn.eticaret.model.Siparis;

public interface SiparisDAO {
	public void addSiparis(Siparis siparis);

	public Siparis getSiparisById(Integer siparisId);

	public void updateSiparis(Siparis siparis);

	public void deleteSiparis(Integer siparisId);
	
	public int getSiparisCount();

	public List<Siparis> getAllSipariss();
}
