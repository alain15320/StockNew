package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cometat database table.
 * 
 */
@Entity
@NamedQuery(name="Cometat.findAll", query="SELECT c FROM Cometat c")
public class Cometat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idComEtat;

	private String descrip;

	//bi-directional many-to-one association to Comfourn
	@OneToMany(mappedBy="cometat")
	private List<Comfourn> comfourns;

	public Cometat() {
	}

	public int getIdComEtat() {
		return this.idComEtat;
	}

	public void setIdComEtat(int idComEtat) {
		this.idComEtat = idComEtat;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public List<Comfourn> getComfourns() {
		return this.comfourns;
	}

	public void setComfourns(List<Comfourn> comfourns) {
		this.comfourns = comfourns;
	}

	public Comfourn addComfourn(Comfourn comfourn) {
		getComfourns().add(comfourn);
		comfourn.setCometat(this);

		return comfourn;
	}

	public Comfourn removeComfourn(Comfourn comfourn) {
		getComfourns().remove(comfourn);
		comfourn.setCometat(null);

		return comfourn;
	}

}