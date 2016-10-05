package entite.crud;

import java.util.List;

import javax.persistence.Query;

import controle.connection.Connexion;
import entite.Groupe;

public class CrudGroupe {

	private final Connexion connexion;

	public CrudGroupe(Connexion connexion) {
		this.connexion = connexion;
	}

	public void creer(Groupe groupe) {
		connexion.modifier((em) -> {
			em.persist(groupe);
				return groupe;	
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Groupe> lire() {
		return connexion.chercher((em) -> {
			Query requete = em.createNamedQuery("Groupe.findAll");
			return requete.getResultList();
		});		
	}
	
}
