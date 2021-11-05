package modele;

import java.util.TreeSet;
import java.util.Collection;

/**
 * La classe CalendrierDuMois fournit un ensemble de dates correspondantes au mois et à l'année demandés.
 * Elle fait partie du package modele.
 * @author Arthur Pellegrini
 * @see java.util.TreeSet
 * @see java.util.Collection
 */
public class CalendrierDuMois {	
	/**
	 * Attribut de la classe CalendrierDuMois
	 * Private Collection contenant des dates. 
	 */
  private Collection <Date> treeSetDate;	  
  
  /**
   * Constructeur avec paramètre de la classe CalendrierDuMois.
   * Crée un objet CalendrierDuMois qui contient la liste des dates du mois et de l'année donnés en paramètres.  
   * @param mois, le mois de la date qui sera crée
   * @param annee, l'année de la date qui sera crée
   */
  public CalendrierDuMois ( int mois, int annee) {			   
	    treeSetDate = new TreeSet <Date> ();
	    Date date = new Date (1,mois,annee);
	    int indiceJour = date.getJourSemaine() ;
	    for (int x = indiceJour ; x!=0 ; x--) {	    	 
	    	treeSetDate.add(date);	    	
	    	date = date.dateDeLaVeille();
	    }	    
	    date = new Date (2,mois,annee);
	    indiceJour = indiceJour % 7 ;
	    while (date.getMois () == mois) {
	      while(indiceJour<7) {
	    	treeSetDate.add(date);
	    	date = date.dateDuLendemain();
	    	indiceJour++ ;
	      } 
	      indiceJour=0;
	    }    
	  }
  
  /**
   * Renvoie une collection de dates correspondantes à un mois et une année. 
   * @return treeSetDate
   */
  public Collection <Date> getDates() {	
	  return treeSetDate;	
  }	

  /**
   * Permet de convertir l'attribut treeSetDate en String. 
   * @return treeSetDate.toString()
   */
  public String toString () {
	  return treeSetDate.toString();
  }  
}