package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name="Siparis")
public class Siparis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SiparisID", unique=true, nullable=false)
	private int siparisID;

	@Column(name="Adet", nullable=false)
	private int adet;

	@Column(name="Fiyat", nullable=false)
	private double fiyat;

	@Column(name="TeslimEdilecekAdres", nullable=false, length=90)
	private String teslimEdilecekAdres;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TeslimTarihi")
	private Date teslimTarihi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="VerilisTarihi", nullable=false)
	private Date verilisTarihi;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="KargoID", nullable=false)
	private Kargo kargo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MusteriID", nullable=false)
	private Musteriler musteriler;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="OdemeSecenekID", nullable=false)
	private OdemeSecenek odemeSecenek;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="SiparisDurumID", nullable=false)
	private SiparisDurum siparisDurum;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="UrunID", nullable=false)
	private Urun urun;

	public Siparis() {
	}

	public int getSiparisID() {
		return this.siparisID;
	}

	public void setSiparisID(int siparisID) {
		this.siparisID = siparisID;
	}

	public int getAdet() {
		return this.adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	public double getFiyat() {
		return this.fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public String getTeslimEdilecekAdres() {
		return this.teslimEdilecekAdres;
	}

	public void setTeslimEdilecekAdres(String teslimEdilecekAdres) {
		this.teslimEdilecekAdres = teslimEdilecekAdres;
	}

	public Date getTeslimTarihi() {
		return this.teslimTarihi;
	}

	public void setTeslimTarihi(Date teslimTarihi) {
		this.teslimTarihi = teslimTarihi;
	}

	public Date getVerilisTarihi() {
		return this.verilisTarihi;
	}

	public void setVerilisTarihi(Date verilisTarihi) {
		this.verilisTarihi = verilisTarihi;
	}

	public Kargo getKargo() {
		return this.kargo;
	}

	public void setKargo(Kargo kargo) {
		this.kargo = kargo;
	}

	public Musteriler getMusteriler() {
		return this.musteriler;
	}

	public void setMusteriler(Musteriler musteriler) {
		this.musteriler = musteriler;
	}

	public OdemeSecenek getOdemeSecenek() {
		return this.odemeSecenek;
	}

	public void setOdemeSecenek(OdemeSecenek odemeSecenek) {
		this.odemeSecenek = odemeSecenek;
	}

	public SiparisDurum getSiparisDurum() {
		return this.siparisDurum;
	}

	public void setSiparisDurum(SiparisDurum siparisDurum) {
		this.siparisDurum = siparisDurum;
	}

	public Urun getUrun() {
		return this.urun;
	}

	public void setUrun(Urun urun) {
		this.urun = urun;
	}

	@Override
	public String toString() {
		return "Siparis [siparisID=" + siparisID + ", adet=" + adet + ", fiyat=" + fiyat + ", teslimEdilecekAdres="
				+ teslimEdilecekAdres + ", teslimTarihi=" + teslimTarihi + ", verilisTarihi=" + verilisTarihi
				+ ", kargo=" + kargo + ", musteriler=" + musteriler + ", odemeSecenek=" + odemeSecenek
				+ ", siparisDurum=" + siparisDurum + ", urun=" + urun + "]";
	}
}