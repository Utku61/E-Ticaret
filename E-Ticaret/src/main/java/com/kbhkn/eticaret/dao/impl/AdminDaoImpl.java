package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.AdminDAO;
import com.kbhkn.eticaret.model.Admin;

@Repository
public class AdminDaoImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addAdmin(Admin admin) {
		getSession().save(admin);
	}

	@Override
	public Admin getAdminById(Integer adminId) {
		return (Admin) getSession().get(Admin.class, adminId);
	}

	@Override
	public void updateAdmin(Admin admin) {
		getSession().update(admin);
	}

	@Override
	public void deleteAdmin(Integer adminId) {
		getSession().delete(getAdminById(adminId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAllAdmins() {
		return (List<Admin>) getSession().createCriteria(Admin.class).list();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
