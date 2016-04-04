package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Musteri")
public class Musteri implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MusteriID", unique=true, nullable=false)
	private int musteriID;

	@Column(name="Ad", nullable=false, length=45)
	private String ad;

	@Column(name="Adres", nullable=false, length=100)
	private String adres;

	@Column(name="CepNo", nullable=false, length=45)
	private String cepNo;

	@Column(name="Eposta", nullable=false, length=45)
	private String eposta;

	@Column(nullable=false, length=45)
	private String IPAdress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="KayitTarihi", nullable=false)
	private Date kayitTarihi;

	@Column(name="Parola", nullable=false, length=45)
	private String parola;

	@Column(name="Soyad", nullable=false, length=45)
	private String soyad;

	@Column(name="TCNO", nullable=false, length=11)
	private String tcno;

	@Column(name="TelefonNo", nullable=false, length=45)
	private String telefonNo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SehirID")
	private Sehir sehir;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="yetkiNo")
	private Yetki yetki;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="musteriler", cascade = CascadeType.ALL)
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

	public Sehir getSehirler() {
		return this.sehir;
	}

	public void setSehirler(Sehir sehir) {
		this.sehir = sehir;
	}

	public Yetki getYetki() {
		return this.yetki;
	}

	public void setYetki(Yetki yetki) {
		this.yetki = yetki;
	}

	public List<Siparis> getSiparis() {
		return this.siparis;
	}

	public void setSiparis(List<Siparis> siparis) {
		this.siparis = siparis;
	}

	@Override
	public String toString() {
		return "Musteriler [musteriID=" + musteriID + ", ad=" + ad + ", adres=" + adres + ", cepNo=" + cepNo
				+ ", eposta=" + eposta + ", IPAdress=" + IPAdress + ", kayitTarihi=" + kayitTarihi + ", parola="
				+ parola + ", soyad=" + soyad + ", tcno=" + tcno + ", telefonNo=" + telefonNo + ", sehir=" + sehir
				+ ", yetki=" + yetki + ", siparis=" + siparis + "]";
	}
}