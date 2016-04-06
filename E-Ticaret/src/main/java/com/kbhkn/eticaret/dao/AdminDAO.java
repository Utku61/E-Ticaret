package com.kbhkn.eticaret.dao;

import java.util.List;

import com.kbhkn.eticaret.model.Admin;

public interface AdminDAO {
	public void addAdmin(Admin admin);

	public Admin getAdminById(Integer adminId);
	
	public void updateAdmin(Admin admin);

	public void deleteAdmin(Integer adminId);
	
	public Admin getAdminControl(String username, String password);
	
	public boolean getBekleyenSiparisKontrol();

	public List<Admin> getAllAdmins();
}
