package modele;

import java.io.Serializable;

/**
 * Classe HauteurEau, permet de créer des objets contenant la hauteur d'eau en fonction d'un horaire.
 * Elle fait partie du package modele.
 * @author Arthur Pellegrini
 * @see java.io.Serializable
 */
public class HauteurEau implements Serializable{
	private static final long serialVersionUID = 7416211349440403679L;
	/**
	 * Attribut privé de type Horaire, stocke l'horaire à laquelle à été relevé la hauteur d'eau
	 */
	private Horaire chHoraire; 
	/**
	 * Attribut privé de type float, stocke la valeur de la hauteur de l'eau.
	 */
	private float chHauteur;
	
	/**
	 * Constructeur de la classe HauteurEau, permet de créer un objet de la classe HauteurEau.
	 * @param parHauteur : float
	 * @param parHoraire : Horaire
	 */
	public HauteurEau(float parHauteur,Horaire parHoraire) {
		chHoraire = new Horaire(parHoraire.getHeure(),parHoraire.getMinutes());
		chHauteur = parHauteur;	
	}
	
	/**
	 * Permet de convertir this en objet de type String
	 * @return heure:minutes et la hauteur en mètres
	 */
	public String toString() {
		return chHoraire + " & " + chHauteur + "m";
	}
	
	/**
	 * Permet d'obtenir l'attribut Horaire du this.
	 * @return l'attribut Horaire
	 */
	public Horaire getHoraire() {
		return chHoraire;
	}
	/**
	 * Permet d'obtenir l'attribut Hauteur du this.
	 * @return l'attribut Hauteur
	 */
	public float getHauteur() {
		return chHauteur;
	}
}