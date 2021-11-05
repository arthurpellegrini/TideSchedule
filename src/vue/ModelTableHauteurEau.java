package vue;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import constantes.*;
import modele.*;

/**
 * Classe ModelTableHauteurEau, permet le remplissage des données dans la table HauteurEau.
 * @author Arthur Pellegrini
 * @see javax.swing.table.DefaultTableModel
 * @see java.util.ArrayList
 */
public class ModelTableHauteurEau extends DefaultTableModel implements ConstantesInterface,Constantes{
	private static final long serialVersionUID = -4434444736477465691L;
	
	/**
	 * Constructeur de la classe ModelTableHauteurEau 
	 * @param parListeHauteurMareesUnJour, une ArrayList contenant les hauteur d'eau à afficher dans la table
	 */
	public ModelTableHauteurEau(ArrayList<HauteurEau> parListeHauteurMareesUnJour) {
		if(parListeHauteurMareesUnJour != null) {
			this.setColumnCount(ENTETES_HAUTEUR_EAU.length);
			this.setRowCount(parListeHauteurMareesUnJour.size());
			this.setColumnIdentifiers(ENTETES_HAUTEUR_EAU);

			int ligne = 0;
			for(HauteurEau valeur: parListeHauteurMareesUnJour) {
				setValueAt(valeur.getHoraire().toString(),ligne,0); // VALEUR, N°LIGNE, N°COLONNE
				setValueAt(String.valueOf(valeur.getHauteur()) + "m",ligne,1);
				ligne++;
			}
		}
	}
}		
