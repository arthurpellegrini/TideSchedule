package modele;

import java.io.Serializable;

/**
 * Classe Maree, permet de créer des objets permettant de qualifier une marée.
 * Elle fait partie du package modele.
 * @author Arthur Pellegrini
 * @see java.io.Serializable
 */
public class Maree implements Serializable {
	private static final long serialVersionUID = 958730170055637668L;
	/**
	 * Attribut privé de type Date, stocke la date d'une marée
	 */
	private Date chDate;
	/**
	 * Attribut privé de type Horaire, stocke l'horaire de la marée
	 */
	private Horaire chHoraire;
	/**
	 * Attribut privé de type float, stocke la hauteur d'eau d'une marée
	 */
	private float chHauteur;
	/**
	 * Attribut privé de type int, stocke le coefficient d'une marée
	 */
	private int chCoefficient;
	/**
	 * Attribut privé de type String, stocke le type de marée (soit PM soit BM)
	 */
	private String chTypeMaree;
	
	/**
	 * Constructeur avec paramètres de la classe Maree, permet de créer un objet de la classe Marée.
	 * @param parDate, la date de la marée
	 * @param parHoraire, l'horaire de la marée dans la journée
	 * @param parHauteur, la hauteur d'eau de la marée
	 * @param parCoefficient, le coefficient de la marée
	 * @param parTypeMaree, le type de la marée 
	 */
	public Maree(Date parDate,Horaire parHoraire, float parHauteur, int parCoefficient, String parTypeMaree) {
		chDate = parDate;
		chHoraire = parHoraire;
		chHauteur = parHauteur;
		chCoefficient = parCoefficient;
		chTypeMaree = parTypeMaree; //Soit PM soit BM
	}
	
	/**
	 * Permet de convertir un objet marée en un objet de type String.
	 */
	public String toString() {
		return chDate.toString() + " & " + chHoraire.toString() + " & " + chHauteur + "m & " + chCoefficient + " & " + chTypeMaree + "\n";
	}

	/**
	 * Renvoie l'attribut Date de this.
	 * @return chDate
	 */
	public Date getDate() {
		return chDate;
	}
	
	/**
	 * Modifie la date du this.
	 * @param parDate, la date qui remplacera la date du this
	 */
	public void setDate(Date parDate) {
		chDate = parDate;
	}
	
	/**
	 * Renvoie l'attribut Horaire de this.
	 * @return chHoraire
	 */
	public Horaire getHoraire() {
		return chHoraire;
	}
	
	/**
	 * Modifie l'Horaire du this.
	 * @param parHoraire, l'horaire qui remplacera l'horaire du this
	 */
	public void setHoraire(Horaire parHoraire) {
		chHoraire = parHoraire;
	}
	
	/**
	 * Renvoie l'attribut Hauteur de this.
	 * @return chHauteur
	 */
	public float getHauteur() {
		return chHauteur;
	}
	
	/**
	 * Modifie la Hauteur du this.
	 * @param parHauteur, l'Hauteur qui remplacera l'Hauteur du this
	 */
	public void setHauteur(float parHauteur) {
		chHauteur = parHauteur;
	}
	
	/**
	 * Renvoie l'attribut Coefficient de this.
	 * @return chCoefficient
	 */
	public int getCoefficient() {
		return chCoefficient;
	}
	
	/**
	 * Modifie le coefficient du this.
	 * @param parCoefficient, le coefficient qui remplacera le coefficient du this
	 */
	public void setCoefficient(int parCoefficient) {
		chCoefficient = parCoefficient;
	}
	
	/**
	 * Renvoie l'attribut TypeMaree de this.
	 * @return chTypeMaree
	 */
	public String getTypeMaree() {
		return chTypeMaree;
	}
	
	/**
	 * Modifie le TypeMaree du this.
	 * @param parTypeMaree, le type de marée qui remplacera celui du this
	 */
	public void setTypeMaree(String parTypeMaree) {
		chTypeMaree = parTypeMaree;
	}
}//class
