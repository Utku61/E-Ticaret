package com.kbhkn.eticaret.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Urun")
public class Urun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UrunID", unique=true, nullable=false)
	private int urunID;

	@Column(name="Aciklama", nullable=false, length=45)
	private String aciklama;

	@Column(name="Fiyat", nullable=false)
	private double fiyat;

	@Lob
	@Column(name="Resim", nullable=false)
	private byte[] resim;

	@Column(name="StokMiktar", nullable=false)
	private int stokMiktar;

	@Column(name="UrunAdi", nullable=false, length=45)
	private String urunAdi;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "urun", cascade = CascadeType.ALL)
	private List<Siparis> siparis;

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

	public byte[] getResim() {
		return this.resim;
	}

	public void setResim(byte[] resim) {
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

	public List<Siparis> getSiparis() {
		return this.siparis;
	}

	public void setSiparis(List<Siparis> siparis) {
		this.siparis = siparis;
	}

	public AltKategori getAltKategori() {
		return altKategori;
	}

	public void setAltKategori(AltKategori altKategori) {
		this.altKategori = altKategori;
	}

	@Override
	public String toString() {
		return "Urun [urunID=" + urunID + ", aciklama=" + aciklama + ", fiyat=" + fiyat + ", resim="
				 + ", stokMiktar=" + stokMiktar + ", urunAdi=" + urunAdi + ", siparis="
				+ siparis + ", altkatagori=" + altKategori.toString() + "]";
	}
}