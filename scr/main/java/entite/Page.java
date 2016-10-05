package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pages database table.
 * 
 */
@Entity
@Table(name="pages")
@NamedQuery(name="Page.findAll", query="SELECT p FROM Page p")
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtImp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dtMaj;

	private byte maj;

	//bi-directional many-to-one association to Artannee
	@OneToMany(mappedBy="page")
	private List<Artannee> artannees;

	//bi-directional many-to-one association to Artdec
	@OneToMany(mappedBy="page")
	private List<Artdec> artdecs;

	//bi-directional many-to-one association to Artpay
	@OneToMany(mappedBy="page")
	private List<Artpay> artpays;

	//bi-directional many-to-one association to Artphil
	@OneToMany(mappedBy="page")
	private List<Artphil> artphils;

	//bi-directional many-to-one association to Artrub
	@OneToMany(mappedBy="page")
	private List<Artrub> artrubs;

	public Page() {
	}

	public int getIdPage() {
		return this.idPage;
	}

	public void setIdPage(int idPage) {
		this.idPage = idPage;
	}

	public Date getDtImp() {
		return this.dtImp;
	}

	public void setDtImp(Date dtImp) {
		this.dtImp = dtImp;
	}

	public Date getDtMaj() {
		return this.dtMaj;
	}

	public void setDtMaj(Date dtMaj) {
		this.dtMaj = dtMaj;
	}

	public byte getMaj() {
		return this.maj;
	}

	public void setMaj(byte maj) {
		this.maj = maj;
	}

	public List<Artannee> getArtannees() {
		return this.artannees;
	}

	public void setArtannees(List<Artannee> artannees) {
		this.artannees = artannees;
	}

	public Artannee addArtannee(Artannee artannee) {
		getArtannees().add(artannee);
		artannee.setPage(this);

		return artannee;
	}

	public Artannee removeArtannee(Artannee artannee) {
		getArtannees().remove(artannee);
		artannee.setPage(null);

		return artannee;
	}

	public List<Artdec> getArtdecs() {
		return this.artdecs;
	}

	public void setArtdecs(List<Artdec> artdecs) {
		this.artdecs = artdecs;
	}

	public Artdec addArtdec(Artdec artdec) {
		getArtdecs().add(artdec);
		artdec.setPage(this);

		return artdec;
	}

	public Artdec removeArtdec(Artdec artdec) {
		getArtdecs().remove(artdec);
		artdec.setPage(null);

		return artdec;
	}

	public List<Artpay> getArtpays() {
		return this.artpays;
	}

	public void setArtpays(List<Artpay> artpays) {
		this.artpays = artpays;
	}

	public Artpay addArtpay(Artpay artpay) {
		getArtpays().add(artpay);
		artpay.setPage(this);

		return artpay;
	}

	public Artpay removeArtpay(Artpay artpay) {
		getArtpays().remove(artpay);
		artpay.setPage(null);

		return artpay;
	}

	public List<Artphil> getArtphils() {
		return this.artphils;
	}

	public void setArtphils(List<Artphil> artphils) {
		this.artphils = artphils;
	}

	public Artphil addArtphil(Artphil artphil) {
		getArtphils().add(artphil);
		artphil.setPage(this);

		return artphil;
	}

	public Artphil removeArtphil(Artphil artphil) {
		getArtphils().remove(artphil);
		artphil.setPage(null);

		return artphil;
	}

	public List<Artrub> getArtrubs() {
		return this.artrubs;
	}

	public void setArtrubs(List<Artrub> artrubs) {
		this.artrubs = artrubs;
	}

	public Artrub addArtrub(Artrub artrub) {
		getArtrubs().add(artrub);
		artrub.setPage(this);

		return artrub;
	}

	public Artrub removeArtrub(Artrub artrub) {
		getArtrubs().remove(artrub);
		artrub.setPage(null);

		return artrub;
	}

}