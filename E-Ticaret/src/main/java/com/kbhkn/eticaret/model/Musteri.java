package com.kbhkn.eticaret.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Musteri")
public class Musteri implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MusteriID", unique=true, nullable=false)
	private int musteriID;
	
	@NotEmpty
	@Column(name="Ad", nullable=false, length=45)
	private String ad;
	
	@NotEmpty
	@Column(name="Adres", nullable=false, length=100)
	private String adres;
	
	@NotEmpty
	@Column(name="CepNo", nullable=false, length=45)
	private String cepNo;
	
	@NotEmpty
	@Email
	@Column(name="Eposta", nullable=false, unique=true, length=45)
	private String eposta;
	
	@Column(nullable=false, length=45)
	private String IPAdress;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="KayitTarihi", nullable=false)
	private Date kayitTarihi;
	
	@NotEmpty
	@Size(min = 5, max = 20)
	@Column(name="Parola", nullable=false, length=45)
	private String parola;
	
	@NotEmpty
	@Column(name="Soyad", nullable=false, length=45)
	private String soyad;
	
	@NotEmpty
	@Column(name="TCNO", nullable=false,  unique=true, length=11)
	private String tcno;
	
	@NotEmpty
	@Column(name="TelefonNo", nullable=false, length=45)
	private String telefonNo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SehirID")
	private Sehir sehir;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="musteri", cascade = CascadeType.ALL)
	private List<Siparis> siparis;

	public Musteri() {
	}

	public int getMusteriID() {
		return this.musteriID;
	}

	public void setMusteriID(int musteriID) {
		this.musteriID = musteriID;
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getCepNo() {
		return this.cepNo;
	}

	public void setCepNo(String cepNo) {
		this.cepNo = cepNo;
	}

	public String getEposta() {
		return this.eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getIPAdress() {
		return this.IPAdress;
	}

	public void setIPAdress(String IPAdress) {
		this.IPAdress = IPAdress;
	}

	public Date getKayitTarihi() {
		return this.kayitTarihi;
	}

	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
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

	public String getTelefonNo() {
		return this.telefonNo;
	}

	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}

	public List<Siparis> getSiparis() {
		return this.siparis;
	}

	public void setSiparis(List<Siparis> siparis) {
		this.siparis = siparis;
	}
	
	public Sehir getSehir() {
		return sehir;
	}

	public void setSehir(Sehir sehir) {
		this.sehir = sehir;
	}

	@Override
	public String toString() {
		return "Musteri [musteriID=" + musteriID + ", ad=" + ad + ", adres=" + adres + ", cepNo=" + cepNo + ", eposta=" + eposta + ", soyad=" + soyad + "]";
	}
}