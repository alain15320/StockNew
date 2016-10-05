package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the refrub database table.
 * 
 */
@Entity
@NamedQuery(name="Refrub.findAll", query="SELECT r FROM Refrub r")
public class Refrub implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRefRub;

	private int idMarch;

	private BigDecimal nv;

	private String pays;

	private String rub;

	private String rubOrd;

	private BigDecimal vf;

	//bi-directional many-to-one association to Artrub
	@OneToMany(mappedBy="refrub")
	private List<Artrub> artrubs;

	//bi-directional many-to-one association to Refdec
	@OneToMany(mappedBy="refrub")
	private List<Refdec> refdecs;

	//bi-directional many-to-one association to Refpay
	@ManyToOne
	@JoinColumn(name="idPays")
	private Refpay refpay;

	//bi-directional many-to-one association to Rub
	@ManyToOne
	@JoinColumn(name="idRub")
	private Rub rubBean;

	public Refrub() {
	}

	public int getIdRefRub() {
		return this.idRefRub;
	}

	public void setIdRefRub(int idRefRub) {
		this.idRefRub = idRefRub;
	}

	public int getIdMarch() {
		return this.idMarch;
	}

	public void setIdMarch(int idMarch) {
		this.idMarch = idMarch;
	}

	public BigDecimal getNv() {
		return this.nv;
	}

	public void setNv(BigDecimal nv) {
		this.nv = nv;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getRub() {
		return this.rub;
	}

	public void setRub(String rub) {
		this.rub = rub;
	}

	public String getRubOrd() {
		return this.rubOrd;
	}

	public void setRubOrd(String rubOrd) {
		this.rubOrd = rubOrd;
	}

	public BigDecimal getVf() {
		return this.vf;
	}

	public void setVf(BigDecimal vf) {
		this.vf = vf;
	}

	public List<Artrub> getArtrubs() {
		return this.artrubs;
	}

	public void setArtrubs(List<Artrub> artrubs) {
		this.artrubs = artrubs;
	}

	public Artrub addArtrub(Artrub artrub) {
		getArtrubs().add(artrub);
		artrub.setRefrub(this);

		return artrub;
	}

	public Artrub removeArtrub(Artrub artrub) {
		getArtrubs().remove(artrub);
		artrub.setRefrub(null);

		return artrub;
	}

	public List<Refdec> getRefdecs() {
		return this.refdecs;
	}

	public void setRefdecs(List<Refdec> refdecs) {
		this.refdecs = refdecs;
	}

	public Refdec addRefdec(Refdec refdec) {
		getRefdecs().add(refdec);
		refdec.setRefrub(this);

		return refdec;
	}

	public Refdec removeRefdec(Refdec refdec) {
		getRefdecs().remove(refdec);
		refdec.setRefrub(null);

		return refdec;
	}

	public Refpay getRefpay() {
		return this.refpay;
	}

	public void setRefpay(Refpay refpay) {
		this.refpay = refpay;
	}

	public Rub getRubBean() {
		return this.rubBean;
	}

	public void setRubBean(Rub rubBean) {
		this.rubBean = rubBean;
	}

}