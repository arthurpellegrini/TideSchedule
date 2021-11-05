package vue;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import constantes.*;
/**
 * Classe CelluleRendererTableHauteurEau. Cette classe rend la tableHauteurEau plus agréable à regarder.
 * @author Arthur Pellegrini
 * @see java.awt.Component
 * @see javax.swing
 */
public class CelluleRendererTableHauteurEau extends JLabel implements TableCellRenderer,ConstantesInterface {
	private static final long serialVersionUID = 7614980041275818704L;
	
	/**
	 * Constructeur de la classe CelluleRendererTableHauteurEau
	 */
	public CelluleRendererTableHauteurEau () {
		super();
		setOpaque (true);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		this.setForeground(GRIS_CLAIR);
		}

	/**
	 * Cette méthode est utilisée par le PanelTableHauteurEau dans le but de changer le style du tableau.
	 * @param table, la table qui sera modifié
	 * @param valeur, la valueur de la cellule
	 * @param estSelectionne, permet de savoir si la cellule est sélectionnée
	 * @param aLeFocus, permet de svoir si la cellule a le focus
	 * @param ligne, ligne de la cellule
	 * @param colonne, colonne de la cellule
	 */
	public Component getTableCellRendererComponent(JTable table, Object valeur, boolean estSelectionne,boolean aLeFocus, int ligne, int colonne) {
		
		if (valeur == null)
			return null;
		String valeurString = ((String) valeur);
		if(ligne%2 == 0)
			this.setBackground(GRIS_CLAIR);
		
		if(ligne%2 == 1)
			this.setBackground(GRIS_FONCE);
	
		if(valeurString.equals("0.0m"))
			valeurString = valeurString.replaceAll("0.0m","- - - -");
		
		this.setFont(US_14);
		this.setForeground(BLANC);
		this.setOpaque(true);
		this.setText(valeurString);
		this.setToolTipText(valeurString);
		this.setBorder(BorderFactory.createLineBorder(GRIS_FONCE));
			
		return this;
	}
}

