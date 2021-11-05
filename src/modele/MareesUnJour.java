package modele;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe MareesUnJour, contient les mar�es d'un m�me jour.
 * Elle fait partie du package modele.
 * @author Arthur Pellegrini
 * @see java.io.Serializable
 * @see java.util.ArrayList
 */
public class MareesUnJour implements Serializable {
	private static final long serialVersionUID = -6400579784971417455L;
	/**
	 * Attribut priv� de type ArrayList contenant des objets de la classe Maree, stocke les mar�es d'un jour
	 */
	private ArrayList <Maree> chMareeUnJour = new ArrayList <Maree>(4);
	
	/**
	 * Contructeur avec param�tres de la classe MareesUnJour, permet de cr�er un objet MareesUnJour.
	 * @param parMareePm1, la premi�re pleine mar�e
	 * @param parMareePm2, la deuxi�me pleine mar�e
	 * @param parMareeBm1, la premi�re basse mar�e
	 * @param parMareeBm2, la deuxi�me basse mar�e
	 */
	public MareesUnJour(Maree parMareePm1, Maree parMareePm2, Maree parMareeBm1, Maree parMareeBm2) {
		chMareeUnJour.add(parMareePm1);
		chMareeUnJour.add(parMareePm2);
		chMareeUnJour.add(parMareeBm1);
		chMareeUnJour.add(parMareeBm2);
	}
	
	/**
	 * Contructeur sans param�tres de la classe MareesUnJour, permet de cr�er un objet MareesUnJour vide.
	 */
	public MareesUnJour() {
	}
	
	/**
	 * Renvoie la liste des mar�es du this.
	 * @return chMareeUnJour
	 */
	public ArrayList<Maree> getMareesUnJour() {
		return chMareeUnJour;
	}
	
	/**
	 * Permet de convertir un objet MareesUnJour en un objet de type String.
	 */
	public String toString() {
		String liste = "";
		for(Maree m: chMareeUnJour)
			liste += m.toString();
		return liste;
	}
}
