package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the artphil database table.
 * 
 */
@Entity
@NamedQuery(name="Artphil.findAll", query="SELECT a FROM Artphil a")
public class Artphil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArtPhil;

	private String ac;

	private String cat;

	private String descrip;

	private String etat;

	private String form;

	private int idArtNouv;

	private int idInvent;

	private int idMarch;

	private String idSite;

	@Temporal(TemporalType.TIMESTAMP)
	private Date majQuan;

	private BigDecimal nv;

	private BigDecimal pria;

	private BigDecimal prix;

	private byte pt;

	private String stkOrd;

	private byte tar;

	//bi-directional many-to-one association to Artcote
	@OneToMany(mappedBy="artphil")
	private List<Artcote> artcotes;

	//bi-directional many-to-one association to Artnouv
	@OneToMany(mappedBy="artphil")
	private List<Artnouv> artnouvs;

	//bi-directional many-to-one association to Refphil
	@ManyToOne
	@JoinColumn(name="idRefPhil")
	private Refphil refphil;

	//bi-directional many-to-one association to Artannee
	@ManyToOne
	@JoinColumn(name="idArtAnnee")
	private Artannee artannee;

	//bi-directional many-to-one association to Page
	@ManyToOne
	@JoinColumn(name="idPage")
	private Page page;

	//bi-directional many-to-one association to Artspec
	@OneToMany(mappedBy="artphil")
	private List<Artspec> artspecs;

	public Artphil() {
	}

	public int getIdArtPhil() {
		return this.idArtPhil;
	}

	public void setIdArtPhil(int idArtPhil) {
		this.idArtPhil = idArtPhil;
	}

	public String getAc() {
		return this.ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getCat() {
		return this.cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
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

	public int getIdArtNouv() {
		return this.idArtNouv;
	}

	public void setIdArtNouv(int idArtNouv) {
		this.idArtNouv = idArtNouv;
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

	public String getIdSite() {
		return this.idSite;
	}

	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public Date getMajQuan() {
		return this.majQuan;
	}

	public void setMajQuan(Date majQuan) {
		this.majQuan = majQuan;
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

	public byte getPt() {
		return this.pt;
	}

	public void setPt(byte pt) {
		this.pt = pt;
	}

	public String getStkOrd() {
		return this.stkOrd;
	}

	public void setStkOrd(String stkOrd) {
		this.stkOrd = stkOrd;
	}

	public byte getTar() {
		return this.tar;
	}

	public void setTar(byte tar) {
		this.tar = tar;
	}

	public List<Artcote> getArtcotes() {
		return this.artcotes;
	}

	public void setArtcotes(List<Artcote> artcotes) {
		this.artcotes = artcotes;
	}

	public Artcote addArtcote(Artcote artcote) {
		getArtcotes().add(artcote);
		artcote.setArtphil(this);

		return artcote;
	}

	public Artcote removeArtcote(Artcote artcote) {
		getArtcotes().remove(artcote);
		artcote.setArtphil(null);

		return artcote;
	}

	public List<Artnouv> getArtnouvs() {
		return this.artnouvs;
	}

	public void setArtnouvs(List<Artnouv> artnouvs) {
		this.artnouvs = artnouvs;
	}

	public Artnouv addArtnouv(Artnouv artnouv) {
		getArtnouvs().add(artnouv);
		artnouv.setArtphil(this);

		return artnouv;
	}

	public Artnouv removeArtnouv(Artnouv artnouv) {
		getArtnouvs().remove(artnouv);
		artnouv.setArtphil(null);

		return artnouv;
	}

	public Refphil getRefphil() {
		return this.refphil;
	}

	public void setRefphil(Refphil refphil) {
		this.refphil = refphil;
	}

	public Artannee getArtannee() {
		return this.artannee;
	}

	public void setArtannee(Artannee artannee) {
		this.artannee = artannee;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Artspec> getArtspecs() {
		return this.artspecs;
	}

	public void setArtspecs(List<Artspec> artspecs) {
		this.artspecs = artspecs;
	}

	public Artspec addArtspec(Artspec artspec) {
		getArtspecs().add(artspec);
		artspec.setArtphil(this);

		return artspec;
	}

	public Artspec removeArtspec(Artspec artspec) {
		getArtspecs().remove(artspec);
		artspec.setArtphil(null);

		return artspec;
	}

}