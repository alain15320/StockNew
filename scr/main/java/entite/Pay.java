package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pays database table.
 * 
 */
@Entity
@Table(name="pays")
@NamedQueries({
	@NamedQuery(name="Pay.findAll", query="SELECT p FROM Pay p"),
	@NamedQuery(name="Pay.findByIdPays", query="SELECT p FROM Pay p WHERE p.idPays LIKE :recherche")
})
public class Pay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pays;

	private String capitale;

	private String couleur;

	private String descrip;

	private int idPays;

	private String nomPays;

	private boolean nouv;

	private BigDecimal txChange;

	//bi-directional one-to-one association to Refpay
	@OneToOne(mappedBy="pay")
	private Refpay refpay;

	public Pay() {
	}
	
	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getCapitale() {
		return this.capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public int getIdPays() {
		return this.idPays;
	}

	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	public String getNomPays() {
		return this.nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public boolean isNouv() {
		return nouv;
	}

	public void setNouv(boolean nouv) {
		this.nouv = nouv;
	}

	public BigDecimal getTxChange() {
		return this.txChange;
	}

	public void setTxChange(BigDecimal txChange) {
		this.txChange = txChange;
	}

	public Refpay getRefpay() {
		return this.refpay;
	}

	public void setRefpay(Refpay refpay) {
		this.refpay = refpay;
	}

	@Override
	public String toString() {
		return "Pay [pays=" + pays + ", idPays=" + idPays + ", nomPays=" + nomPays + "]";
	}
	
	

}