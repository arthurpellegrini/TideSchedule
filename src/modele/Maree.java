package modele;

import java.io.Serializable;

/**
 * Classe Maree, permet de cr�er des objets permettant de qualifier une mar�e.
 * Elle fait partie du package modele.
 * @author Arthur Pellegrini
 * @see java.io.Serializable
 */
public class Maree implements Serializable {
	private static final long serialVersionUID = 958730170055637668L;
	/**
	 * Attribut priv� de type Date, stocke la date d'une mar�e
	 */
	private Date chDate;
	/**
	 * Attribut priv� de type Horaire, stocke l'horaire de la mar�e
	 */
	private Horaire chHoraire;
	/**
	 * Attribut priv� de type float, stocke la hauteur d'eau d'une mar�e
	 */
	private float chHauteur;
	/**
	 * Attribut priv� de type int, stocke le coefficient d'une mar�e
	 */
	private int chCoefficient;
	/**
	 * Attribut priv� de type String, stocke le type de mar�e (soit PM soit BM)
	 */
	private String chTypeMaree;
	
	/**
	 * Constructeur avec param�tres de la classe Maree, permet de cr�er un objet de la classe Mar�e.
	 * @param parDate, la date de la mar�e
	 * @param parHoraire, l'horaire de la mar�e dans la journ�e
	 * @param parHauteur, la hauteur d'eau de la mar�e
	 * @param parCoefficient, le coefficient de la mar�e
	 * @param parTypeMaree, le type de la mar�e 
	 */
	public Maree(Date parDate,Horaire parHoraire, float parHauteur, int parCoefficient, String parTypeMaree) {
		chDate = parDate;
		chHoraire = parHoraire;
		chHauteur = parHauteur;
		chCoefficient = parCoefficient;
		chTypeMaree = parTypeMaree; //Soit PM soit BM
	}
	
	/**
	 * Permet de convertir un objet mar�e en un objet de type String.
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
	 * @param parTypeMaree, le type de mar�e qui remplacera celui du this
	 */
	public void setTypeMaree(String parTypeMaree) {
		chTypeMaree = parTypeMaree;
	}
}//class
