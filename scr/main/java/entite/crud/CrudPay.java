package entite.crud;

import java.util.List;

import javax.persistence.Query;

import controle.connection.Connexion;
import entite.Pay;

public class CrudPay {
	
	private final Connexion connexion;

	public CrudPay(Connexion connexion) {
		this.connexion = connexion;
	}

	public void creer(Pay pay) {
		connexion.modifier((em) -> {
			em.persist(pay);
				return pay;	
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<Pay> lire() {
		return connexion.chercher((em) -> {
			//Query requete = em.createNamedQuery("Pay.findAll");
			Query requete = em.createQuery("SELECT p FROM Pay p");
			//Query requete = em.createQuery("SELECT p FROM Groupe p");
			return requete.getResultList();
		});		
	}

	public Pay lire(String id) {
		StringBuilder requete = new StringBuilder("SELECT p ");
		requete.append("FROM pay p ");
		requete.append("WHERE p.idPays = ");
		requete.append("'"+id+"'");
		return connexion.chercher((em) -> {
			Query query = em.createQuery(requete.toString());
			return (Pay) query.getSingleResult();
		});			
	}

	public Pay modifier(Pay pay) {
		return connexion.modifier((em) -> {
			int id = pay.getIdPays();
			Pay paym = em.find(Pay.class, id);
			if (paym == null){
				throw new IllegalArgumentException("Pas de pays avec le code " + id);
			} else {
				paym.setPays(pay.getPays());
				paym.setNomPays(pay.getNomPays());
				paym.setTxChange(pay.getTxChange());
				paym.setNouv(pay.isNouv());
				paym.setCouleur(pay.getCouleur());
				paym.setCapitale(pay.getCapitale());
				paym.setDescrip(pay.getDescrip());
			}			
			return paym;
		});
	}

	public boolean supprimer(int id) {
		return connexion.modifier((em) -> {
			StringBuilder requete = new StringBuilder("SELECT COUNT(refpays.idPays) ");
			requete.append("FROM refpays r ");
			requete.append("WHERE r.idPays like ");
			requete.append("'id'");
			Query query = em.createQuery(requete.toString());
			long result = (long) query.getSingleResult();
			if (result != 0) {
				throw new IllegalArgumentException("Il existe " + result + " refPays pour ce Pays. Suppression interdite");
			}
			Pay pay = em.find(Pay.class, id);
			if (pay == null){
				throw new IllegalArgumentException("Pas de Pays avec le code " + id);
			} else {
				em.remove(pay);
			}	
			return true;
		});
	}

	@SuppressWarnings("unchecked")
	public List<Pay> chercher(String recherche) {
		return connexion.chercher((em) -> {
			Query query = em.createNamedQuery("pay.FindByIdPays");
			query.setParameter("recherche", "%"+recherche+"%");
			return query.getResultList();
		});		
	}
	
}
