package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import com.kbhkn.eticaret.model.Siparis;

import java.util.List;

@Entity
@Table(name="Kargo")
public class Kargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="KargoID", unique=true, nullable=false)
	private int kargoID;
	
	@NotEmpty
	@Column(name="Aciklama", length=45)
	private String aciklama;

	@NotEmpty
	@Column(name="Ad", nullable=false, length=45)
	private String ad;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kargo", cascade = CascadeType.ALL)
	private List<Siparis> siparis;

	public Kargo() {
		super();
	}
	
	public Kargo(int kargoID) {
		super();
		this.kargoID = kargoID;
	}

	public int getKargoID() {
		return this.kargoID;
	}

	public void setKargoID(int kargoID) {
		this.kargoID = kargoID;
	}

	public String getAciklama() {
		return this.aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	@Override
	public String toString() {
		return "Kargo [kargoID=" + kargoID + ", aciklama=" + aciklama + ", ad=" + ad + ", siparis=" + siparis + "]";
	}
}