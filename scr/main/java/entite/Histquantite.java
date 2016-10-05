package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the histquantite database table.
 * 
 */
@Entity
@NamedQuery(name="Histquantite.findAll", query="SELECT h FROM Histquantite h")
public class Histquantite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idHistQuan;

	private String etat;

	private String form;

	private int histId;

	private String histQuanId;

	private int idArtPhil;

	@Temporal(TemporalType.DATE)
	private Date majQuan;

	private BigDecimal prix;

	private BigDecimal quantite;

	private int stkId;

	//bi-directional many-to-one association to Invent
	@ManyToOne
	@JoinColumn(name="IdInvent")
	private Invent invent;

	public Histquantite() {
	}

	public int getIdHistQuan() {
		return this.idHistQuan;
	}

	public void setIdHistQuan(int idHistQuan) {
		this.idHistQuan = idHistQuan;
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

	public int getHistId() {
		return this.histId;
	}

	public void setHistId(int histId) {
		this.histId = histId;
	}

	public String getHistQuanId() {
		return this.histQuanId;
	}

	public void setHistQuanId(String histQuanId) {
		this.histQuanId = histQuanId;
	}

	public int getIdArtPhil() {
		return this.idArtPhil;
	}

	public void setIdArtPhil(int idArtPhil) {
		this.idArtPhil = idArtPhil;
	}

	public Date getMajQuan() {
		return this.majQuan;
	}

	public void setMajQuan(Date majQuan) {
		this.majQuan = majQuan;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public int getStkId() {
		return this.stkId;
	}

	public void setStkId(int stkId) {
		this.stkId = stkId;
	}

	public Invent getInvent() {
		return this.invent;
	}

	public void setInvent(Invent invent) {
		this.invent = invent;
	}

}