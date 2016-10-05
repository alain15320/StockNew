package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the photos database table.
 * 
 */
@Entity
@Table(name="photos")
@NamedQuery(name="Photo.findAll", query="SELECT p FROM Photo p")
public class Photo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPhoto;

	private int defJpg;

	private int defTif;

	private BigDecimal dimLarg;

	private BigDecimal dimLaut;

	private int idArtNouv;

	private int idInvent;

	private int idMarch;

	private int idRefPhil;

	private String idSite;

	private String nom;

	private byte nomFix;

	@Temporal(TemporalType.DATE)
	private Date photoDate;

	private int photoHaut;

	private int photoLarg;

	private BigDecimal photoSize;

	private BigDecimal photoSizeNet;

	private String rep;

	public Photo() {
	}

	public int getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}

	public int getDefJpg() {
		return this.defJpg;
	}

	public void setDefJpg(int defJpg) {
		this.defJpg = defJpg;
	}

	public int getDefTif() {
		return this.defTif;
	}

	public void setDefTif(int defTif) {
		this.defTif = defTif;
	}

	public BigDecimal getDimLarg() {
		return this.dimLarg;
	}

	public void setDimLarg(BigDecimal dimLarg) {
		this.dimLarg = dimLarg;
	}

	public BigDecimal getDimLaut() {
		return this.dimLaut;
	}

	public void setDimLaut(BigDecimal dimLaut) {
		this.dimLaut = dimLaut;
	}

	public int getIdArtNouv() {
		return this.idArtNouv;
	}

	public void setIdArtNouv(int idArtNouv) {
		this.idArtNouv = idArtNouv;
	}

	public int getIdInvent() {
		return this.idInvent;
	}

	public void setIdInvent(int idInvent) {
		this.idInvent = idInvent;
	}

	public int getIdMarch() {
		return this.idMarch;
	}

	public void setIdMarch(int idMarch) {
		this.idMarch = idMarch;
	}

	public int getIdRefPhil() {
		return this.idRefPhil;
	}

	public void setIdRefPhil(int idRefPhil) {
		this.idRefPhil = idRefPhil;
	}

	public String getIdSite() {
		return this.idSite;
	}

	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public byte getNomFix() {
		return this.nomFix;
	}

	public void setNomFix(byte nomFix) {
		this.nomFix = nomFix;
	}

	public Date getPhotoDate() {
		return this.photoDate;
	}

	public void setPhotoDate(Date photoDate) {
		this.photoDate = photoDate;
	}

	public int getPhotoHaut() {
		return this.photoHaut;
	}

	public void setPhotoHaut(int photoHaut) {
		this.photoHaut = photoHaut;
	}

	public int getPhotoLarg() {
		return this.photoLarg;
	}

	public void setPhotoLarg(int photoLarg) {
		this.photoLarg = photoLarg;
	}

	public BigDecimal getPhotoSize() {
		return this.photoSize;
	}

	public void setPhotoSize(BigDecimal photoSize) {
		this.photoSize = photoSize;
	}

	public BigDecimal getPhotoSizeNet() {
		return this.photoSizeNet;
	}

	public void setPhotoSizeNet(BigDecimal photoSizeNet) {
		this.photoSizeNet = photoSizeNet;
	}

	public String getRep() {
		return this.rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

}