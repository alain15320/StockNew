package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detcomfourn database table.
 * 
 */
@Entity
@NamedQuery(name="Detcomfourn.findAll", query="SELECT d FROM Detcomfourn d")
public class Detcomfourn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDetComFourn;

	private String etat;

	private String form;

	private int idComEtat;

	private int idEstim;

	private BigDecimal pria;

	private int quantite;

	private int stkId;

	//bi-directional many-to-one association to Invent
	@ManyToOne
	@JoinColumn(name="idInvent")
	private Invent invent;

	//bi-directional many-to-one association to Comfourn
	@ManyToOne
	@JoinColumn(name="idComFourn")
	private Comfourn comfourn;

	public Detcomfourn() {
	}

	public int getIdDetComFourn() {
		return this.idDetComFourn;
	}

	public void setIdDetComFourn(int idDetComFourn) {
		this.idDetComFourn = idDetComFourn;
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

	public int getIdComEtat() {
		return this.idComEtat;
	}

	public void setIdComEtat(int idComEtat) {
		this.idComEtat = idComEtat;
	}

	public int getIdEstim() {
		return this.idEstim;
	}

	public void setIdEstim(int idEstim) {
		this.idEstim = idEstim;
	}

	public BigDecimal getPria() {
		return this.pria;
	}

	public void setPria(BigDecimal pria) {
		this.pria = pria;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
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

	public Comfourn getComfourn() {
		return this.comfourn;
	}

	public void setComfourn(Comfourn comfourn) {
		this.comfourn = comfourn;
	}

}