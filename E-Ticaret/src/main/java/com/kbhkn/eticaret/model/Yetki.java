package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="Yetki")
public class Yetki implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int yetkiNo;

	@Column(nullable=false, length=45)
	private String yetkiAdi;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "yetki", cascade = CascadeType.ALL)
	private List<Musteri> musteris;

	public Yetki() {
		super();
	}
	
	public Yetki(int yetkiNo) {
		super();
		this.yetkiNo = yetkiNo;
	}
	
	public Yetki(String yetkiAdi) {
		super();
		this.yetkiAdi = yetkiAdi;
	}

	public int getYetkiNo() {
		return this.yetkiNo;
	}

	public void setYetkiNo(int yetkiNo) {
		this.yetkiNo = yetkiNo;
	}

	public String getYetkiAdi() {
		return this.yetkiAdi;
	}

	public void setYetkiAdi(String yetkiAdi) {
		this.yetkiAdi = yetkiAdi;
	}

	@Override
	public String toString() {
		return "Yetki [yetkiNo=" + yetkiNo + ", yetkiAdi=" + yetkiAdi + "]";
	}
}