package controle.connection;

import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Connexion {
	
	private static final Connexion connexion = new Connexion("StockNew");

	public static Connexion getConnexion() {
		return connexion;
	}
	
	private final EntityManagerFactory fabrique;
	
	public Connexion(String unite) {
		fabrique = Persistence.createEntityManagerFactory(unite);
	}

	public boolean controle(String nom, String motDePasse) {
		boolean verificationSaisie = false;
		EntityManager gerant = fabrique.createEntityManager();
		Object nomUtilisateurCorrect = gerant.getProperties().get("javax.persistence.jdbc.user");
		Object motDePasseCorrect = gerant.getProperties().get("javax.persistence.jdbc.password");
		verificationSaisie = nom.equals(nomUtilisateurCorrect) && motDePasse.equals(motDePasseCorrect);
		gerant.close();
		
		return verificationSaisie;
	}
	
	public void fermeture() {
		fabrique.close();
	}
	
	public <R>R chercher(Function<EntityManager, R> fonction) {
		EntityManager em = fabrique.createEntityManager();
		try {
			R resultat = fonction.apply(em);
			return resultat;
		} finally {
			em.close();
		}
	}

	public <R>R modifier(Function<EntityManager, R> fonction) {
		EntityManager em = fabrique.createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			R resultat = fonction.apply(em);
			transaction.commit();
			return resultat;
		} finally {
			em.close();
		}
	}


}
