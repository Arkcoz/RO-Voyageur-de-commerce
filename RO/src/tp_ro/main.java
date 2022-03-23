/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import tp_ro.source.Algo.AlgoAleatoire;
import tp_ro.source.Algo.AlgoCroissant;
import tp_ro.source.Algo.AlgoInsertionLoin;
import tp_ro.source.Algo.AlgoInsertionProche;
import tp_ro.source.Algo.AlgoPlusProcheVoisin;
import tp_ro.source.Tour;

/**
 *
 * @author lucas
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        ListeVille lv = new ListeVille();
        ArrayList<Ville> listeVille = lv.getListeVille();
        
        
        Ville ville1 = listeVille.get(0);
        Ville ville2 = listeVille.get(1);
        
        
        //Création et affichage du tour croissant
        System.out.println("");
        ArrayList<Ville> listeVilleCroissant = new ArrayList(listeVille);
        AlgoCroissant AC = new AlgoCroissant(listeVilleCroissant);
        Tour tourCroissant = AC.execute();
        tourCroissant.afficherInformations();
        
        
        //Création et affichage du tour aléatoire
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVilleAleatoire = new ArrayList(listeVille);
        AlgoAleatoire AA = new AlgoAleatoire(listeVilleAleatoire);
        Tour tourAleatoire = AA.execute();
        tourAleatoire.afficherInformations();
        
        
        //Création et affichage du tour PPV
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVillePlusProcheVoisin = new ArrayList(listeVille);
        AlgoPlusProcheVoisin APPV = new AlgoPlusProcheVoisin(listeVillePlusProcheVoisin);
        Tour tourPlusProcheVoisin = APPV.execute();
        tourPlusProcheVoisin.afficherInformations();
        
        
        //Création et affichage du tour insertion proche
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVilleInsertionProche = new ArrayList(listeVille);
        AlgoInsertionProche AIP = new AlgoInsertionProche(listeVilleInsertionProche);
        Tour tourInsertionProche = AIP.execute();
        tourInsertionProche.afficherInformations();
        
        
        
        //Création et affichage du tour insertion loin
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVilleInsertionLoin = new ArrayList(listeVille);
        AlgoInsertionLoin AIL = new AlgoInsertionLoin(listeVilleInsertionLoin);
        Tour tourInsertionLoin = AIL.execute();
        tourInsertionLoin.afficherInformations();
        

    }
    
}
