package dialogue;

import java.awt.BorderLayout;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.connection.Connexion;
import entite.Groupe;
import entite.Pay;
import entite.crud.CrudGroupe;
import entite.crud.CrudPay;

public class FAccueil extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private final Connexion connexion;

	public FAccueil(Connexion connexion) {

		this.connexion = connexion;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// test
		testGroupe();
		testPays();

	}

	

	public void testPays() {

		System.out.println("Lire pays");
		final CrudPay crud = new CrudPay(connexion);
		List<Pay> pays = null;
		try {
			pays = crud.lire();
			for (Pay pay : pays) {
				System.out.println(pay);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Aucune lecture dans la BD\n"+e.getMessage(), "Problème rencontré", JOptionPane.ERROR_MESSAGE);
			pays = Collections.emptyList();
		}
	}

	public void testGroupe() {

		System.out.println("Lire groupe");
		final CrudGroupe crud = new CrudGroupe(connexion);
		List<Groupe> groupes = null;
		try {
			groupes = crud.lire();
			for (Groupe groupe : groupes) {
				System.out.println(groupe);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Aucune lecture dans la BD\n"+e.getMessage(), "Problème rencontré", JOptionPane.ERROR_MESSAGE);
			groupes = Collections.emptyList();
		}
	}
	
}
