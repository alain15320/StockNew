package dialogue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.eclipse.persistence.exceptions.DatabaseException;

import controle.connection.Connexion;

public class FConnexion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSaisieUtilisateur;
	private JPasswordField pwdMotDePasse;
	private final Action action = new ActionValider();
	private JButton btnValider;

	/**
	 * Create the frame.
	 */
	public FConnexion() {
		createContents();
	}
	
	
	public void createContents() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage(Fconnexion.class.getResource("/images/Moon-32.png")));
		setIconImage(UI.getLogo());
		setTitle(Messages.getString("FConnexion.this.title")); //$NON-NLS-1$ //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTitre = new JLabel(Messages.getString("FConnexion.1")); //$NON-NLS-1$
		lblTitre.setFont(lblTitre.getFont().deriveFont(20f));
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Shopping-Cart-05-48.png"))); //$NON-NLS-1$
		contentPane.add(lblTitre, BorderLayout.NORTH);

		JPanel panel_global = new JPanel();
		panel_global.setBorder(new CompoundBorder(new EmptyBorder(14, 14, 14, 14), new LineBorder(new Color(0X33, 0XB5, 0XE), 3, true)));
		contentPane.add(panel_global, BorderLayout.CENTER);
		panel_global.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_connexion = new JPanel();
		panel_connexion.setBorder(new EmptyBorder(8, 8, 8, 8));
		panel_connexion.setBackground(Color.WHITE);
		panel_global.add(panel_connexion);
		GridBagLayout gbl_panel_connexion = new GridBagLayout();
		gbl_panel_connexion.columnWidths = new int[]{0, 0, 0};
		gbl_panel_connexion.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_connexion.columnWeights = new double[]{30.0, 70.0, Double.MIN_VALUE};
		gbl_panel_connexion.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_connexion.setLayout(gbl_panel_connexion);
		
		JLabel lblUtilisateur = new JLabel(Messages.getString("FConnexion.3")); //$NON-NLS-1$
		lblUtilisateur.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Windows-8-Login-16.png"))); //$NON-NLS-1$
		lblUtilisateur.setHorizontalTextPosition(SwingConstants.LEADING);
		GridBagConstraints gbc_lblUtilisateur = new GridBagConstraints();
		gbc_lblUtilisateur.insets = new Insets(5, 5, 5, 5);
		gbc_lblUtilisateur.anchor = GridBagConstraints.EAST;
		gbc_lblUtilisateur.gridx = 0;
		gbc_lblUtilisateur.gridy = 0;
		panel_connexion.add(lblUtilisateur, gbc_lblUtilisateur);
		UI.habiller(lblUtilisateur);
		
		txtSaisieUtilisateur = new JTextField();
		txtSaisieUtilisateur.setText(Messages.getString("FConnexion.5")); //$NON-NLS-1$
		GridBagConstraints gbc_txtSaisieUtilisateur = new GridBagConstraints();
		gbc_txtSaisieUtilisateur.insets = new Insets(0, 5, 5, 0);
		gbc_txtSaisieUtilisateur.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSaisieUtilisateur.gridx = 1;
		gbc_txtSaisieUtilisateur.gridy = 0;
		panel_connexion.add(txtSaisieUtilisateur, gbc_txtSaisieUtilisateur);
		txtSaisieUtilisateur.setColumns(10);
		UI.habiller(txtSaisieUtilisateur);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe"); //$NON-NLS-1$
		lblMotDePasse.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Key-16.png"))); //$NON-NLS-1$
		lblMotDePasse.setHorizontalTextPosition(SwingConstants.LEADING);
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.anchor = GridBagConstraints.EAST;
		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotDePasse.gridx = 0;
		gbc_lblMotDePasse.gridy = 1;
		panel_connexion.add(lblMotDePasse, gbc_lblMotDePasse);
		UI.habiller(lblMotDePasse);
		
		pwdMotDePasse = new JPasswordField();
		pwdMotDePasse.setText(Messages.getString("FConnexion.pwdMotDePasse.text")); //$NON-NLS-1$ //$NON-NLS-1$
		GridBagConstraints gbc_pwdMotDePasse = new GridBagConstraints();
		gbc_pwdMotDePasse.insets = new Insets(5, 5, 5, 0);
		gbc_pwdMotDePasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdMotDePasse.gridx = 1;
		gbc_pwdMotDePasse.gridy = 1;
		panel_connexion.add(pwdMotDePasse, gbc_pwdMotDePasse);
		UI.habiller(pwdMotDePasse);
		
		JTextPane txtpnInfo = new JTextPane();
		txtpnInfo.setForeground(Color.GRAY);
		txtpnInfo.setEditable(false);
		txtpnInfo.setText(Messages.getString("FConnexion.9")); //$NON-NLS-1$
		GridBagConstraints gbc_txtpnInfo = new GridBagConstraints();
		gbc_txtpnInfo.gridwidth = 2;
		gbc_txtpnInfo.insets = new Insets(5, 0, 0, 0);
		gbc_txtpnInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnInfo.gridx = 0;
		gbc_txtpnInfo.gridy = 2;
		panel_connexion.add(txtpnInfo, gbc_txtpnInfo);
		UI.habiller(txtpnInfo);
		
	
		JPanel panel_actions = new JPanel();
		panel_actions.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel_actions, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_actions = new GridBagLayout();
		gbl_panel_actions.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_actions.rowWeights = new double[]{0.0};
		panel_actions.setLayout(gbl_panel_actions);
		
		JButton btnParametres = new JButton(Messages.getString("FConnexion.10")); //$NON-NLS-1$
		btnParametres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parametres();
			}
		});
		btnParametres.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Customize-01-48.png"))); //$NON-NLS-1$
		UI.deshabillerBouton(btnParametres, "connection", "Customize-01"); //$NON-NLS-1$ //$NON-NLS-2$
		GridBagConstraints gbc_btnParametres = new GridBagConstraints();
		gbc_btnParametres.weightx = 1.0;
		gbc_btnParametres.anchor = GridBagConstraints.LINE_START;
		gbc_btnParametres.insets = new Insets(0, 0, 0, 5);
		gbc_btnParametres.gridx = 0;
		gbc_btnParametres.gridy = 0;
		panel_actions.add(btnParametres, gbc_btnParametres);
		
		JButton btnQuitter = new JButton(Messages.getString("FConnexion.14")); //$NON-NLS-1$
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quitter();
			}
		});
		btnQuitter.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Stop-48.png"))); //$NON-NLS-1$
		UI.deshabillerBouton(btnQuitter, "connection", "Stop");		 //$NON-NLS-1$ //$NON-NLS-2$
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuitter.gridx = 1;
		gbc_btnQuitter.gridy = 0;
		panel_actions.add(btnQuitter, gbc_btnQuitter);
		
		btnValider = new JButton(Messages.getString("FConnexion.18")); //$NON-NLS-1$
		btnValider.setAction(action);
		btnValider.setForeground(Color.WHITE);
		btnValider.setIcon(new ImageIcon(FConnexion.class.getResource("/images/connection/Power-48.png")));
		UI.deshabillerBouton(btnValider, "connection", "Power");	 //$NON-NLS-1$ //$NON-NLS-2$
		btnValider.setHorizontalTextPosition(SwingConstants.LEADING);
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.gridx = 2;
		gbc_btnValider.gridy = 0;
		panel_actions.add(btnValider, gbc_btnValider);
		
		
	}


	protected void quitter() {
		Connexion.getConnexion().fermeture();
		dispose();
	}


	protected void parametres() {
		// TODO Auto-generated method stub
		
	}

	private class ActionValider extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public ActionValider() {
			putValue(NAME, Messages.getString("FConnexion.22")); //$NON-NLS-1$
			putValue(SHORT_DESCRIPTION, Messages.getString("FConnexion.23")); //$NON-NLS-1$
		}
		public void actionPerformed(ActionEvent e) {
			valider();
		}
	}

	public void valider() {
		String leNom = txtSaisieUtilisateur.getText();
		String leMotDePasse = String.valueOf(pwdMotDePasse.getPassword());
		try {
			Connexion connexion = Connexion.getConnexion();
			boolean valide = connexion.controle(leNom, leMotDePasse);
			System.out.println(leNom +" "+leMotDePasse);
			if(valide) {
				FConnexion.this.dispose();
				FAccueil laFenetreMenu = new FAccueil(connexion);
				laFenetreMenu.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(btnValider, Messages.getString("FConnexion.24"), Messages.getString("FConnexion.25"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
		} catch (DatabaseException e) {
			JOptionPane.showMessageDialog(null, Messages.getString("FConnexion.26"), Messages.getString("FConnexion.25"), JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erreur inconnue "+e.getMessage(), Messages.getString("FConnexion.25"), JOptionPane.ERROR_MESSAGE);
		}
		

	}
	
}