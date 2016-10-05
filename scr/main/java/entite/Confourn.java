package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the confourn database table.
 * 
 */
@Entity
@NamedQuery(name="Confourn.findAll", query="SELECT c FROM Confourn c")
public class Confourn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idConFourn;

	private String nom;

	//bi-directional many-to-one association to Comfourn
	@OneToMany(mappedBy="confourn")
	private List<Comfourn> comfourns;

	public Confourn() {
	}

	public int getIdConFourn() {
		return this.idConFourn;
	}

	public void setIdConFourn(int idConFourn) {
		this.idConFourn = idConFourn;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Comfourn> getComfourns() {
		return this.comfourns;
	}

	public void setComfourns(List<Comfourn> comfourns) {
		this.comfourns = comfourns;
	}

	public Comfourn addComfourn(Comfourn comfourn) {
		getComfourns().add(comfourn);
		comfourn.setConfourn(this);

		return comfourn;
	}

	public Comfourn removeComfourn(Comfourn comfourn) {
		getComfourns().remove(comfourn);
		comfourn.setConfourn(null);

		return comfourn;
	}

}