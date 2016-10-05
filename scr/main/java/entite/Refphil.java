package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the refphil database table.
 * 
 */
@Entity
@NamedQuery(name="Refphil.findAll", query="SELECT r FROM Refphil r")
public class Refphil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRefPhil;

	private String ac;

	private String descrip;

	private int idArtNouv;

	private int idMarch;

	private int idPere;

	private String numero;

	private BigDecimal nv;

	private String stkOrd;

	private BigDecimal txChange;

	private BigDecimal vf;

	//bi-directional many-to-one association to Artphil
	@OneToMany(mappedBy="refphil")
	private List<Artphil> artphils;

	//bi-directional many-to-one association to Jointheme
	@OneToMany(mappedBy="refphil")
	private List<Jointheme> jointhemes;

	//bi-directional many-to-one association to Refcote
	@OneToMany(mappedBy="refphil")
	private List<Refcote> refcotes;

	//bi-directional many-to-one association to Refannee
	@ManyToOne
	@JoinColumn(name="idRefAnnee")
	private Refannee refannee;

	public Refphil() {
	}

	public int getIdRefPhil() {
		return this.idRefPhil;
	}

	public void setIdRefPhil(int idRefPhil) {
		this.idRefPhil = idRefPhil;
	}

	public String getAc() {
		return this.ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public int getIdArtNouv() {
		return this.idArtNouv;
	}

	public void setIdArtNouv(int idArtNouv) {
		this.idArtNouv = idArtNouv;
	}

	public int getIdMarch() {
		return this.idMarch;
	}

	public void setIdMarch(int idMarch) {
		this.idMarch = idMarch;
	}

	public int getIdPere() {
		return this.idPere;
	}

	public void setIdPere(int idPere) {
		this.idPere = idPere;
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

	public String getStkOrd() {
		return this.stkOrd;
	}

	public void setStkOrd(String stkOrd) {
		this.stkOrd = stkOrd;
	}

	public BigDecimal getTxChange() {
		return this.txChange;
	}

	public void setTxChange(BigDecimal txChange) {
		this.txChange = txChange;
	}

	public BigDecimal getVf() {
		return this.vf;
	}

	public void setVf(BigDecimal vf) {
		this.vf = vf;
	}

	public List<Artphil> getArtphils() {
		return this.artphils;
	}

	public void setArtphils(List<Artphil> artphils) {
		this.artphils = artphils;
	}

	public Artphil addArtphil(Artphil artphil) {
		getArtphils().add(artphil);
		artphil.setRefphil(this);

		return artphil;
	}

	public Artphil removeArtphil(Artphil artphil) {
		getArtphils().remove(artphil);
		artphil.setRefphil(null);

		return artphil;
	}

	public List<Jointheme> getJointhemes() {
		return this.jointhemes;
	}

	public void setJointhemes(List<Jointheme> jointhemes) {
		this.jointhemes = jointhemes;
	}

	public Jointheme addJointheme(Jointheme jointheme) {
		getJointhemes().add(jointheme);
		jointheme.setRefphil(this);

		return jointheme;
	}

	public Jointheme removeJointheme(Jointheme jointheme) {
		getJointhemes().remove(jointheme);
		jointheme.setRefphil(null);

		return jointheme;
	}

	public List<Refcote> getRefcotes() {
		return this.refcotes;
	}

	public void setRefcotes(List<Refcote> refcotes) {
		this.refcotes = refcotes;
	}

	public Refcote addRefcote(Refcote refcote) {
		getRefcotes().add(refcote);
		refcote.setRefphil(this);

		return refcote;
	}

	public Refcote removeRefcote(Refcote refcote) {
		getRefcotes().remove(refcote);
		refcote.setRefphil(null);

		return refcote;
	}

	public Refannee getRefannee() {
		return this.refannee;
	}

	public void setRefannee(Refannee refannee) {
		this.refannee = refannee;
	}

}