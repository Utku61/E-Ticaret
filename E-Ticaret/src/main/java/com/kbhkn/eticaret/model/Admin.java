package com.kbhkn.eticaret.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Admin")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AdminID", unique = true, nullable = false)
	private int adminID;
	
	@Column(name = "Ad", nullable = false, length = 45)
	private String ad;

	@NotEmpty
	@Email
	@Column(name = "Eposta", nullable = false, length = 65)
	private String eposta;
	
	@NotNull
	@Size(min = 5, max = 20)
	@Column(name = "Parola", nullable = false, length = 60)
	private String parola;
	
	@Column(name = "Soyad", nullable = false, length = 45)
	private String soyad;
	
	@Column(name = "TCNO", nullable = false, length = 11)
	private String tcno;

	public Admin() {
	}

	public int getAdminID() {
		return this.adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getEposta() {
		return this.eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getParola() {
		return this.parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getSoyad() {
		return this.soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTcno() {
		return this.tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}


	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", ad=" + ad + ", eposta=" + eposta + ", parola=" + parola + ", soyad="
				+ soyad + ", tcno=" + tcno +  "]";
	}
}