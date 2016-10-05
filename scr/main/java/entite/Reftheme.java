package entite;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the reftheme database table.
 * 
 */
@Entity
@NamedQuery(name="Reftheme.findAll", query="SELECT r FROM Reftheme r")
public class Reftheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTheme;

	private String annee;

	private int idThemePere;

	private String nom;

	private BigDecimal quantite;

	private String theme;

	//bi-directional many-to-one association to Jointheme
	@OneToMany(mappedBy="reftheme")
	private List<Jointheme> jointhemes;

	public Reftheme() {
	}

	public int getIdTheme() {
		return this.idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getAnnee() {
		return this.annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public int getIdThemePere() {
		return this.idThemePere;
	}

	public void setIdThemePere(int idThemePere) {
		this.idThemePere = idThemePere;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<Jointheme> getJointhemes() {
		return this.jointhemes;
	}

	public void setJointhemes(List<Jointheme> jointhemes) {
		this.jointhemes = jointhemes;
	}

	public Jointheme addJointheme(Jointheme jointheme) {
		getJointhemes().add(jointheme);
		jointheme.setReftheme(this);

		return jointheme;
	}

	public Jointheme removeJointheme(Jointheme jointheme) {
		getJointhemes().remove(jointheme);
		jointheme.setReftheme(null);

		return jointheme;
	}

}