package com.kbhkn.eticaret.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Urun")
public class Urun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UrunID", unique=true, nullable=false)
	private int urunID;
	
	@NotEmpty
	@Column(name="Aciklama", nullable=false, length=45)
	private String aciklama;

	@NotNull
	@Column(name="Fiyat", nullable=false)
	private double fiyat;

	@NotEmpty
	@Column(name="Resim", nullable=false)
	private String resim;

	@NotNull
	@Column(name="StokMiktar", nullable=false)
	private int stokMiktar;

	@NotEmpty
	@Column(name="UrunAdi", nullable=false, length=45)
	private String urunAdi;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "urun", cascade = CascadeType.ALL)
//	private List<Siparis> siparis;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="AltKategoriID", nullable = false)
	private AltKategori altKategori;

	public Urun() {
	}

	public int getUrunID() {
		return this.urunID;
	}

	public void setUrunID(int urunID) {
		this.urunID = urunID;
	}

	public String getAciklama() {
		return this.aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public double getFiyat() {
		return this.fiyat;
	}

	public void setFiyat(double fiyat) {
		this.fiyat = fiyat;
	}

	public String getResim() {
		return this.resim;
	}

	public void setResim(String resim) {
		this.resim = resim;
	}

	public int getStokMiktar() {
		return this.stokMiktar;
	}

	public void setStokMiktar(int stokMiktar) {
		this.stokMiktar = stokMiktar;
	}

	public String getUrunAdi() {
		return this.urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

//	public List<Siparis> getSiparis() {
//		return this.siparis;
//	}
//
//	public void setSiparis(List<Siparis> siparis) {
//		this.siparis = siparis;
//	}

	public AltKategori getAltKategori() {
		return altKategori;
	}

	public void setAltKategori(AltKategori altKategori) {
		this.altKategori = altKategori;
	}

	@Override
	public String toString() {
		return "Urun [urunID=" + urunID + ", aciklama=" + aciklama + ", fiyat=" + fiyat + ", resim=" + resim
				+ ", stokMiktar=" + stokMiktar + ", urunAdi=" + urunAdi + ", altKategori=" + altKategori + "]";
	}
}