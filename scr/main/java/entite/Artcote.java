package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the artcotes database table.
 * 
 */
@Entity
@Table(name="artcotes")
@NamedQuery(name="Artcote.findAll", query="SELECT a FROM Artcote a")
public class Artcote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArtCotes;

	private String cat;

	private BigDecimal cote;

	private BigDecimal coTh;

	private int idRefPhil;

	private BigDecimal rem;

	private String stkOrd;

	//bi-directional many-to-one association to Artphil
	@ManyToOne
	@JoinColumn(name="idArtPhil")
	private Artphil artphil;

	//bi-directional many-to-one association to Refcote
	@ManyToOne
	@JoinColumn(name="idRefCotes")
	private Refcote refcote;

	public Artcote() {
	}

	public int getIdArtCotes() {
		return this.idArtCotes;
	}

	public void setIdArtCotes(int idArtCotes) {
		this.idArtCotes = idArtCotes;
	}

	public String getCat() {
		return this.cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public BigDecimal getCote() {
		return this.cote;
	}

	public void setCote(BigDecimal cote) {
		this.cote = cote;
	}

	public BigDecimal getCoTh() {
		return this.coTh;
	}

	public void setCoTh(BigDecimal coTh) {
		this.coTh = coTh;
	}

	public int getIdRefPhil() {
		return this.idRefPhil;
	}

	public void setIdRefPhil(int idRefPhil) {
		this.idRefPhil = idRefPhil;
	}

	public BigDecimal getRem() {
		return this.rem;
	}

	public void setRem(BigDecimal rem) {
		this.rem = rem;
	}

	public String getStkOrd() {
		return this.stkOrd;
	}

	public void setStkOrd(String stkOrd) {
		this.stkOrd = stkOrd;
	}

	public Artphil getArtphil() {
		return this.artphil;
	}

	public void setArtphil(Artphil artphil) {
		this.artphil = artphil;
	}

	public Refcote getRefcote() {
		return this.refcote;
	}

	public void setRefcote(Refcote refcote) {
		this.refcote = refcote;
	}

}