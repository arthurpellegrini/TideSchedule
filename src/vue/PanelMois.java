package vue;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.*;
import modele.CalendrierDuMois;
import modele.Date;

/**
 * Classe PanelMois permet de créer une liste de boutons date pour un mois
 * @author Arthur Pellegrini
 * @see java.awt
 * @see java.util
 * @see javax.swing
 */
public class PanelMois extends JPanel implements Constantes, ConstantesInterface {
	private static final long serialVersionUID = 1L;
	/**
	 * Attribut boutonSelectionne contenant le bouton selectionné
	 */
	BoutonDate boutonSelectionne ;	 
	/**
	 * Attribut liste de tout les boutons
	 */
	ArrayList <BoutonDate> listeBouton = new ArrayList <BoutonDate> ();
	
	/**
	 * Constructeur de la classe PanelMois
	 * @param mois, permet de créer toute les dates pour ce même mois
	 */
	public PanelMois (int mois)  {
		Date today = new Date();
		 
		Collection <Date> datesDuMois = new CalendrierDuMois(mois,today.getAnnee()).getDates();		
		this.setLayout(new GridLayout (0,7,8,8));
		for (int i= 0; i < 7 ; i++) {
			JLabel labeljour = new  JLabel (JOURS_SEMAINE_ABR[i],JLabel.CENTER);
			labeljour.setFont (US_14);
			labeljour.setForeground (BLANC);
			this.add(labeljour);
			}
		
		BoutonDate boutonJour;
		
		Iterator <Date> iterateur = datesDuMois.iterator();
		while (iterateur.hasNext()) {
				Date date = iterateur.next() ;
				boutonJour = new  BoutonDate (date);
				listeBouton.add(boutonJour); 
				
				// gestion des couleurs des boutons 
				this.add(boutonJour);
				boutonJour.setForeground(BLANC);
				boutonJour.setBackground (GRIS_FONCE);
				
				if (date.isToday())
					boutonJour.setBackground(ORANGE);
					
				if (date.getMois()!=mois)
					boutonJour.setForeground(BLEU);		
			}		
		setBackground (GRIS_CLAIR);
		}
	
	/**
	 * Renvoie le bouton sélectionné
	 * @return un objet de la classe JButton
	 */
	public JButton getBoutonSelectionne () {
		return boutonSelectionne;	
		}
}
