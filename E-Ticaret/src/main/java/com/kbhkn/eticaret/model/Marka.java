package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;

import com.kbhkn.eticaret.model.Urun;

import java.util.Arrays;
import java.util.List;


@Entity
@Table(name="Marka")
public class Marka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MarkaID", unique=true, nullable=false)
	private int markaID;

	@Column(name="MarkaAciklama", nullable=false, length=45)
	private String markaAciklama;

	@Column(name="MarkaAdi", nullable=false, length=45)
	private String markaAdi;

	@Lob
	@Column(name="MarkaLogo", nullable=false)
	private byte[] markaLogo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="marka", cascade = CascadeType.ALL)
	private List<Urun> uruns;

	public Marka() {
	}

	public int getMarkaID() {
		return this.markaID;
	}

	public void setMarkaID(int markaID) {
		this.markaID = markaID;
	}

	public String getMarkaAciklama() {
		return this.markaAciklama;
	}

	public void setMarkaAciklama(String markaAciklama) {
		this.markaAciklama = markaAciklama;
	}

	public String getMarkaAdi() {
		return this.markaAdi;
	}

	public void setMarkaAdi(String markaAdi) {
		this.markaAdi = markaAdi;
	}

	public byte[] getMarkaLogo() {
		return this.markaLogo;
	}

	public void setMarkaLogo(byte[] markaLogo) {
		this.markaLogo = markaLogo;
	}

	public List<Urun> getUruns() {
		return this.uruns;
	}

	public void setUruns(List<Urun> uruns) {
		this.uruns = uruns;
	}

	@Override
	public String toString() {
		return "Marka [markaID=" + markaID + ", markaAciklama=" + markaAciklama + ", markaAdi=" + markaAdi
				+ ", markaLogo=" + Arrays.toString(markaLogo) + ", uruns=" + uruns + "]";
	}
}