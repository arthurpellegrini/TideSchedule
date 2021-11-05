package vue;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import constantes.*;
import modele.*;

/**
 * Classe ModelTableMarees, permet le remplissage des données dans la table Marées.
 * @author Arthur Pellegrini
 * @see javax.swing.table.DefaultTableModel
 * @see java.util.ArrayList
 */
public class ModelTableMarees extends DefaultTableModel implements ConstantesInterface,Constantes{
	private static final long serialVersionUID = -4434444736477465691L;
		
	/**
	 * Constructeur de la classe ModelTableMarees
	 * @param parListeMareesUnJour, ArrayList des marées d'un journée à affcichés dans la table
	 */
		public ModelTableMarees(ArrayList<Maree> parListeMareesUnJour) {
			this.setColumnCount(ENTETES_MAREES.length);
			this.setRowCount(parListeMareesUnJour.size());
			this.setColumnIdentifiers(ENTETES_MAREES);
			
			int ligne = 0;
			for(Maree m: parListeMareesUnJour) {
				setValueAt(m.getHoraire().toString(),ligne,0); // VALEUR, N°LIGNE, N°COLONNE
				setValueAt(String.valueOf(m.getHauteur()) + "m",ligne,1);
				setValueAt(String.valueOf(m.getCoefficient()),ligne,2);
				setValueAt(m.getTypeMaree(),ligne,3);
				ligne++;	
			}
		}
	}