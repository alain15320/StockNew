package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the refpays database table.
 * 
 */
@Entity
@Table(name="refpays")
@NamedQuery(name="Refpay.findAll", query="SELECT r FROM Refpay r")
public class Refpay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPays;

	private int nv;

	private String pays;

	//bi-directional many-to-one association to Artpay
	@OneToMany(mappedBy="refpay")
	private List<Artpay> artpays;

	//bi-directional one-to-one association to Pay
	@OneToOne
	@JoinColumn(name="idPays")
	private Pay pay;

	//bi-directional many-to-one association to Groupe
	@ManyToOne
	@JoinColumn(name="idGrp")
	private Groupe groupe;

	//bi-directional many-to-one association to Refrub
	@OneToMany(mappedBy="refpay")
	private List<Refrub> refrubs;

	public Refpay() {
	}

	public int getIdPays() {
		return this.idPays;
	}

	public void setIdPays(int idPays) {
		this.idPays = idPays;
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

	public List<Artpay> getArtpays() {
		return this.artpays;
	}

	public void setArtpays(List<Artpay> artpays) {
		this.artpays = artpays;
	}

	public Artpay addArtpay(Artpay artpay) {
		getArtpays().add(artpay);
		artpay.setRefpay(this);

		return artpay;
	}

	public Artpay removeArtpay(Artpay artpay) {
		getArtpays().remove(artpay);
		artpay.setRefpay(null);

		return artpay;
	}

	public Pay getPay() {
		return this.pay;
	}

	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public List<Refrub> getRefrubs() {
		return this.refrubs;
	}

	public void setRefrubs(List<Refrub> refrubs) {
		this.refrubs = refrubs;
	}

	public Refrub addRefrub(Refrub refrub) {
		getRefrubs().add(refrub);
		refrub.setRefpay(this);

		return refrub;
	}

	public Refrub removeRefrub(Refrub refrub) {
		getRefrubs().remove(refrub);
		refrub.setRefpay(null);

		return refrub;
	}

}