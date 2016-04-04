package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="SiparisDurum")
public class SiparisDurum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SiparisDurumID", unique=true, nullable=false)
	private int siparisDurumID;

	@Column(name="Durum", nullable=false, length=45)
	private String durum;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="siparisDurum", cascade = CascadeType.ALL)
	private List<Siparis> siparis;

	public SiparisDurum() {
	}

	public int getSiparisDurumID() {
		return this.siparisDurumID;
	}

	public void setSiparisDurumID(int siparisDurumID) {
		this.siparisDurumID = siparisDurumID;
	}

	public String getDurum() {
		return this.durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}

	public List<Siparis> getSiparis() {
		return this.siparis;
	}

	public void setSiparis(List<Siparis> siparis) {
		this.siparis = siparis;
	}

	@Override
	public String toString() {
		return "SiparisDurum [siparisDurumID=" + siparisDurumID + ", durum=" + durum + "]";
	}
}