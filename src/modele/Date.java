package modele;
import java.io.Serializable;
import java.util.GregorianCalendar;
import constantes.Constantes;
import java.util.Calendar;
 
/**
 * Classe Date permet la création d'objets Date qui stockent une date.
 * Elle fait partie du package modele.
 * @author Arthur Pellegrini
 * @see java.io.Serializable
 * @see java.util.Calendar
 * @see java.util.GregorianCalendar
 * @see java.io.Serializable
 */
public class Date implements Comparable <Date>,Constantes,Serializable{
	private static final long serialVersionUID = -6921412295827048319L;
	/**
	 * Private Attibut jour de type int. Stocke le numéro du jour. 
	 */
	private int jour;
	/**
	 * Private Attibut mois de type int. Stocke le numéro du mois.
	 */
	private int mois;
	/**
	 * Private Attibut annee de type int. Stocke le numéro de l'année.
	 */
	private int annee;
	/**
	 * Private Attibut jourSemaine de type int. Stocke le numéro du jour de la semaine.
	 */
	private int jourSemaine;
	/**
	 * Private Attibut numeroSemaine de type int. Stocke le numéro de la semaine de l'année dans laquelle se trouve la date.
	 */
	private int numeroSemaine;
  
	/**
   	* Constructeur sans paramètres de la classe Date, permet de créer une date correspondante à la date du système.
   	* @see java.util.GregorianCalendar
   	*/
	public Date ()   { 
	  	GregorianCalendar dateAuj = new GregorianCalendar ();
	  	annee = dateAuj.get (Calendar.YEAR);
	  	mois = dateAuj.get (Calendar.MONTH) + 1; 
	  	jour = dateAuj.get (Calendar.DAY_OF_MONTH);
	  	jourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
	  	if (jourSemaine == 1)
		  	jourSemaine = 7;
	  	else jourSemaine -= 1; 
	  	numeroSemaine = dateAuj.get(Calendar.WEEK_OF_YEAR);
  	}
  
	/**
   	* Constructeur avec paramètres de la classe Date,permet de créer une date correspondant aux paramètres fournis.
   	* @see java.util.GregorianCalendar
   	* @param parJour : int
   	* @param parMois : int
   	* @param parAnnee : int
   	*/
  	public Date (int parJour, int parMois, int parAnnee)   {   
  		jour = parJour;
		mois = parMois;
		annee = parAnnee; 
		GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);
		jourSemaine = date.get (Calendar.DAY_OF_WEEK);		
		if (jourSemaine == 1)
			jourSemaine = 7;
		else jourSemaine -= 1;
		numeroSemaine = date.get(Calendar.WEEK_OF_YEAR);
  	}
  
  	/**
   	* Donne la date du premier jour de la semaine du this.
   	* @return date : Date 
   	*/
  	public Date datePremierJourSemaine() {
  		int compteur = this.getJourSemaine() -1;
		
		if((this.getJour() - compteur) > 1)
			return new Date(this.getJour() - compteur,this.getMois(),this.getAnnee());
		
		else if (this.getMois() > 1)
			return new Date(this.getJour() - compteur + dernierJourDuMois(this.getMois() - 1,this.getAnnee()),this.getMois() - 1,this.getAnnee());
		
		else return new Date(this.getJour() - compteur + dernierJourDuMois(12,this.getAnnee()-1),12,this.getAnnee() - 1);
  	}
   
  	/**
  	* Compare this et parDate
  	* @param parDate : Date
   	* @return 0 si this et parDate sont égales, -1 si this précède parDate, 1 si parDate précède this
   	*/
  	public int compareTo (Date parDate) {
  		if (annee < parDate.annee)
  			return -1;
  		if (annee > parDate.annee)
  			return 1;
  		// les années sont =
  		if (mois < parDate.mois)
  			return -1;
  		if (mois > parDate.mois)
  			return 1;
  		// les mois sont =
  		if (jour < parDate.jour)
  			return -1;
  		if (jour > parDate.jour)
  			return 1;
  		return 0;	
  	}
 
  	/**
   	* Renvoie la date du lendemain de la date du this.
   	* @return date : Date
   	*/
  	public Date dateDuLendemain ()   {	
  		if (jour < dernierJourDuMois(mois,annee))
		    return  new Date (jour+1,mois,annee);
		else if (mois < 12)
			return new Date (1,mois+1,annee);
		else return new Date (1,1,annee+1);	
  	}  
  
  	/**
   	* Renvoie la date de la veille de la date du this.
   	* @return date : Date
   	*/
  	public Date dateDeLaVeille () {    
  		if (jour > 1)
			return  new Date (jour-1,mois,annee);
		else if (mois > 1)
			return new Date (Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
		else return  new Date (31,12,annee-1);
  	}	 
  
  	/**
   	* Permet de connaître le numéro du dernier jour d'un mois.
   	* @param parMois : int
   	* @param parAnnee : int
   	* @return 29 si Février et année bissextile, 28 si Février mais année non-bissextile, 30 si Avril,Juin,Septembre ou Novembre, 31 pour tout les autres mois
   	*/
  	public static int dernierJourDuMois (int parMois, int parAnnee) {
  		switch (parMois) {
			case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
			case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
			default : return 31 ;
		}// switch
	} 
	 
  	/**
   	* Permet de savoir si l'année de la date du this est bissextile
   	* @param parAnnee : int
   	* @return true si l'année est bissextile
   	* @return false si l'année n'est pas bissextile
   	*/
  	private static boolean estBissextile(int parAnnee) {
		return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	}
    
  	/**
  	 * Permet de savoir si la date du this est la même que celle du système.
  	 * @return true si la date du this est celle du système,false si la date du this n'est pas celle du système
  	 */
	public boolean isToday() {
		return new Date().compareTo(this) == 0;
	}
  	
  	/**
   	* Permet de convertir une date en un objet de type String
   	* @return un objet de type String
   	*/
  	public String toString () {
  		return  JOURS_SEMAINE [jourSemaine -1] + " " + jour + " " + MOIS [mois-1];	  
  	} 
  	
  	/**
   	* Permet d'obtenir un numéro de mois avec un 0 avant pour les mois de janvier à septembre.
   	* @return un objet de type String
   	*/
  	public String getStringMois() {
		if(mois<10) 
			return "0" + mois;
		else 
			return "" + mois;
	}

  	/**
   	* Permet de connaitre le numéro du jour du this.
   	* @return jour : int
   	*/
	public int getJour() { 
		return jour;
	}

	/**
   	* Permet de connaitre le numéro du mois du this.
   	* @return mois : int
   	*/
	public int getMois() { 
		return mois;
	}
	
	/**
   	* Permet de connaitre le numéro de l'année du this.
   	* @return annee : int
   	*/
  	public int getAnnee() { 
		return annee;
	}

  	/**
   	* Permet de connaitre le numéro du jour de la semaine du this.
   	* @return jourSemaine : int
   	*/
	public int getJourSemaine () {
		return jourSemaine;
	}

	/**
   	* Permet de connaitre le numéro de la semaine de la date du this.
   	* @return numeroSemaine : int
   	*/
	public int getNumeroSemaine() {
		return numeroSemaine;
	}
}// class Date