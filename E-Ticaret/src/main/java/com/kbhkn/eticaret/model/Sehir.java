package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="Sehir")
public class Sehir implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SehirID", unique=true, nullable=false)
	private int sehirID;

	@Column(name="SehirAdi", nullable=false, length=45)
	private String sehirAdi;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="sehir", cascade = CascadeType.ALL)
	private List<Musteri> musterilers;

	public Sehir() {
	}

	public int getSehirID() {
		return this.sehirID;
	}

	public void setSehirID(int sehirID) {
		this.sehirID = sehirID;
	}

	public String getSehirAdi() {
		return this.sehirAdi;
	}

	public void setSehirAdi(String sehirAdi) {
		this.sehirAdi = sehirAdi;
	}

	public List<Musteri> getMusterilers() {
		return this.musterilers;
	}

	public void setMusterilers(List<Musteri> musterilers) {
		this.musterilers = musterilers;
	}

	@Override
	public String toString() {
		return "Sehirler [sehirID=" + sehirID + ", sehirAdi=" + sehirAdi + "]";
	}
}