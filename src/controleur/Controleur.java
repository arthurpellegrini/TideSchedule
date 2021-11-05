package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import constantes.*;
import modele.Date;
import modele.HauteurEau;
import modele.Maree;
import modele.MareesUnJour;
import outils.LectureEcriture;
import outils.LectureFichierTxt;
import vue.*;

/**
 * Classe Controleur, permet de gérer les conséquences des actions de l'utilisateur.
 * @author apellegr
 * @see java.awt.event
 * @see java.util
 * @see java.io
 */
public class Controleur implements ActionListener, Constantes, ConstantesInterface {
	private PanelAffichageMarees chPanelAffichage;
	private PanelCalendrier chPanelCalendrier;
	private PanelTableHauteurEau chPanelTableHauteurEau;
	private BoutonDate chBouton;
	private Date chDateCourante = new Date();
	private String chPortCourant = "";
	private ArrayList<Maree> chListeMareesUnJour;
	private ArrayList<HauteurEau> chListeHauteurMareesUnJour;
	private int index = 0;

	
	/** Contructeur de la classe Controleur.
	 * @param parPanelAffichageMarees de type PanelAffichageMarees 
	 * @param parPanelCalendrier de type PanelCalendrier
	 * @param parPanelTableHauteurEau de type PanelTableHauteurEau
	 */
	public Controleur (PanelAffichageMarees parPanelAffichageMarees, PanelCalendrier parPanelCalendrier, PanelTableHauteurEau parPanelTableHauteurEau) {
			chPanelAffichage = parPanelAffichageMarees;
			chPanelCalendrier = parPanelCalendrier;
			chPanelTableHauteurEau = parPanelTableHauteurEau;
			chPanelAffichage.getPanelFormulaire().enregistreEcouteur(this);
			chPanelCalendrier.enregistreEcouteur(this);
	}
	
	/** Gère les conséquences des actions de l'utilisateur.
	 * @param parEvt, l'évenement effectué par l'utilisateur
	 */
	public void actionPerformed(ActionEvent parEvt) {
		if (parEvt.getActionCommand().equals(INTITULE_BOUTON_SELECTIONNE) == true) {
			chPortCourant = chPanelAffichage.getPanelFormulaire().getPort();
			}
		else {
			if (index != 0) {
				if(chDateCourante.isToday())
					chBouton.setBackground(ORANGE);
				else
					chBouton.setBackground(GRIS_FONCE);
			}
			chBouton = (BoutonDate) parEvt.getSource();
			chBouton.setBackground(ROUGE);
			
			chPortCourant = chPanelAffichage.getPanelFormulaire().getPort();
			chDateCourante = chBouton.getDate();
			chPanelAffichage.getPanelFormulaire().setDate(chDateCourante);
			
			index ++;
		}
		
		//Hauteur Eau fichier SER
		File fichierSerMarees = new File("data"+ File.separator + "ser" + File.separator + chDateCourante.getStringMois() + "_"+ chPortCourant.toLowerCase() + ".ser");
		
		if(fichierSerMarees.exists() != true) {
			try {
				fichierSerMarees.createNewFile();
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
			LectureEcriture.ecriture(fichierSerMarees,LectureFichierTxt.lectureMareesDuMois(new File("data" + File.separator + "annuaire_marees" 
	    			+ File.separator + chDateCourante.getStringMois() + "-" + chPortCourant.replaceAll(" ", "_").toUpperCase() + "_2021.txt")));
			}
		@SuppressWarnings("unchecked")
		ArrayList<MareesUnJour> listeMareesDuMois = (ArrayList<MareesUnJour>) LectureEcriture.lecture(fichierSerMarees);
		chListeMareesUnJour = LectureFichierTxt.getMareeDuJour(listeMareesDuMois,chDateCourante);	
		
		//Hauteur Eau fichier SER
		File fichierSerHauteurEau = new File("data"+ File.separator + "ser" + File.separator + chPortCourant.toLowerCase() + ".ser");
		
		if(fichierSerHauteurEau.exists() != true) {
			try {
				fichierSerHauteurEau.createNewFile();
				} 
			catch (IOException e) {
				e.printStackTrace();
				}
			LectureEcriture.ecriture(fichierSerHauteurEau,LectureFichierTxt.lectureHauteurEau(new File("data" + File.separator + "hauteur_eau" + File.separator 
	    			+ chPortCourant.replaceAll(" ", "_").toUpperCase() + ".txt")));	
			}
		@SuppressWarnings("unchecked")
		TreeMap<Date, ArrayList <HauteurEau>> treeMapHauteurMaree = (TreeMap<Date, ArrayList <HauteurEau>>) LectureEcriture.lecture(fichierSerHauteurEau);
		chListeHauteurMareesUnJour = treeMapHauteurMaree.get(chDateCourante);
		
		chPanelAffichage.getPanelTableMarees().setModelTableMarees(chListeMareesUnJour);
		chPanelTableHauteurEau.setModelTableHauteurEau(chListeHauteurMareesUnJour);	
	}//actionPerformed(Evenement parEvt)
}