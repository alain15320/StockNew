package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the refcotes database table.
 * 
 */
@Entity
@Table(name="refcotes")
@NamedQuery(name="Refcote.findAll", query="SELECT r FROM Refcote r")
public class Refcote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRefCotes;

	private BigDecimal majSc;

	private String numero;

	private BigDecimal nv;

	private String stkOrd;

	//bi-directional many-to-one association to Artcote
	@OneToMany(mappedBy="refcote")
	private List<Artcote> artcotes;

	//bi-directional many-to-one association to Catalogue
	@ManyToOne
	@JoinColumn(name="idCatalogue")
	private Catalogue catalogue;

	//bi-directional many-to-one association to Refphil
	@ManyToOne
	@JoinColumn(name="idRefPhil")
	private Refphil refphil;

	public Refcote() {
	}

	public int getIdRefCotes() {
		return this.idRefCotes;
	}

	public void setIdRefCotes(int idRefCotes) {
		this.idRefCotes = idRefCotes;
	}

	public BigDecimal getMajSc() {
		return this.majSc;
	}

	public void setMajSc(BigDecimal majSc) {
		this.majSc = majSc;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getNv() {
		return this.nv;
	}

	public void setNv(BigDecimal nv) {
		this.nv = nv;
	}

	public String getStkOrd() {
		return this.stkOrd;
	}

	public void setStkOrd(String stkOrd) {
		this.stkOrd = stkOrd;
	}

	public List<Artcote> getArtcotes() {
		return this.artcotes;
	}

	public void setArtcotes(List<Artcote> artcotes) {
		this.artcotes = artcotes;
	}

	public Artcote addArtcote(Artcote artcote) {
		getArtcotes().add(artcote);
		artcote.setRefcote(this);

		return artcote;
	}

	public Artcote removeArtcote(Artcote artcote) {
		getArtcotes().remove(artcote);
		artcote.setRefcote(null);

		return artcote;
	}

	public Catalogue getCatalogue() {
		return this.catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public Refphil getRefphil() {
		return this.refphil;
	}

	public void setRefphil(Refphil refphil) {
		this.refphil = refphil;
	}

}