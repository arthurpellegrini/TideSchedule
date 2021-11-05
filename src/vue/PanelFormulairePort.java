package vue;

import java.awt.*;

import javax.swing.*;
import constantes.*;
import controleur.*;
import modele.*; 

/**
 * Classe PanelFormulairePort qui permet de choisir un port 
 * @author Arthur Pellegrini
 * @see java.awt
 * @see javax.swing
 */
public class PanelFormulairePort extends JPanel implements ConstantesInterface, Constantes { 
	private static final long serialVersionUID = 1L;
	/**
	 * Attribut contenant la date à afficher
	 */
	private Date date;
	/**
	 * Attribut contenant le label à afficher
	 */
	private JLabel labelDate ;
	/**
	 * Attribut permettant la selection du port
	 */
	private JComboBox <String> chComboPorts = new JComboBox <String> (PORTS);
	/**
	 * Attribut permettant de valider la selection
	 */
	private JButton chBoutonSelection = new JButton(INTITULE_BOUTON_SELECTIONNE);
	
	/**
	 * Le constructeur de la classe PanelFormulairePort()
	 */
	public PanelFormulairePort () {
		date = new Date();   
		// à l'ouverture le formulaire de saisie contient la date courante
		labelDate = new JLabel (date.toString(), JLabel.LEFT);
		
		// Le gestionnaire de répartition
		setLayout (new GridBagLayout ());	
		GridBagConstraints contraintes = new GridBagConstraints ();
	  	contraintes.insets = new Insets (6,6,6,6); 
		contraintes.anchor = GridBagConstraints.WEST;
	
	    // labelDate
		contraintes.gridy=0; contraintes.gridwidth = 4;	contraintes.gridx=0;
		labelDate.setFont(US_24);
		labelDate.setForeground(BLANC);
		this.add(labelDate, contraintes);
		
		// labelPort
		JLabel labelPortsDisponibles = new JLabel ("Ports disponibles", JLabel.LEFT);
		contraintes.gridy++; contraintes.gridx=0; contraintes.gridwidth = 1;
		labelPortsDisponibles.setFont(US_14);
		labelPortsDisponibles.setForeground(BLANC);
		labelPortsDisponibles.setDisplayedMnemonic('P');
		labelPortsDisponibles.setLabelFor(chComboPorts);
		this.add (labelPortsDisponibles,contraintes); 
		contraintes.gridx++; contraintes.gridwidth =4 ; 
		contraintes.fill = GridBagConstraints.HORIZONTAL;	
		
		//Partie Critère
		chComboPorts.setFont(US_14);
		chComboPorts.setForeground(BLANC);
		chComboPorts.setBackground(GRIS_CLAIR);
		this.add(chComboPorts, contraintes);
		
		// boutonSelection
		contraintes.gridx = 1; contraintes.gridy++;
		chBoutonSelection.setFont(US_14);
		chBoutonSelection.setForeground(BLANC);
		chBoutonSelection.setBackground(GRIS_CLAIR);
		this.add(chBoutonSelection, contraintes);

		setBackground(GRIS_FONCE);
	}
	
	/**
	 * Permet de changer la date du this
	 * @param parDate, la date à afficher
	 */
	public void setDate (Date parDate) {
		date = parDate;
		labelDate.setText(date.toString());
	}

	/**
	 * Permet d'obtenir le port sélectionné
	 * @return port, le port sélectionné
	 */
	public String getPort() {
		return chComboPorts.getSelectedItem().toString();
	}
	
	/**
	 * Permet de mettre à l'écoute le bouton
	 * @param parCtrl, le controleur qui écoutera les actions
	 */
	public void enregistreEcouteur(Controleur parCtrl){
		chBoutonSelection.addActionListener(parCtrl);
		chBoutonSelection.setActionCommand(INTITULE_BOUTON_SELECTIONNE);
	}
}
