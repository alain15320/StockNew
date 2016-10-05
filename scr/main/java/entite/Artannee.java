package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the artannee database table.
 * 
 */
@Entity
@NamedQuery(name="Artannee.findAll", query="SELECT a FROM Artannee a")
public class Artannee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArtAnnee;

	private String annOrd;

	private String cat;

	private String etat;

	private String form;

	private int idInvent;

	private int idMarch;

	@Temporal(TemporalType.TIMESTAMP)
	private Date majQuan;

	private byte photo;

	private BigDecimal pria;

	private BigDecimal prix;

	private byte tar;

	private BigDecimal vf;

	//bi-directional many-to-one association to Refannee
	@ManyToOne
	@JoinColumn(name="idRefAnnee")
	private Refannee refannee;

	//bi-directional many-to-one association to Artdec
	@ManyToOne
	@JoinColumn(name="idArtDec")
	private Artdec artdec;

	//bi-directional many-to-one association to Page
	@ManyToOne
	@JoinColumn(name="idPage")
	private Page page;

	//bi-directional many-to-one association to Artphil
	@OneToMany(mappedBy="artannee")
	private List<Artphil> artphils;

	public Artannee() {
	}

	public int getIdArtAnnee() {
		return this.idArtAnnee;
	}

	public void setIdArtAnnee(int idArtAnnee) {
		this.idArtAnnee = idArtAnnee;
	}

	public String getAnnOrd() {
		return this.annOrd;
	}

	public void setAnnOrd(String annOrd) {
		this.annOrd = annOrd;
	}

	public String getCat() {
		return this.cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public int getIdInvent() {
		return this.idInvent;
	}

	public void setIdInvent(int idInvent) {
		this.idInvent = idInvent;
	}

	public int getIdMarch() {
		return this.idMarch;
	}

	public void setIdMarch(int idMarch) {
		this.idMarch = idMarch;
	}

	public Date getMajQuan() {
		return this.majQuan;
	}

	public void setMajQuan(Date majQuan) {
		this.majQuan = majQuan;
	}

	public byte getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte photo) {
		this.photo = photo;
	}

	public BigDecimal getPria() {
		return this.pria;
	}

	public void setPria(BigDecimal pria) {
		this.pria = pria;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public byte getTar() {
		return this.tar;
	}

	public void setTar(byte tar) {
		this.tar = tar;
	}

	public BigDecimal getVf() {
		return this.vf;
	}

	public void setVf(BigDecimal vf) {
		this.vf = vf;
	}

	public Refannee getRefannee() {
		return this.refannee;
	}

	public void setRefannee(Refannee refannee) {
		this.refannee = refannee;
	}

	public Artdec getArtdec() {
		return this.artdec;
	}

	public void setArtdec(Artdec artdec) {
		this.artdec = artdec;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Artphil> getArtphils() {
		return this.artphils;
	}

	public void setArtphils(List<Artphil> artphils) {
		this.artphils = artphils;
	}

	public Artphil addArtphil(Artphil artphil) {
		getArtphils().add(artphil);
		artphil.setArtannee(this);

		return artphil;
	}

	public Artphil removeArtphil(Artphil artphil) {
		getArtphils().remove(artphil);
		artphil.setArtannee(null);

		return artphil;
	}

}