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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Kategori")
public class Kategori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KategoriID")
	private int kategoriID;
	
	@NotEmpty
	@Column(name = "KategoriAdi")
	private String kategoriAdi;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UstKategoriID", nullable=false)
	private UstKategori ustKategori;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kategori", cascade = CascadeType.ALL)
	private List<AltKategori> altKategoris;

	public Kategori() {
	}

	public int getKategoriID() {
		return kategoriID;
	}

	public void setKategoriID(int kategoriID) {
		this.kategoriID = kategoriID;
	}


	public String getKategoriAdi() {
		return kategoriAdi;
	}


	public void setKategoriAdi(String kategoriAdi) {
		this.kategoriAdi = kategoriAdi;
	}


	public UstKategori getUstKategori() {
		return ustKategori;
	}


	public void setUstKategori(UstKategori ustKategori) {
		this.ustKategori = ustKategori;
	}


	public List<AltKategori> getAltKategoris() {
		return altKategoris;
	}


	public void setAltKategoris(List<AltKategori> altKategoris) {
		this.altKategoris = altKategoris;
	}


	@Override
	public String toString() {
		return "Kategori [kategoriID=" + kategoriID + ", kategoriAdi=" + kategoriAdi + ", altKategoris=" + altKategoris
				+ ", ustKategori=" + ustKategori + "]";
	}
}