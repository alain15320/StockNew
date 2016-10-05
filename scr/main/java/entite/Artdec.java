package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the artdec database table.
 * 
 */
@Entity
@NamedQuery(name="Artdec.findAll", query="SELECT a FROM Artdec a")
public class Artdec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArtDec;

	private String decOrd;

	private String etat;

	private String form;

	private int idInvent;

	private int idMarch;

	@Temporal(TemporalType.TIMESTAMP)
	private Date majQuan;

	private String numero;

	private BigDecimal nv;

	private BigDecimal pria;

	private BigDecimal prix;

	private byte tar;

	private BigDecimal vf;

	//bi-directional many-to-one association to Artannee
	@OneToMany(mappedBy="artdec")
	private List<Artannee> artannees;

	//bi-directional many-to-one association to Refdec
	@ManyToOne
	@JoinColumn(name="idRefDec")
	private Refdec refdec;

	//bi-directional many-to-one association to Artrub
	@ManyToOne
	@JoinColumn(name="idArtRub")
	private Artrub artrub;

	//bi-directional many-to-one association to Page
	@ManyToOne
	@JoinColumn(name="idPage")
	private Page page;

	public Artdec() {
	}

	public int getIdArtDec() {
		return this.idArtDec;
	}

	public void setIdArtDec(int idArtDec) {
		this.idArtDec = idArtDec;
	}

	public String getDecOrd() {
		return this.decOrd;
	}

	public void setDecOrd(String decOrd) {
		this.decOrd = decOrd;
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

	public List<Artannee> getArtannees() {
		return this.artannees;
	}

	public void setArtannees(List<Artannee> artannees) {
		this.artannees = artannees;
	}

	public Artannee addArtannee(Artannee artannee) {
		getArtannees().add(artannee);
		artannee.setArtdec(this);

		return artannee;
	}

	public Artannee removeArtannee(Artannee artannee) {
		getArtannees().remove(artannee);
		artannee.setArtdec(null);

		return artannee;
	}

	public Refdec getRefdec() {
		return this.refdec;
	}

	public void setRefdec(Refdec refdec) {
		this.refdec = refdec;
	}

	public Artrub getArtrub() {
		return this.artrub;
	}

	public void setArtrub(Artrub artrub) {
		this.artrub = artrub;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}