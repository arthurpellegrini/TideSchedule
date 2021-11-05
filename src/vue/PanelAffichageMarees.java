package vue;

import java.awt.GridLayout;
import javax.swing.JPanel;
import constantes.*;
import modele.*;

/**
 * Classe PanelAffichageMarees, permet l'affichage du panel contenant : un formulaire et une table Mar�es.
 * @author Arthur Pellegrini
 * @see java.awt.GridLayout
 * @see javax.swing.JPanel
 */
public class PanelAffichageMarees extends JPanel implements ConstantesInterface, Constantes{
	private static final long serialVersionUID = -2641408870634230648L;
	/**
	 * Attribut priv� chPanelFormulaire de type PanelFormulairePort
	 */
	private PanelFormulairePort chPanelFormulaire;
	/**
	 * Attribut priv� chPanelTableMarees de type PanelTableMarees
	 */
	private PanelTableMarees chPanelTableMarees;
	
	/**
	 * Constructeur de la Classe PanelAffichageMarees
	 */
	public PanelAffichageMarees (){
			
		setLayout(new GridLayout(2,1));
	
		chPanelFormulaire = new PanelFormulairePort();
		chPanelTableMarees = new PanelTableMarees(PORTS[0],new Date());
		chPanelTableMarees.setLayout(new GridLayout());
	
		add(chPanelFormulaire);
		add(chPanelTableMarees);
		setBackground(GRIS_FONCE);
		}
	
	/**
	 * Renvoie le PanelFormulaire utilis� par this
	 * @return chPanelFormulaire
	 */
	public PanelFormulairePort getPanelFormulaire() {
		return chPanelFormulaire;
		}
	
	/**
	 * Renvoie le PanelTableMarees utilis� par this
	 * @return chPanelTableMarees
	 */
	public PanelTableMarees getPanelTableMarees() {
		return chPanelTableMarees;
		}
	}
