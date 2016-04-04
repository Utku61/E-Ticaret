package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.Yetki;

public interface YetkiService {
	public void addYetki(Yetki yetki);

	public Yetki getYetkiById(Integer yetkiId);

	public void updateYetki(Yetki yetki);

	public void deleteYetki(Integer yetkiId);

	public List<Yetki> getAllYetkis();
}
