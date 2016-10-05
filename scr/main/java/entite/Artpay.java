package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the artpays database table.
 * 
 */
@Entity
@Table(name="artpays")
@NamedQuery(name="Artpay.findAll", query="SELECT a FROM Artpay a")
public class Artpay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArtPays;

	private String etat;

	private String form;

	private int idInvent;

	private int idMarch;

	@Temporal(TemporalType.TIMESTAMP)
	private Date majQuan;

	private String nomImage;

	private String paysOrd;

	private BigDecimal pria;

	private BigDecimal prix;

	private byte tar;

	private BigDecimal vf;

	//bi-directional many-to-one association to Refpay
	@ManyToOne
	@JoinColumn(name="idPays")
	private Refpay refpay;

	//bi-directional many-to-one association to Page
	@ManyToOne
	@JoinColumn(name="idPage")
	private Page page;

	//bi-directional many-to-one association to Artrub
	@OneToMany(mappedBy="artpay")
	private List<Artrub> artrubs;

	public Artpay() {
	}

	public int getIdArtPays() {
		return this.idArtPays;
	}

	public void setIdArtPays(int idArtPays) {
		this.idArtPays = idArtPays;
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

	public String getNomImage() {
		return this.nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
	}

	public String getPaysOrd() {
		return this.paysOrd;
	}

	public void setPaysOrd(String paysOrd) {
		this.paysOrd = paysOrd;
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

	public Refpay getRefpay() {
		return this.refpay;
	}

	public void setRefpay(Refpay refpay) {
		this.refpay = refpay;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Artrub> getArtrubs() {
		return this.artrubs;
	}

	public void setArtrubs(List<Artrub> artrubs) {
		this.artrubs = artrubs;
	}

	public Artrub addArtrub(Artrub artrub) {
		getArtrubs().add(artrub);
		artrub.setArtpay(this);

		return artrub;
	}

	public Artrub removeArtrub(Artrub artrub) {
		getArtrubs().remove(artrub);
		artrub.setArtpay(null);

		return artrub;
	}

}