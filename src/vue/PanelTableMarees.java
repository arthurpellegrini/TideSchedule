package vue;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import constantes.*;
import modele.*;
import outils.LectureFichierTxt;

/**
 * Classe PanelTableMarees
 * @author Arthur Pellegrini
 * @see java.util
 */
public class PanelTableMarees extends JPanel implements ConstantesInterface{
	private static final long serialVersionUID = -2641408870634230648L;
	/**
	 * Attribut chModele contenant le modele de la table crée
	 */
	private ModelTableMarees chModele;
	/**
	 * Attribut chTable contenant la table crée
	 */
	private JTable chTable;
		
		/**
		 * Constructeur de la classe PanelTableMarees
		 * @param parPort, le port 
		 * @param parDate, la date
		 */
		public PanelTableMarees(String parPort, Date parDate){
			ArrayList<Maree> listeMareesUnJour = LectureFichierTxt.getMareeDuJour(parPort,parDate);
			chModele = new ModelTableMarees(listeMareesUnJour);
			chTable = new JTable (chModele) ;
			chTable.setRowHeight((VERTICAL/2)/5);
			chTable.getTableHeader().setResizingAllowed(false);
			chTable.getTableHeader().setReorderingAllowed(false);
			chTable.getTableHeader().setFont(US_14);
			chTable.getTableHeader().setBackground(BLEU);
			chTable.setDefaultRenderer ( Object.class, new CelluleRendererTableMarees());
			JScrollPane scrollPane = new JScrollPane(chTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
			this.add(scrollPane);
			scrollPane.setBackground(GRIS_FONCE);
		}
		
		/**
		 * Permet de mettre à jour le model
		 * @param parListeMareesUnJour, ArrayList des marées à afficher dans la table
		 */
		public void setModelTableMarees(ArrayList<Maree> parListeMareesUnJour){
			ModelTableMarees modele = new ModelTableMarees(parListeMareesUnJour);
			chTable.setModel(modele);
		}
	}