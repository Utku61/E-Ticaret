package com.kbhkn.eticaret.service;

import java.util.List;

import com.kbhkn.eticaret.model.Admin;

public interface AdminService {
	public void addAdmin(Admin admin);

	public Admin getAdminById(Integer adminId);

	public void updateAdmin(Admin admin);

	public void deleteAdmin(Integer adminId);

	public List<Admin> getAllAdmins();
}
