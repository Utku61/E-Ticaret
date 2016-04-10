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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UstKategori")
public class UstKategori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UstKategoriID")
	private int ustKategoriID;

	@Column(name="UstKatagoriAdi")
	private String ustKategoriAdi;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="ustKategori", cascade = CascadeType.ALL)
	private List<Kategori> kategoris;

	public UstKategori() {
	}

	public int getUstKategoriID() {
		return ustKategoriID;
	}

	public void setUstKategoriID(int ustKategoriID) {
		this.ustKategoriID = ustKategoriID;
	}

	public String getUstKategoriAdi() {
		return ustKategoriAdi;
	}

	public void setUstKategoriAdi(String ustKategoriAdi) {
		this.ustKategoriAdi = ustKategoriAdi;
	}

	public List<Kategori> getKategoris() {
		return kategoris;
	}

	public void setKategoris(List<Kategori> kategoris) {
		this.kategoris = kategoris;
	}

	@Override
	public String toString() {
		return "UstKategori [ustKategoriID=" + ustKategoriID + ", ustKategoriAdi=" + ustKategoriAdi + ", kategoris="
				+ kategoris + "]";
	}
}