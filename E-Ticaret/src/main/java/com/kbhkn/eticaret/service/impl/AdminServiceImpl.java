package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.AdminDAO;
import com.kbhkn.eticaret.model.Admin;
import com.kbhkn.eticaret.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;

	@Transactional
	public void addAdmin(Admin admin) {
		adminDao.addAdmin(admin);
	}

	@Transactional
	public Admin getAdminById(Integer adminId) {
		return adminDao.getAdminById(adminId);
	}

	@Transactional
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}

	@Transactional
	public void deleteAdmin(Integer adminId) {
		adminDao.deleteAdmin(adminId);
	}

	@Transactional
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}
	
	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

}
