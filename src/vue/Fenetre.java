package vue;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import constantes.*;
import controleur.Controleur;
import modele.Date;

/**
 * Classe Fenetre, c'est la classe principale, elle contient le main. Mais elle permet aussi d'appeler toutes les autres fonctions pour faire fonctionner le programme.
 * @author Arthur Pellegrini
 * @see java.awt.GridLayout
 * @see javax.swing
 */
public class Fenetre extends JFrame implements ConstantesInterface, Constantes {
	private static final long serialVersionUID = 5713084436146948003L;
	
	/**
	 * Constructeur de la classe Fenetre
	 */
    public Fenetre() {
        super("Horaires des marées");
        PanelCalendrier panelCalendrier = new PanelCalendrier();
        PanelAffichageMarees panelAffichage = new PanelAffichageMarees();
        PanelTableHauteurEau panelTableHauteurEau = new PanelTableHauteurEau(PORTS[0],new Date());
        panelTableHauteurEau.setLayout(new GridLayout());
        
        //Création des onglest
        JTabbedPane onglets = new JTabbedPane();
        onglets.setFont(US_14);
        onglets.setBackground(BLEU);
        onglets.setBounds(40,20,300,300);
        onglets.add("Calendrier", panelCalendrier);
        onglets.add("Marées du Jour", panelAffichage);
        onglets.add("Hauteur d'eau heure par heure", panelTableHauteurEau);
        add(onglets);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(HORIZONTAL,VERTICAL); setResizable(RESIZABLE); 
        setVisible(true); setLocation (POSX,POSY);
        setBackground (BLANC);
      
        new Controleur(panelAffichage, panelCalendrier, panelTableHauteurEau);
    }

    /**
     * Méthode Main, elle permet de lancer le programme.
     * @param args, les arguments pris lors du lancement du main
     */
    public static void main (String  [] args) {  	
        new Fenetre();
    }
}
