package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the groupe database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Groupe.findAll", query="SELECT g FROM Groupe g"),
	@NamedQuery(name="Groupe.findByIdGrp", query="SELECT g FROM Groupe g WHERE g.idGrp LIKE :recherche")
})
public class Groupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGrp;

	private String nomGroupe;

	//bi-directional many-to-one association to Refpay
	@OneToMany(mappedBy="groupe")
	private List<Refpay> refpays;

	public Groupe() {
	}

	public int getIdGrp() {
		return this.idGrp;
	}

	public void setIdGrp(int idGrp) {
		this.idGrp = idGrp;
	}

	public String getNomGroupe() {
		return this.nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public List<Refpay> getRefpays() {
		return this.refpays;
	}

	public void setRefpays(List<Refpay> refpays) {
		this.refpays = refpays;
	}

	public Refpay addRefpay(Refpay refpay) {
		getRefpays().add(refpay);
		refpay.setGroupe(this);

		return refpay;
	}

	public Refpay removeRefpay(Refpay refpay) {
		getRefpays().remove(refpay);
		refpay.setGroupe(null);

		return refpay;
	}

	@Override
	public String toString() {
		return "Groupe [idGrp=" + idGrp + ", nomGroupe=" + nomGroupe + "]";
	}
	
	

}