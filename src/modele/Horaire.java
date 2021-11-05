package modele;

import java.io.Serializable;

/**
 * Class Horaire, permet de créer un objet contenant un horaire.*
 * Elle fait partie du package modele.
 * @author Arthur Pellegrini
 */
public class Horaire implements Serializable {
	private static final long serialVersionUID = 7062956014423694348L;
	/**
	 * Attribut privé de type int, stocke les heures d'un horaire
	 */
	private int chHeure;
	/**
	 * Attribut privé de type int, stocke les minutes d'un horaire
	 */
	private int chMinutes;
	
	/**
	 * Constructeur avec paramètres de la classe Horaire, permet de créer un objet de la classe Horaire.
	 * @param parHeure : int
	 * @param parMinutes : int
	 */
	public Horaire(int parHeure, int parMinutes) {
		chHeure = parHeure;
		chMinutes = parMinutes;
	}
	
	/**
	 * Permet de convertir un horaire en un objet de type String.
	 */
	public String toString() {
		String heure;
		if(chHeure < 10)
			heure = "0" + String.valueOf(chHeure);
		else 
			heure = String.valueOf(chHeure);
		
		String minutes;
		if(chMinutes < 10)
			minutes = "0" + String.valueOf(chMinutes);
		else 
			minutes = String.valueOf(chMinutes);
		
		return heure + ":" + minutes;
	}
	
	/**
	 * Compare les heures d'un horaire avec celles du this.
	 * @param parHoraire, l'horaire à comparer avec l'horaire du this
	 * @return 0 si égales,1 si différentes
	 */
	public int compareToHeure(Horaire parHoraire) {
		if(chHeure == parHoraire.chHeure) 
			return 0;	
		return 1;
	}
	/**
	 * Renvoie l'attribut heure du this.
	 * @return chHeure
	 */
	public int getHeure() {
		return chHeure;
	}

	/**
	 * Renvoie l'attribut minutes du this.
	 * @return chMinutes
	 */
	public int getMinutes() {
		return chMinutes;
	}
}
