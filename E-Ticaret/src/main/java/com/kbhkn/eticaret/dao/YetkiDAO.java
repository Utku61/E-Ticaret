package com.kbhkn.eticaret.dao;

import java.util.List;

import com.kbhkn.eticaret.model.Yetki;

public interface YetkiDAO {
	public void addYetki(Yetki yetki);

	public Yetki getYetkiById(Integer yetkiId);

	public void updateYetki(Yetki yetki);

	public void deleteYetki(Integer yetkiId);

	public List<Yetki> getAllYetkis();
}
