package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the invent database table.
 * 
 */
@Entity
@NamedQuery(name="Invent.findAll", query="SELECT i FROM Invent i")
public class Invent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idInvent;

	private int idExter;

	private int idIds;

	private int idMarch;

	@Temporal(TemporalType.TIMESTAMP)
	private Date majQuan;

	private byte net;

	private byte pub;

	private byte pxc;

	private int quanCom;

	private int quanMax;

	private int quanNet;

	private int quanPub;

	private int quanPxc;

	private int quanRec;

	private int quanRup;

	private int quantite;

	//bi-directional many-to-one association to Artspec
	@OneToMany(mappedBy="invent")
	private List<Artspec> artspecs;

	//bi-directional many-to-one association to Detcomfourn
	@OneToMany(mappedBy="invent")
	private List<Detcomfourn> detcomfourns;

	//bi-directional many-to-one association to Histquantite
	@OneToMany(mappedBy="invent")
	private List<Histquantite> histquantites;

	public Invent() {
	}

	public int getIdInvent() {
		return this.idInvent;
	}

	public void setIdInvent(int idInvent) {
		this.idInvent = idInvent;
	}

	public int getIdExter() {
		return this.idExter;
	}

	public void setIdExter(int idExter) {
		this.idExter = idExter;
	}

	public int getIdIds() {
		return this.idIds;
	}

	public void setIdIds(int idIds) {
		this.idIds = idIds;
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

	public byte getNet() {
		return this.net;
	}

	public void setNet(byte net) {
		this.net = net;
	}

	public byte getPub() {
		return this.pub;
	}

	public void setPub(byte pub) {
		this.pub = pub;
	}

	public byte getPxc() {
		return this.pxc;
	}

	public void setPxc(byte pxc) {
		this.pxc = pxc;
	}

	public int getQuanCom() {
		return this.quanCom;
	}

	public void setQuanCom(int quanCom) {
		this.quanCom = quanCom;
	}

	public int getQuanMax() {
		return this.quanMax;
	}

	public void setQuanMax(int quanMax) {
		this.quanMax = quanMax;
	}

	public int getQuanNet() {
		return this.quanNet;
	}

	public void setQuanNet(int quanNet) {
		this.quanNet = quanNet;
	}

	public int getQuanPub() {
		return this.quanPub;
	}

	public void setQuanPub(int quanPub) {
		this.quanPub = quanPub;
	}

	public int getQuanPxc() {
		return this.quanPxc;
	}

	public void setQuanPxc(int quanPxc) {
		this.quanPxc = quanPxc;
	}

	public int getQuanRec() {
		return this.quanRec;
	}

	public void setQuanRec(int quanRec) {
		this.quanRec = quanRec;
	}

	public int getQuanRup() {
		return this.quanRup;
	}

	public void setQuanRup(int quanRup) {
		this.quanRup = quanRup;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public List<Artspec> getArtspecs() {
		return this.artspecs;
	}

	public void setArtspecs(List<Artspec> artspecs) {
		this.artspecs = artspecs;
	}

	public Artspec addArtspec(Artspec artspec) {
		getArtspecs().add(artspec);
		artspec.setInvent(this);

		return artspec;
	}

	public Artspec removeArtspec(Artspec artspec) {
		getArtspecs().remove(artspec);
		artspec.setInvent(null);

		return artspec;
	}

	public List<Detcomfourn> getDetcomfourns() {
		return this.detcomfourns;
	}

	public void setDetcomfourns(List<Detcomfourn> detcomfourns) {
		this.detcomfourns = detcomfourns;
	}

	public Detcomfourn addDetcomfourn(Detcomfourn detcomfourn) {
		getDetcomfourns().add(detcomfourn);
		detcomfourn.setInvent(this);

		return detcomfourn;
	}

	public Detcomfourn removeDetcomfourn(Detcomfourn detcomfourn) {
		getDetcomfourns().remove(detcomfourn);
		detcomfourn.setInvent(null);

		return detcomfourn;
	}

	public List<Histquantite> getHistquantites() {
		return this.histquantites;
	}

	public void setHistquantites(List<Histquantite> histquantites) {
		this.histquantites = histquantites;
	}

	public Histquantite addHistquantite(Histquantite histquantite) {
		getHistquantites().add(histquantite);
		histquantite.setInvent(this);

		return histquantite;
	}

	public Histquantite removeHistquantite(Histquantite histquantite) {
		getHistquantites().remove(histquantite);
		histquantite.setInvent(null);

		return histquantite;
	}

}