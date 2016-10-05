package entite;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the joincompo database table.
 * 
 */
@Entity
@NamedQuery(name="Joincompo.findAll", query="SELECT j FROM Joincompo j")
public class Joincompo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idJoinCompo;

	private int idPereRefPhil;

	private int idRefPhil;

	private int quantite;

	public Joincompo() {
	}

	public int getIdJoinCompo() {
		return this.idJoinCompo;
	}

	public void setIdJoinCompo(int idJoinCompo) {
		this.idJoinCompo = idJoinCompo;
	}

	public int getIdPereRefPhil() {
		return this.idPereRefPhil;
	}

	public void setIdPereRefPhil(int idPereRefPhil) {
		this.idPereRefPhil = idPereRefPhil;
	}

	public int getIdRefPhil() {
		return this.idRefPhil;
	}

	public void setIdRefPhil(int idRefPhil) {
		this.idRefPhil = idRefPhil;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}