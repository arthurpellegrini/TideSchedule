package constantes;

/**
 * L'interface Constantes fournit des constantes utilis�es dans toute l'interface des Horaires de Mar�es.
 * Elle fait partie du package constantes.
 * @author Arthur Pellegrini
 */
public interface Constantes {
	
	/**
	 * Final tableau de type String qui contient les jours de la semaine.
	 */
	final String [] JOURS_SEMAINE = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"} ; 
	
	/**
	 * Final tableau de type String qui contient les jours de la semaine en abr�g�.
	 */
	final String [] JOURS_SEMAINE_ABR = {"Lun","Mar","Mer","Jeu","Ven","Sam","Dim"} ;  
	
	/**
	 * Final tableau de type String qui contient les mois.
	 */
	final  String [] MOIS = {"Janvier", "F�vrier","Mars","Avril","Mai","Juin","Juillet","Ao�t","Septembre","Octobre","Novembre","D�cembre"};
	
	/**
	 * Final constante de type String qui contient l'intitul� du bouton premier.
	 */
	final String INTIT_PREMIER = "<<";
	
	/**
	 * Final constante de type String qui contient l'intitul� du bouton pr�c�dent.
	 */
	final String INTIT_PRECEDENT = "<";
	
	/**
	 * Final constante de type String qui contient l'intitul� du bouton suivant.
	 */
	final String INTIT_SUIVANT = ">";
	
	/**
	 * Final constante de type String qui contient l'intitul� du bouton dernier.
	 */
	final String INTIT_DERNIER = ">>";
	
	/**
	 * Final tableau de type String qui contient l'intitul� de tout les boutons.
	 */
	final  String [] INTITULES_BOUTONS = {INTIT_PREMIER,INTIT_PRECEDENT, INTIT_SUIVANT, INTIT_DERNIER};
	
	/**
	 * Final constante de type String qui contient l'intitul� du bouton S�lectionner.
	 */
	final String INTITULE_BOUTON_SELECTIONNE ="S�lectionner";
	
	/**
	 * Final tableau de type String qui contient le nom de tous les ports.
	 */
	public final String [] PORTS = {"Audierne","Boucau-Bayonne","Brest","Dunkerque","Fort-De-France","Pointe-A-Pitre","Roscoff","Saint-Malo","Saint-Nazaire","Toulon"};
	
	/**
	 * Final tableau de type String qui contient l'ent�te du tableau des mar�es.
	 */
	public final String [] ENTETES_MAREES = {"Horaire","Hauteur d'eau","Coefficient","Type"};
	
	/**
	 * Final tableau de type String qui contient l'ent�te du tableau des hauteurs d'eau.
	 */
	public final String[] ENTETES_HAUTEUR_EAU = {"Horaire","Hauteur d'eau"};
}
