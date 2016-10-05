package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the artspec database table.
 * 
 */
@Entity
@NamedQuery(name="Artspec.findAll", query="SELECT a FROM Artspec a")
public class Artspec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArtSpec;

	private String descrip;

	private BigDecimal prix;

	//bi-directional many-to-one association to Invent
	@ManyToOne
	@JoinColumn(name="idInvent")
	private Invent invent;

	//bi-directional many-to-one association to Artphil
	@ManyToOne
	@JoinColumn(name="idArtPhil")
	private Artphil artphil;

	public Artspec() {
	}

	public int getIdArtSpec() {
		return this.idArtSpec;
	}

	public void setIdArtSpec(int idArtSpec) {
		this.idArtSpec = idArtSpec;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Invent getInvent() {
		return this.invent;
	}

	public void setInvent(Invent invent) {
		this.invent = invent;
	}

	public Artphil getArtphil() {
		return this.artphil;
	}

	public void setArtphil(Artphil artphil) {
		this.artphil = artphil;
	}

}