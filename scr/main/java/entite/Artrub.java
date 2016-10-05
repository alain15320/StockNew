package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the artrub database table.
 * 
 */
@Entity
@NamedQuery(name="Artrub.findAll", query="SELECT a FROM Artrub a")
public class Artrub implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArtRub;

	private String etat;

	private String form;

	private int idInvent;

	private int idMarch;

	private String idPhoto;

	@Temporal(TemporalType.TIMESTAMP)
	private Date majQuan;

	private BigDecimal pria;

	private BigDecimal prix;

	private String rubOrd;

	private byte tar;

	private BigDecimal vf;

	//bi-directional many-to-one association to Artdec
	@OneToMany(mappedBy="artrub")
	private List<Artdec> artdecs;

	//bi-directional many-to-one association to Refrub
	@ManyToOne
	@JoinColumn(name="idRefRub")
	private Refrub refrub;

	//bi-directional many-to-one association to Artpay
	@ManyToOne
	@JoinColumn(name="IdArtPays")
	private Artpay artpay;

	//bi-directional many-to-one association to Page
	@ManyToOne
	@JoinColumn(name="idPage")
	private Page page;

	public Artrub() {
	}

	public int getIdArtRub() {
		return this.idArtRub;
	}

	public void setIdArtRub(int idArtRub) {
		this.idArtRub = idArtRub;
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

	public String getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public Date getMajQuan() {
		return this.majQuan;
	}

	public void setMajQuan(Date majQuan) {
		this.majQuan = majQuan;
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

	public String getRubOrd() {
		return this.rubOrd;
	}

	public void setRubOrd(String rubOrd) {
		this.rubOrd = rubOrd;
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

	public List<Artdec> getArtdecs() {
		return this.artdecs;
	}

	public void setArtdecs(List<Artdec> artdecs) {
		this.artdecs = artdecs;
	}

	public Artdec addArtdec(Artdec artdec) {
		getArtdecs().add(artdec);
		artdec.setArtrub(this);

		return artdec;
	}

	public Artdec removeArtdec(Artdec artdec) {
		getArtdecs().remove(artdec);
		artdec.setArtrub(null);

		return artdec;
	}

	public Refrub getRefrub() {
		return this.refrub;
	}

	public void setRefrub(Refrub refrub) {
		this.refrub = refrub;
	}

	public Artpay getArtpay() {
		return this.artpay;
	}

	public void setArtpay(Artpay artpay) {
		this.artpay = artpay;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}