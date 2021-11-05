package outils;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
import constantes.*;
import modele.*;
 
/**
 * Classe LectureFichierTxt, permet la lecture de fichiers txt pour pouvoir récupérer des données.
 * @author Arthur Pellegrini / Antoine Gache
 * @see java.io
 * @see java.util
 */
public class LectureFichierTxt implements Constantes{
	/**
	 * Attribut permettant la lecture des fichiers txt.
	 */
	private static BufferedReader buffer;

	/**
	 * Lit le contenu d'un fichier pour l'afficher dans le terminal.
	 * @param parfichier, le fichier qui sera lu
	 */
	public static void lecture (File parfichier) {
		try { 
			buffer = new BufferedReader(new InputStreamReader (new FileInputStream (parfichier)));
				String ligneLue ;
				while ((ligneLue = buffer.readLine()) != null) {
						StringTokenizer decoup = new StringTokenizer(ligneLue,"\t");
						while (decoup.hasMoreTokens()) {
							String token = decoup.nextToken();
							System.out.print (token + " & ");
						}
						System.out.println ();
				}	
		} // try
		catch (IOException parException) { 
			System.err.println(parException);
		}
	}
	
	/**
	 * Lit le contenu dans un fichier puis le renvoie dans une ArrayList.
	 * @param parfichier, le fichier qui sera lu
	 * @return ArrayList qui contient des objets de la classe MareesUnJour
	 */
	public static ArrayList<MareesUnJour> lectureMareesDuMois(File parfichier) {
		ArrayList<MareesUnJour> listeMareesDuMois = new ArrayList<MareesUnJour>();
		try { 
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream(parfichier)));
			String ligneLue ; 
			int ligne = 1 ;
			while ((ligneLue = buffer.readLine()) != null) {
				if(ligne >= 5) {
					StringTokenizer decoup = new StringTokenizer(ligneLue,"\t");
					String[] dateDuJour = decoup.nextToken().split("-");
					Date date = new Date(Integer.valueOf(dateDuJour[2]),Integer.valueOf(dateDuJour[1]),Integer.valueOf(dateDuJour[0]));
					Maree[] listeMarees = new Maree[4];
					
					for(int i = 0; i<4; i++) {
						Horaire horaire;
						float hauteur;
						int coefficient = 0;	
						String typeMaree = " ";
						String[] horaireMaree = decoup.nextToken().split(":");
						
						if(horaireMaree[0].equals("--")) {
							horaire = new Horaire(0,0);
							hauteur = 0;
							int n;
							if(i<2) {
								n = 2;
								typeMaree = "PM";
							}
							else {
								n = 1;
								typeMaree = "BM";
							}
							for(int y = 0; y<n;y++)
								decoup.nextToken();
						}
						else {
							horaire = new Horaire(Integer.valueOf(horaireMaree[0]),Integer.valueOf(horaireMaree[1]));
							hauteur = Float.valueOf(decoup.nextToken());
							if(i <2) {
								coefficient = Integer.valueOf(decoup.nextToken());
								typeMaree = "PM";
							}
							else 
								typeMaree = "BM";
						}
						Maree maree = new Maree(date,horaire,hauteur,coefficient,typeMaree);
						listeMarees[i] = maree;
					}	
					listeMareesDuMois.add(new MareesUnJour(listeMarees[0],listeMarees[1],listeMarees[2],listeMarees[3]));
				}
				ligne++;	
			}
		} // try
		catch (IOException parException) { 
			System.err.println("Le fichier n'existe pas -->" + parException);
		}
		return listeMareesDuMois;
	}
	
	/**
	 * Renvoie l'ensemble des marées d'une même journée
	 * @param parPort, le port sélectionné
	 * @param parDate, la date de la journée
	 * @return une ArrayList contenant des objets marées
	 */
	public static ArrayList<Maree> getMareeDuJour(String parPort, Date parDate){
		MareesUnJour mareeDuJour = new MareesUnJour();
    	ArrayList <MareesUnJour> listeMareesDuMois = LectureFichierTxt.lectureMareesDuMois(new File("data" + File.separator + "annuaire_marees" 
    			+ File.separator + parDate.getStringMois() + "-" + parPort.replaceAll(" ", "_").toUpperCase() + "_2021.txt"));
    	
    	for(MareesUnJour mareeUnJour : listeMareesDuMois)
        	for(Maree maree : mareeUnJour.getMareesUnJour())
        		if(maree.getDate().compareTo(parDate) == 0)
        			mareeDuJour = mareeUnJour;
		return mareeDuJour.getMareesUnJour();
	}
	
	/**
	 * Renvoie l'ensemble des marées d'une même journée
	 * @param parListeMareesDuMois, une ArrayList contenant les marées pour un mois
	 * @param parDate, la date de la journée
	 * @return une ArrayList contenant des objets marées
	 */
	public static ArrayList<Maree> getMareeDuJour(ArrayList <MareesUnJour> parListeMareesDuMois, Date parDate){
		MareesUnJour mareeDuJour = new MareesUnJour();
    	
    	for(MareesUnJour mareeUnJour : parListeMareesDuMois)
        	for(Maree maree : mareeUnJour.getMareesUnJour())
        		if(maree.getDate().compareTo(parDate) == 0)
        			mareeDuJour = mareeUnJour;
		return mareeDuJour.getMareesUnJour();
	}

	/**
	 * Lit le contenu dans un fichier puis le renvoie dans une TreeMap.
	 * @param fichier, le fichier qui sera lu
	 * @return TreeMap qui a pour clef une Date et pour valeur une ArrayList contenant des objets de la classe HauteurEau
	 */
	public static TreeMap<Date, ArrayList <HauteurEau>> lectureHauteurEau (File fichier ){
		TreeMap<Date, ArrayList <HauteurEau>> TreeMapHauteurEau = new TreeMap <Date, ArrayList <HauteurEau>> ();
		try { 
			buffer = new BufferedReader (
			new InputStreamReader (new FileInputStream (fichier)));
				
			String ligneLue ; 
			String [] listeTokens = new String[20];
			int index = 0 ;
			int nbrLigne = 0;
			ArrayList <HauteurEau> hauteurEau = new ArrayList<HauteurEau> ();
			Date datePrecedente = null;
			Horaire horairePrecedent = null;
			float hauteur = 0;
					
			while ((ligneLue = buffer.readLine()) != null) {
					StringTokenizer decoup = new StringTokenizer(ligneLue,"\t; ");
					while (decoup.hasMoreTokens()) {
						String token = decoup.nextToken();
						listeTokens [index] = token;
						index ++;
					}
					index = 0;
					nbrLigne ++;
					if(nbrLigne == 15) {
						datePrecedente = creationDate(listeTokens);
						horairePrecedent = creationHoraire(listeTokens);
						hauteur = Float.parseFloat(listeTokens[2]);
						hauteurEau.add(new HauteurEau(hauteur,creationHoraire(listeTokens)));
						}
					
					if (nbrLigne > 15) {
						Date dateSuivante = creationDate(listeTokens);
						Horaire horaireSuivant = creationHoraire(listeTokens);
							
						if(datePrecedente.compareTo(dateSuivante) == 0) {
							if(horairePrecedent.compareToHeure(horaireSuivant) == 1) {
								hauteur = Float.parseFloat(listeTokens[2]);
								hauteurEau.add(new HauteurEau(hauteur,creationHoraire(listeTokens)));
							}
							horairePrecedent = horaireSuivant;	
						}
						else {
							TreeMapHauteurEau.put(datePrecedente, hauteurEau);
							hauteurEau = new ArrayList <HauteurEau> ();
						}
						
						datePrecedente = dateSuivante;
					}		
				}
			} // try
			catch (IOException parException) { 
				System.err.println("Le fichier n'existe pas -->" + parException);
			}
		return TreeMapHauteurEau;
	}
		
	/**
	 * Renvoie la liste des Hauteurs d'eau pour une journée.
	 * @param parPort, le port selectionné
	 * @param parDate, la date selectionnée
	 * @return listeHauteurEau, la liste des hauteur d'eau de la journée
	 */
	public static ArrayList<HauteurEau> getHauteurMaree(String parPort, Date parDate){
		ArrayList<HauteurEau> listeHauteurEau = new ArrayList<HauteurEau>();
    	TreeMap<Date, ArrayList <HauteurEau>> treeMapHauteurEau = lectureHauteurEau(new File("data" + File.separator + "hauteur_eau" + File.separator 
    			+ parPort.replaceAll(" ", "_").toUpperCase() + ".txt"));
        
        for(Date date : treeMapHauteurEau.keySet())
        	if(date.compareTo(parDate) == 0)
        		listeHauteurEau = treeMapHauteurEau.get(date);
        return listeHauteurEau;
	}
	
	/**
	 * Renvoie la liste des Hauteurs d'eau pour une journée.
	 * @param treeMapHauteurEau, a pour clef une date et pour valeur une ArrayList contenant les Hauteurs d'eau de la journée
	 * @param parDate, la date sélectionnée
	 * @return listeHauteurEau, une ArrayList contenant les Hauteurs d'eau de la journée
	 */
	public static ArrayList<HauteurEau> getHauteurMaree(TreeMap<Date, ArrayList <HauteurEau>> treeMapHauteurEau, Date parDate){
		ArrayList<HauteurEau> listeHauteurEau = new ArrayList<HauteurEau>();
        
        for(Date date : treeMapHauteurEau.keySet())
        	if(date.compareTo(parDate) == 0)
        		listeHauteurEau = treeMapHauteurEau.get(date);
        return listeHauteurEau;
	}
	
	/**
	 * Crée une Date à partir d'une ligne lue dans un fichier.
	 * @param parTableau, le tableau contenant les élements d'une ligne
	 * @return Date, objet crée à partir du premier élément du tableau
	 */
	public static Date creationDate(String [] parTableau) {
		String datepassage = parTableau[0];
		String [] dateTableau = datepassage.split("/");
		return new Date(Integer.parseInt(dateTableau[0]),Integer.parseInt(dateTableau[1]),Integer.parseInt(dateTableau[2]));	
	}
	
	/**
	 * Crée un horaire à partir d'une ligne lue dans un fichier.
	 * @param parTableau, le tableau contenant les élements d'une ligne
	 * @return Horaire, objet crée à partir du deuxième élément du tableau
	 */
	public static Horaire creationHoraire(String parTableau[]) {
		String heurePassage = parTableau[1];
		String [] heureTableau = heurePassage.split(":");
		return new Horaire(Integer.parseInt(heureTableau[0]),0);
	}
}
