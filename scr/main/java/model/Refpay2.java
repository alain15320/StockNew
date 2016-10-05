package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the refpays database table.
 * 
 */
@Entity
@Table(name="refpays")
@NamedQuery(name="Refpay.findAll", query="SELECT r FROM Refpay r")
public class Refpay2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPays;

	private String couleur;

	private int idGrp;

	private byte nouv;

	private int nv;

	private String pays;

	private BigDecimal txChange;

	//bi-directional one-to-one association to Pay
	@OneToOne
	@JoinColumn(name="idPays")
	private Pay2 pay;

	public Refpay2() {
	}

	public int getIdPays() {
		return this.idPays;
	}

	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getIdGrp() {
		return this.idGrp;
	}

	public void setIdGrp(int idGrp) {
		this.idGrp = idGrp;
	}

	public byte getNouv() {
		return this.nouv;
	}

	public void setNouv(byte nouv) {
		this.nouv = nouv;
	}

	public int getNv() {
		return this.nv;
	}

	public void setNv(int nv) {
		this.nv = nv;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public BigDecimal getTxChange() {
		return this.txChange;
	}

	public void setTxChange(BigDecimal txChange) {
		this.txChange = txChange;
	}

	public Pay2 getPay() {
		return this.pay;
	}

	public void setPay(Pay2 pay) {
		this.pay = pay;
	}

}