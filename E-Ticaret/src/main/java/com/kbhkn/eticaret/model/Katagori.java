package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;

import com.kbhkn.eticaret.model.Urun;

import java.util.List;


@Entity
@Table(name="Katagori")
public class Katagori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="KatagoriID", unique=true, nullable=false)
	private int katagoriID;

	@Column(name="KatagoriAdi", nullable=false, length=45)
	private String katagoriAdi;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "katagori", cascade = CascadeType.ALL)
	private List<Urun> uruns;

	public Katagori() {
	}

	public int getKatagoriID() {
		return this.katagoriID;
	}

	public void setKatagoriID(int katagoriID) {
		this.katagoriID = katagoriID;
	}

	public String getKatagoriAdi() {
		return this.katagoriAdi;
	}

	public void setKatagoriAdi(String katagoriAdi) {
		this.katagoriAdi = katagoriAdi;
	}

	public List<Urun> getUruns() {
		return this.uruns;
	}

	public void setUruns(List<Urun> uruns) {
		this.uruns = uruns;
	}

	@Override
	public String toString() {
		return "Katagori [katagoriID=" + katagoriID + ", katagoriAdi=" + katagoriAdi + ", uruns=" + uruns + "]";
	}
}