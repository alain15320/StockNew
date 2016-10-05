package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the refdec database table.
 * 
 */
@Entity
@NamedQuery(name="Refdec.findAll", query="SELECT r FROM Refdec r")
public class Refdec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRefDec;

	private String annee;

	private String decOrd;

	private int idMarch;

	private String idPhoto;

	private String nomImage;

	private String numero;

	private BigDecimal nv;

	//bi-directional many-to-one association to Artdec
	@OneToMany(mappedBy="refdec")
	private List<Artdec> artdecs;

	//bi-directional many-to-one association to Refannee
	@OneToMany(mappedBy="refdec")
	private List<Refannee> refannees;

	//bi-directional many-to-one association to Refrub
	@ManyToOne
	@JoinColumn(name="idRefRub")
	private Refrub refrub;

	public Refdec() {
	}

	public int getIdRefDec() {
		return this.idRefDec;
	}

	public void setIdRefDec(int idRefDec) {
		this.idRefDec = idRefDec;
	}

	public String getAnnee() {
		return this.annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getDecOrd() {
		return this.decOrd;
	}

	public void setDecOrd(String decOrd) {
		this.decOrd = decOrd;
	}

	public int getIdMarch() {
		return this.idMarch;
	}

	public void setIdMarch(int idMarch) {
		this.idMarch = idMarch;
	}

	public String getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getNomImage() {
		return this.nomImage;
	}

	public void setNomImage(String nomImage) {
		this.nomImage = nomImage;
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

	public List<Artdec> getArtdecs() {
		return this.artdecs;
	}

	public void setArtdecs(List<Artdec> artdecs) {
		this.artdecs = artdecs;
	}

	public Artdec addArtdec(Artdec artdec) {
		getArtdecs().add(artdec);
		artdec.setRefdec(this);

		return artdec;
	}

	public Artdec removeArtdec(Artdec artdec) {
		getArtdecs().remove(artdec);
		artdec.setRefdec(null);

		return artdec;
	}

	public List<Refannee> getRefannees() {
		return this.refannees;
	}

	public void setRefannees(List<Refannee> refannees) {
		this.refannees = refannees;
	}

	public Refannee addRefannee(Refannee refannee) {
		getRefannees().add(refannee);
		refannee.setRefdec(this);

		return refannee;
	}

	public Refannee removeRefannee(Refannee refannee) {
		getRefannees().remove(refannee);
		refannee.setRefdec(null);

		return refannee;
	}

	public Refrub getRefrub() {
		return this.refrub;
	}

	public void setRefrub(Refrub refrub) {
		this.refrub = refrub;
	}

}