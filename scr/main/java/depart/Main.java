package depart;

import java.awt.EventQueue;

import dialogue.FConnexion;

/**
 * Point de départ de l'application.
 */
public class Main implements Runnable {

	public static void main(String[] args) {

		System.out.println("Lancement du programme Luna");
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Main());
	}

	@Override
	public void run() {
		FConnexion frame = new FConnexion();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		System.out.println("Fenêtre de Connexion visible");
	}
}
