package com.kbhkn.eticaret.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="OdemeSecenek")
public class OdemeSecenek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="OdemeSecenekID", unique=true, nullable=false)
	private int odemeSecenekID;

	@Column(name="OdemeTipi", nullable=false, length=45)
	private String odemeTipi;

	@OneToMany(fetch = FetchType.LAZY, mappedBy="odemeSecenek", cascade = CascadeType.ALL)
	private List<Siparis> siparis;

	public OdemeSecenek() {
	}

	public int getOdemeSecenekID() {
		return this.odemeSecenekID;
	}

	public void setOdemeSecenekID(int odemeSecenekID) {
		this.odemeSecenekID = odemeSecenekID;
	}

	public String getOdemeTipi() {
		return this.odemeTipi;
	}

	public void setOdemeTipi(String odemeTipi) {
		this.odemeTipi = odemeTipi;
	}

	public List<Siparis> getSiparis() {
		return this.siparis;
	}

	public void setSiparis(List<Siparis> siparis) {
		this.siparis = siparis;
	}

	@Override
	public String toString() {
		return "OdemeSecenek [odemeSecenekID=" + odemeSecenekID + ", odemeTipi=" + odemeTipi + ", siparis=" + siparis + "]";
	}
}