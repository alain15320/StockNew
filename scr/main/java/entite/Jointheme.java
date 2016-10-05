package entite;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the jointheme database table.
 * 
 */
@Entity
@NamedQuery(name="Jointheme.findAll", query="SELECT j FROM Jointheme j")
public class Jointheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idJoinTheme;

	//bi-directional many-to-one association to Refphil
	@ManyToOne
	@JoinColumn(name="idRefPhil")
	private Refphil refphil;

	//bi-directional many-to-one association to Reftheme
	@ManyToOne
	@JoinColumn(name="idTheme")
	private Reftheme reftheme;

	public Jointheme() {
	}

	public int getIdJoinTheme() {
		return this.idJoinTheme;
	}

	public void setIdJoinTheme(int idJoinTheme) {
		this.idJoinTheme = idJoinTheme;
	}

	public Refphil getRefphil() {
		return this.refphil;
	}

	public void setRefphil(Refphil refphil) {
		this.refphil = refphil;
	}

	public Reftheme getReftheme() {
		return this.reftheme;
	}

	public void setReftheme(Reftheme reftheme) {
		this.reftheme = reftheme;
	}

}