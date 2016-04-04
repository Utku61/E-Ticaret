package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.OdemeSecenek;

public interface OdemeSecenekService {
	public void addOdemeSecenek(OdemeSecenek odemeSecenek);

	public OdemeSecenek getOdemeSecenekById(Integer odemeSecenekId);

	public void updateOdemeSecenek(OdemeSecenek odemeSecenek);

	public void deleteOdemeSecenek(Integer odemeSecenekId);

	public List<OdemeSecenek> getAllOdemeSeceneks();
}
