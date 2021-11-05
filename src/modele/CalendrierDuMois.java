package modele;

import java.util.TreeSet;
import java.util.Collection;

/**
 * La classe CalendrierDuMois fournit un ensemble de dates correspondantes au mois et � l'ann�e demand�s.
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
   * Constructeur avec param�tre de la classe CalendrierDuMois.
   * Cr�e un objet CalendrierDuMois qui contient la liste des dates du mois et de l'ann�e donn�s en param�tres.  
   * @param mois, le mois de la date qui sera cr�e
   * @param annee, l'ann�e de la date qui sera cr�e
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
   * Renvoie une collection de dates correspondantes � un mois et une ann�e. 
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