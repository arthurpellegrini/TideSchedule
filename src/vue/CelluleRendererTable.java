package vue;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import constantes.*;

public class CelluleRendererTable extends JLabel implements TableCellRenderer,ConstantesInterface {
	private static final long serialVersionUID = 7614980041275818704L;
	
	public CelluleRendererTable () {
		super();
		setOpaque (true);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		this.setForeground(GRIS_CLAIR);
		}

	public Component getTableCellRendererComponent(JTable table, Object valeur, boolean estSelectionne,boolean aLeFocus, int ligne, int colonne) {
		
		if (valeur == null)
			return null;
		String valeurString = ((String) valeur);
		if(ligne%2 == 0)
			this.setBackground(GRIS_CLAIR);
		
		if(ligne%2 == 1)
			this.setBackground(GRIS_FONCE);
	
		if(valeurString.equals("00:00"))
			valeurString = valeurString.replaceAll("00:00","- - : - -");
		if(valeurString.equals("0.0m"))
			valeurString = valeurString.replaceAll("0.0m","- - - -");
		if(valeurString.equals("0"))
			valeurString = valeurString.replaceAll("0","- - - -");
		
		this.setFont(US_12);
		this.setForeground(BLANC);
		this.setOpaque(true);
		this.setText(valeurString);
		this.setToolTipText(valeurString);
		this.setBorder(BorderFactory.createLineBorder(GRIS_FONCE));
			
		return this;
	}
}

