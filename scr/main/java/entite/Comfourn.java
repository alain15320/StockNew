package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comfourn database table.
 * 
 */
@Entity
@NamedQuery(name="Comfourn.findAll", query="SELECT c FROM Comfourn c")
public class Comfourn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idComFourn;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String descrip;

	//bi-directional many-to-one association to Cometat
	@ManyToOne
	@JoinColumn(name="idComEtat")
	private Cometat cometat;

	//bi-directional many-to-one association to Confourn
	@ManyToOne
	@JoinColumn(name="idConFourn")
	private Confourn confourn;

	//bi-directional many-to-one association to Detcomfourn
	@OneToMany(mappedBy="comfourn")
	private List<Detcomfourn> detcomfourns;

	public Comfourn() {
	}

	public int getIdComFourn() {
		return this.idComFourn;
	}

	public void setIdComFourn(int idComFourn) {
		this.idComFourn = idComFourn;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Cometat getCometat() {
		return this.cometat;
	}

	public void setCometat(Cometat cometat) {
		this.cometat = cometat;
	}

	public Confourn getConfourn() {
		return this.confourn;
	}

	public void setConfourn(Confourn confourn) {
		this.confourn = confourn;
	}

	public List<Detcomfourn> getDetcomfourns() {
		return this.detcomfourns;
	}

	public void setDetcomfourns(List<Detcomfourn> detcomfourns) {
		this.detcomfourns = detcomfourns;
	}

	public Detcomfourn addDetcomfourn(Detcomfourn detcomfourn) {
		getDetcomfourns().add(detcomfourn);
		detcomfourn.setComfourn(this);

		return detcomfourn;
	}

	public Detcomfourn removeDetcomfourn(Detcomfourn detcomfourn) {
		getDetcomfourns().remove(detcomfourn);
		detcomfourn.setComfourn(null);

		return detcomfourn;
	}

}