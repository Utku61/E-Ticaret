package com.kbhkn.eticaret.dao;

import java.util.List;

import com.kbhkn.eticaret.model.SiparisDurum;

public interface SiparisDurumDAO {
	public void addSiparisDurum(SiparisDurum siparisDurum);

	public SiparisDurum getSiparisDurumById(Integer siparisDurumId);

	public void updateSiparisDurum(SiparisDurum siparisDurum);

	public void deleteSiparisDurum(Integer siparisDurumId);

	public List<SiparisDurum> getAllSiparisDurums();
}
