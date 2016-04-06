package com.kbhkn.eticaret.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kbhkn.eticaret.dao.AdminDAO;
import com.kbhkn.eticaret.model.Admin;
import com.kbhkn.eticaret.service.AdminService;

@Service
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
	public Admin getUserByName(String username) {
		return adminDao.getUserByName(username);
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
	public Admin getAdminControl(String username, String password) {
		return adminDao.getAdminControl(username, password);
	}
	
	@Transactional
	public boolean getBekleyenSiparisKontrol() {
		return adminDao.getBekleyenSiparisKontrol();
	}
	
	@Transactional
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}
	
	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}
}
