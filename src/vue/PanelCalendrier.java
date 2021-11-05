package vue;
import java.awt.*;
import javax.swing.JPanel ;

import constantes.*;
import controleur.Controleur;
import modele.Date;

import javax.swing.JLabel ;
import javax.swing.JButton ;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Class PanelCalendrier, permet de créer une liste de date
 * @author Arthur Pellegrini
 * @see java.awt
 * @see javax.swing
 * @see java.util
 */
public class PanelCalendrier  extends JPanel implements ActionListener, Constantes, ConstantesInterface {
	private static final long serialVersionUID = 1L;
	/**
	 * Attribut panelCenre contenant ce qui sera affiché au centre de la fenetre
	 */
	JPanel panelCentre = new JPanel ( ) ; 
	/**
	 * Attribut gestCard contenant tout les panelCentre possibles permettant ainsi de switcher d'un panel à un autre
	 */
	CardLayout gestCard = new CardLayout(10,10);
	/**
	 * Attribut tabBoutons contenant tout les boutons d'un même mois
	 */
	JButton [] tabBoutons = new JButton [INTITULES_BOUTONS.length];
	/**
	 * Attribut contenant le nom du mois
	 */
	JLabel labelIntituleMois;
	/**
	 * Attribut contenant le numéro du mois
	 */
	int indiceMois = 0;  
	/**
	 * Attribut contenant la liste des panels 
	 */
	PanelMois [] panelsMois ;
	/**
	 * Attribut contenant la liste des panels 
	 */
	ArrayList <PanelMois> ListeMois = new ArrayList<PanelMois>();
  
	/**
	 * Constructeur de la Classe PanelCalendrier
	 */
  public  PanelCalendrier  ()	{
	 
	Date today = new Date();		 
	
	this.setLayout (new BorderLayout (9,9)) ;  
	JPanel panelSud = new JPanel ( ) ; 
	this.add (panelSud, BorderLayout.SOUTH); 
		
	// panelCentre
	this.add (panelCentre, BorderLayout.CENTER);
	panelsMois = new PanelMois [MOIS.length];

	panelCentre.setLayout (gestCard);
	for (int indiceMois = 0 ; indiceMois< Constantes.MOIS.length ; indiceMois++)		{
		panelsMois [indiceMois] = new PanelMois (indiceMois+1);
		ListeMois.add(panelsMois[indiceMois]);
	 	panelCentre.add (panelsMois[indiceMois], MOIS[indiceMois]);
		
	}
	// placer le mois courant en haut de la pile
	gestCard.show (panelCentre, MOIS[today.getMois()-1]); 		
	indiceMois = today.getMois()-1;
	
	// panelSud  
	labelIntituleMois = new JLabel (MOIS[today.getMois()-1], JLabel.LEFT);
	labelIntituleMois.setPreferredSize(new Dimension (80,20));
	labelIntituleMois.setFont (US_14);
	labelIntituleMois.setForeground (BLANC);
	panelSud.add (labelIntituleMois);  
	
	panelSud.setLayout (new FlowLayout ( FlowLayout.CENTER, 4,4));	
	for (int i = 0 ; i< INTITULES_BOUTONS.length ; i++)		{
		tabBoutons[i] = new JButton (INTITULES_BOUTONS[i]);  
		tabBoutons[i].setActionCommand(INTITULES_BOUTONS[i]) ; 
		tabBoutons[i].addActionListener (this);  
		tabBoutons[i].setFont (US_14);
		tabBoutons[i].setForeground (BLANC);
		tabBoutons[i].setBackground(GRIS_FONCE);
		tabBoutons[i].setBorderPainted(false);
		panelSud.add (tabBoutons[i]) ;
	}
	
	panelCentre.setBackground(GRIS_CLAIR);
	panelSud.setBackground (GRIS_CLAIR);	
	setBackground (GRIS_CLAIR);
	setPreferredSize(new Dimension (500,320));
	
} // PanelFils()

  /**
   * Action Performed permet de changer de gestionnaire de cartes pour cahnger de mois
   * @param evt, l'événement déclanché par l'utilisateur
   */
  public void actionPerformed (ActionEvent evt){ 
	// pour décoloriser le bouton sélectionné  
	JButton boutonSelectionne = panelsMois[indiceMois].getBoutonSelectionne();
	if (boutonSelectionne != null) {
		boutonSelectionne.setBackground(ROUGE);
	}
	switch (evt.getActionCommand()) {
		case INTIT_PREMIER :{
			gestCard.first (panelCentre);
			indiceMois=0; 			
			break;
		}
		case INTIT_PRECEDENT :{
			gestCard.previous (panelCentre);		 
			if (indiceMois==0) {
				indiceMois=Constantes.MOIS.length-1; 				
				}
			else {
				--indiceMois;
			}
			break ;
		}
		case INTIT_SUIVANT :{
			gestCard.next (panelCentre);		
			if (indiceMois==Constantes.MOIS.length-1) {
				indiceMois=0; 
				 
				}
			else {
				++indiceMois;
			}
			break;
		}
		case INTIT_DERNIER : {
			gestCard.last (panelCentre);
			indiceMois=Constantes.MOIS.length-1; 
			break;			
		}
		 
	}// switch
	labelIntituleMois.setText (Constantes.MOIS[indiceMois]);
	
  }// actionPerformed

  /**
   * Permet de mettre à l'écoute tout un calendrier
   * @param parCtrl, le controleur qui écoutera les actions
   */
  public void enregistreEcouteur(Controleur parCtrl){
	  for (int i = 0 ; i< ListeMois.size() ; i++) {
			for(BoutonDate bouton : ListeMois.get(i).listeBouton) 
				bouton.addActionListener(parCtrl);
			}
	}
} 
