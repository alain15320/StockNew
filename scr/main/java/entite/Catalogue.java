package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogue database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogue.findAll", query="SELECT c FROM Catalogue c")
public class Catalogue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCatalogue;

	private String nom;

	//bi-directional many-to-one association to Refcote
	@OneToMany(mappedBy="catalogue")
	private List<Refcote> refcotes;

	public Catalogue() {
	}

	public int getIdCatalogue() {
		return this.idCatalogue;
	}

	public void setIdCatalogue(int idCatalogue) {
		this.idCatalogue = idCatalogue;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Refcote> getRefcotes() {
		return this.refcotes;
	}

	public void setRefcotes(List<Refcote> refcotes) {
		this.refcotes = refcotes;
	}

	public Refcote addRefcote(Refcote refcote) {
		getRefcotes().add(refcote);
		refcote.setCatalogue(this);

		return refcote;
	}

	public Refcote removeRefcote(Refcote refcote) {
		getRefcotes().remove(refcote);
		refcote.setCatalogue(null);

		return refcote;
	}

}