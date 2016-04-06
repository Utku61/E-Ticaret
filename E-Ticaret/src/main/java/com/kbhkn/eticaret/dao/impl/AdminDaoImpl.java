package com.kbhkn.eticaret.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kbhkn.eticaret.dao.AdminDAO;
import com.kbhkn.eticaret.model.Admin;
import com.kbhkn.eticaret.model.Siparis;

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
	
	@Override
	public Admin getAdminControl(String username, String password) {
		Query query = getSession().createQuery("from Admin where Eposta = :username and Parola = :password");
		query.setString("username", username);
		query.setString("password", password);
		return (Admin) query.uniqueResult();
	}
	
	@Override
	public boolean getBekleyenSiparisKontrol() {
		return (getSession().createCriteria(Siparis.class).add(Restrictions.isNull("TeslimTarihi")) != null) ? false : true;
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
