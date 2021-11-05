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
 * Classe PanelTableHauteurEau
 * @author Arthur Pellegrini
 * @see java.util
 */
public class PanelTableHauteurEau extends JPanel implements ConstantesInterface{
	private static final long serialVersionUID = -2641408870634230648L;
	/**
	 * Attribut chModele contenant le modele de la table crée
	 */
	private ModelTableHauteurEau chModele;
	/**
	 * Attribut chTable contenant la table crée
	 */
	private JTable chTable;
	
	/**
	 * Constructeur de la classe PanelTableHauteurEau
	 * @param parPort, le port sélectionné
	 * @param parDate, la date sélectionné
	 */
	public PanelTableHauteurEau(String parPort, Date parDate){
		ArrayList<HauteurEau> listeHauteurMareesUnJour = LectureFichierTxt.getHauteurMaree(parPort,parDate);
		chModele = new ModelTableHauteurEau(listeHauteurMareesUnJour);
		chTable = new JTable (chModele) ;
		chTable.setRowHeight(50);
		chTable.getTableHeader().setResizingAllowed(false);
		chTable.getTableHeader().setReorderingAllowed(false);
		chTable.getTableHeader().setFont(US_14);
		chTable.getTableHeader().setBackground(BLEU);
		chTable.setDefaultRenderer ( Object.class, new CelluleRendererTableHauteurEau());
		JScrollPane scrollPane = new JScrollPane(chTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED) ;
		this.add(scrollPane);
		scrollPane.setBackground(GRIS_FONCE);
	}
	
	/**
	 * Permet de mettre à jour le model
	 * @param parListeHauteurMareesUnJour, ArrayList des Hauteur d'eau à afficher
	 */
	public void setModelTableHauteurEau(ArrayList<HauteurEau> parListeHauteurMareesUnJour){
		ModelTableHauteurEau modele = new ModelTableHauteurEau(parListeHauteurMareesUnJour);
		chTable.setModel(modele);
	}
}