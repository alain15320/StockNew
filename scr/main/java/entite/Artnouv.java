package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the artnouv database table.
 * 
 */
@Entity
@NamedQuery(name="Artnouv.findAll", query="SELECT a FROM Artnouv a")
public class Artnouv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idArtNouv;

	private String condit;

	@Temporal(TemporalType.DATE)
	private Date dateAn;

	private String descrip;

	private int idInvent;

	private int idMarch;

	private byte insCat;

	@Temporal(TemporalType.DATE)
	private Date majQuan;

	private String nouvOrd;

	private String numero;

	private BigDecimal nv;

	private BigDecimal txChange;

	private BigDecimal vf;

	//bi-directional many-to-one association to Artphil
	@ManyToOne
	@JoinColumn(name="IdArtPhil")
	private Artphil artphil;

	public Artnouv() {
	}

	public int getIdArtNouv() {
		return this.idArtNouv;
	}

	public void setIdArtNouv(int idArtNouv) {
		this.idArtNouv = idArtNouv;
	}

	public String getCondit() {
		return this.condit;
	}

	public void setCondit(String condit) {
		this.condit = condit;
	}

	public Date getDateAn() {
		return this.dateAn;
	}

	public void setDateAn(Date dateAn) {
		this.dateAn = dateAn;
	}

	public String getDescrip() {
		return this.descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
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

	public byte getInsCat() {
		return this.insCat;
	}

	public void setInsCat(byte insCat) {
		this.insCat = insCat;
	}

	public Date getMajQuan() {
		return this.majQuan;
	}

	public void setMajQuan(Date majQuan) {
		this.majQuan = majQuan;
	}

	public String getNouvOrd() {
		return this.nouvOrd;
	}

	public void setNouvOrd(String nouvOrd) {
		this.nouvOrd = nouvOrd;
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

	public BigDecimal getTxChange() {
		return this.txChange;
	}

	public void setTxChange(BigDecimal txChange) {
		this.txChange = txChange;
	}

	public BigDecimal getVf() {
		return this.vf;
	}

	public void setVf(BigDecimal vf) {
		this.vf = vf;
	}

	public Artphil getArtphil() {
		return this.artphil;
	}

	public void setArtphil(Artphil artphil) {
		this.artphil = artphil;
	}

}