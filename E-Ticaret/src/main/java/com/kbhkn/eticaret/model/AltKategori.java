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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AltKategori")
public class AltKategori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AltKategoriID")
	private int altKategoriID;

	@Column(name="AltKategoriAdi")
	private String altKategoriAdi;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="KategoriID")
	private Kategori kategori;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="altKategori", cascade = CascadeType.ALL)
	private List<Urun> uruns;

	public AltKategori() {
	}

	public int getAltKategoriID() {
		return this.altKategoriID;
	}

	public void setAltKategoriID(int altKategoriID) {
		this.altKategoriID = altKategoriID;
	}

	public String getAltKategoriAdi() {
		return this.altKategoriAdi;
	}

	public void setAltKategoriAdi(String altKategoriAdi) {
		this.altKategoriAdi = altKategoriAdi;
	}

	public Kategori getKategori() {
		return this.kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	public List<Urun> getUruns() {
		return this.uruns;
	}

	public void setUruns(List<Urun> uruns) {
		this.uruns = uruns;
	}

	@Override
	public String toString() {
		return "AltKategori [altKategoriID=" + altKategoriID + ", altKategoriAdi=" + altKategoriAdi + ", kategori="
				+ kategori + ", uruns=" + uruns + "]";
	}
}
