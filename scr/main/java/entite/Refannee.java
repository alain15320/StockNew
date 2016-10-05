package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the refannee database table.
 * 
 */
@Entity
@NamedQuery(name="Refannee.findAll", query="SELECT r FROM Refannee r")
public class Refannee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRefAnnee;

	private String annee;

	private String annOrd;

	private int idMarch;

	private String numero;

	private BigDecimal nv;

	//bi-directional many-to-one association to Artannee
	@OneToMany(mappedBy="refannee")
	private List<Artannee> artannees;

	//bi-directional many-to-one association to Refdec
	@ManyToOne
	@JoinColumn(name="idRefDec")
	private Refdec refdec;

	//bi-directional many-to-one association to Refphil
	@OneToMany(mappedBy="refannee")
	private List<Refphil> refphils;

	public Refannee() {
	}

	public int getIdRefAnnee() {
		return this.idRefAnnee;
	}

	public void setIdRefAnnee(int idRefAnnee) {
		this.idRefAnnee = idRefAnnee;
	}

	public String getAnnee() {
		return this.annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getAnnOrd() {
		return this.annOrd;
	}

	public void setAnnOrd(String annOrd) {
		this.annOrd = annOrd;
	}

	public int getIdMarch() {
		return this.idMarch;
	}

	public void setIdMarch(int idMarch) {
		this.idMarch = idMarch;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getNv() {
		return this.nv;
	}

	public void setNv(BigDecimal nv) {
		this.nv = nv;
	}

	public List<Artannee> getArtannees() {
		return this.artannees;
	}

	public void setArtannees(List<Artannee> artannees) {
		this.artannees = artannees;
	}

	public Artannee addArtannee(Artannee artannee) {
		getArtannees().add(artannee);
		artannee.setRefannee(this);

		return artannee;
	}

	public Artannee removeArtannee(Artannee artannee) {
		getArtannees().remove(artannee);
		artannee.setRefannee(null);

		return artannee;
	}

	public Refdec getRefdec() {
		return this.refdec;
	}

	public void setRefdec(Refdec refdec) {
		this.refdec = refdec;
	}

	public List<Refphil> getRefphils() {
		return this.refphils;
	}

	public void setRefphils(List<Refphil> refphils) {
		this.refphils = refphils;
	}

	public Refphil addRefphil(Refphil refphil) {
		getRefphils().add(refphil);
		refphil.setRefannee(this);

		return refphil;
	}

	public Refphil removeRefphil(Refphil refphil) {
		getRefphils().remove(refphil);
		refphil.setRefannee(null);

		return refphil;
	}

}