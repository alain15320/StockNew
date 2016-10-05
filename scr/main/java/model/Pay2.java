package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pays database table.
 * 
 */
@Entity
@Table(name="pays")
@NamedQuery(name="Pay.findAll", query="SELECT p FROM Pay p")
public class Pay2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPays;

	private String capitale;

	private String descrip;

	private String nomPays;

	//bi-directional one-to-one association to Refpay
	@OneToOne(mappedBy="pay")
	private Refpay2 refpay;

	public Pay2() {
	}

	public int getIdPays() {
		return this.idPays;
	}

	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	public String getCapitale() {
		return this.capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getNomPays() {
		return this.nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	public Refpay2 getRefpay() {
		return this.refpay;
	}

	public void setRefpay(Refpay2 refpay) {
		this.refpay = refpay;
	}

}