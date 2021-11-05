package modele;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe MareesUnJour, contient les marées d'un même jour.
 * Elle fait partie du package modele.
 * @author Arthur Pellegrini
 * @see java.io.Serializable
 * @see java.util.ArrayList
 */
public class MareesUnJour implements Serializable {
	private static final long serialVersionUID = -6400579784971417455L;
	/**
	 * Attribut privé de type ArrayList contenant des objets de la classe Maree, stocke les marées d'un jour
	 */
	private ArrayList <Maree> chMareeUnJour = new ArrayList <Maree>(4);
	
	/**
	 * Contructeur avec paramètres de la classe MareesUnJour, permet de créer un objet MareesUnJour.
	 * @param parMareePm1, la première pleine marée
	 * @param parMareePm2, la deuxième pleine marée
	 * @param parMareeBm1, la première basse marée
	 * @param parMareeBm2, la deuxième basse marée
	 */
	public MareesUnJour(Maree parMareePm1, Maree parMareePm2, Maree parMareeBm1, Maree parMareeBm2) {
		chMareeUnJour.add(parMareePm1);
		chMareeUnJour.add(parMareePm2);
		chMareeUnJour.add(parMareeBm1);
		chMareeUnJour.add(parMareeBm2);
	}
	
	/**
	 * Contructeur sans paramètres de la classe MareesUnJour, permet de créer un objet MareesUnJour vide.
	 */
	public MareesUnJour() {
	}
	
	/**
	 * Renvoie la liste des marées du this.
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
