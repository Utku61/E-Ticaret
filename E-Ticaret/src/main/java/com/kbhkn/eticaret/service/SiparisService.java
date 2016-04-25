package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.Siparis;

public interface SiparisService {
	public void addSiparis(Siparis siparis);

	public Siparis getSiparisById(Integer siparisId);

	public void updateSiparis(Siparis siparis);

	public void deleteSiparis(Integer siparisId);
	
	public int getSiparisCount();

	public List<Siparis> getAllSipariss();
}
