package constantes;

/**
 * L'interface Constantes fournit des constantes utilisées dans toute l'interface des Horaires de Marées.
 * Elle fait partie du package constantes.
 * @author Arthur Pellegrini
 */
public interface Constantes {
	
	/**
	 * Final tableau de type String qui contient les jours de la semaine.
	 */
	final String [] JOURS_SEMAINE = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"} ; 
	
	/**
	 * Final tableau de type String qui contient les jours de la semaine en abrégé.
	 */
	final String [] JOURS_SEMAINE_ABR = {"Lun","Mar","Mer","Jeu","Ven","Sam","Dim"} ;  
	
	/**
	 * Final tableau de type String qui contient les mois.
	 */
	final  String [] MOIS = {"Janvier", "Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Décembre"};
	
	/**
	 * Final constante de type String qui contient l'intitulé du bouton premier.
	 */
	final String INTIT_PREMIER = "<<";
	
	/**
	 * Final constante de type String qui contient l'intitulé du bouton précédent.
	 */
	final String INTIT_PRECEDENT = "<";
	
	/**
	 * Final constante de type String qui contient l'intitulé du bouton suivant.
	 */
	final String INTIT_SUIVANT = ">";
	
	/**
	 * Final constante de type String qui contient l'intitulé du bouton dernier.
	 */
	final String INTIT_DERNIER = ">>";
	
	/**
	 * Final tableau de type String qui contient l'intitulé de tout les boutons.
	 */
	final  String [] INTITULES_BOUTONS = {INTIT_PREMIER,INTIT_PRECEDENT, INTIT_SUIVANT, INTIT_DERNIER};
	
	/**
	 * Final constante de type String qui contient l'intitulé du bouton Sélectionner.
	 */
	final String INTITULE_BOUTON_SELECTIONNE ="Sélectionner";
	
	/**
	 * Final tableau de type String qui contient le nom de tous les ports.
	 */
	public final String [] PORTS = {"Audierne","Boucau-Bayonne","Brest","Dunkerque","Fort-De-France","Pointe-A-Pitre","Roscoff","Saint-Malo","Saint-Nazaire","Toulon"};
	
	/**
	 * Final tableau de type String qui contient l'entête du tableau des marées.
	 */
	public final String [] ENTETES_MAREES = {"Horaire","Hauteur d'eau","Coefficient","Type"};
	
	/**
	 * Final tableau de type String qui contient l'entête du tableau des hauteurs d'eau.
	 */
	public final String[] ENTETES_HAUTEUR_EAU = {"Horaire","Hauteur d'eau"};
}
