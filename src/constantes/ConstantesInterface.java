package constantes;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;

/**
 * L'interface ConstantesInterface fournit des constantes utilisées pour la partie graphique de l'interface.
 * Elle fait partie du package constantes.
 * @author Arthur Pellegrini
 */
public interface ConstantesInterface {
	
	/**
	 * Final constante de type boolean qui permet de dire si la fenêtre de l'interface est redimentionnable.
	 */
	final boolean RESIZABLE = true;
	
	/**
	 * Final constante de type int qui donne la taille de la fenêtre en horizontal.
	 */
	final int HORIZONTAL = 1100;
	
	/**
	 * Final constante de type int qui donne la taille de la fenêtre en vertical.
	 */
    final int VERTICAL = 600;
    
    /**
	 * Final constante de type int qui donne la position de la fenêtre en abscisse.
	 * Cette position est calculée de telle sorte que la fenêtre soit en plein milieu de l'écran.
	 * @see java.awt.Toolkit
	 */
    final int POSX = (Toolkit.getDefaultToolkit().getScreenSize().width - HORIZONTAL)/2;
    
    /**
	 * Final constante de type int qui donne la position de la fenêtre en ordonné.
	 * Cette position est calculée de telle sorte que la fenêtre soit en plein milieu de l'écran.
	 * @see java.awt.Toolkit
	 */
    final int POSY = (Toolkit.getDefaultToolkit().getScreenSize().height - VERTICAL)/2;
    
    /**
	 * Final constante de type Color qui donne la couleur orange.
	 * @see java.awt.Color
	 */
    final Color ORANGE = new Color (255, 179, 71);
    
    /**
	 * Final constante de type Color qui donne la couleur rouge.
	 * @see java.awt.Color
	 */
    final Color ROUGE = new Color (247, 35, 12);
    
    /**
	 * Final constante de type Color qui donne la couleur bleu.
	 * @see java.awt.Color
	 */
    final Color BLEU = new Color (49, 140, 231);
    
    /**
	 * Final constante de type Color qui donne la couleur blanche.
	 * @see java.awt.Color
	 */
    final Color BLANC = new Color (255, 255, 255);
    
    /**
	 * Final constante de type Color qui donne la couleur gris clair.
	 * @see java.awt.Color
	 */
    final Color GRIS_CLAIR = new Color (60, 63, 65);
    
    /**
	 * Final constante de type Color qui donne la couleur gris foncé.
	 * @see java.awt.Color
	 */
    final Color GRIS_FONCE = new Color (49, 51, 53);

    /**
	 * Final constante de type Font qui donne la police Uni Sans en taille 24.
	 * @see java.awt.Font
	 */
    public final static Font US_24 = new Font ("Uni Sans", Font.PLAIN,24);
    
    /**
	 * Final constante de type Font qui donne la police Uni Sans en taille 14.
	 * @see java.awt.Font
	 */
    public final static Font US_14 = new Font ("Uni Sans", Font.PLAIN,14);
    
    /**
	 * Final constante de type Font qui donne la police Uni Sans en taille 12.
	 * @see java.awt.Font
	 */
    public final static Font US_12 = new Font ("Uni Sans", Font.PLAIN,12);
}
