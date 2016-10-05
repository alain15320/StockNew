package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rub database table.
 * 
 */
@Entity
@NamedQuery(name="Rub.findAll", query="SELECT r FROM Rub r")
public class Rub implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String rub;

	private int idRub;

	private String nomRub;

	private String rubOrd;

	//bi-directional many-to-one association to Refrub
	@OneToMany(mappedBy="rubBean")
	private List<Refrub> refrubs;

	public Rub() {
	}

	public String getRub() {
		return this.rub;
	}

	public void setRub(String rub) {
		this.rub = rub;
	}

	public int getIdRub() {
		return this.idRub;
	}

	public void setIdRub(int idRub) {
		this.idRub = idRub;
	}

	public String getNomRub() {
		return this.nomRub;
	}

	public void setNomRub(String nomRub) {
		this.nomRub = nomRub;
	}

	public String getRubOrd() {
		return this.rubOrd;
	}

	public void setRubOrd(String rubOrd) {
		this.rubOrd = rubOrd;
	}

	public List<Refrub> getRefrubs() {
		return this.refrubs;
	}

	public void setRefrubs(List<Refrub> refrubs) {
		this.refrubs = refrubs;
	}

	public Refrub addRefrub(Refrub refrub) {
		getRefrubs().add(refrub);
		refrub.setRubBean(this);

		return refrub;
	}

	public Refrub removeRefrub(Refrub refrub) {
		getRefrubs().remove(refrub);
		refrub.setRubBean(null);

		return refrub;
	}

}