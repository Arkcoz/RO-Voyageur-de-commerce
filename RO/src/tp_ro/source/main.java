/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro.source;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import tp_ro.source.Algo.AlgoAleatoire;
import tp_ro.source.Algo.AlgoCroissant;
import tp_ro.source.Algo.Echange.EchangeSuccesseurs.AlgoEchangeSuccesseurs_M;
import tp_ro.source.Algo.Echange.EchangeSuccesseurs.AlgoEchangeSuccesseurs_P;
import tp_ro.source.Algo.Insertion.AlgoInsertionLoin;
import tp_ro.source.Algo.Insertion.AlgoInsertionProche;
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
        
        
        //Croissant
        System.out.println("");
        ArrayList<Ville> listeVilleCroissant = new ArrayList(listeVille);
        AlgoCroissant AC = new AlgoCroissant(listeVilleCroissant);
        Tour tourCroissant = AC.execute();
        tourCroissant.afficherInformations();
        
        
        //Aléatoire
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVilleAleatoire = new ArrayList(listeVille);
        AlgoAleatoire AA = new AlgoAleatoire(listeVilleAleatoire);
        Tour tourAleatoire = AA.execute();
        tourAleatoire.afficherInformations();
        
        
        //Plus proche voisin
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVillePlusProcheVoisin = new ArrayList(listeVille);
        AlgoPlusProcheVoisin APPV = new AlgoPlusProcheVoisin(listeVillePlusProcheVoisin);
        Tour tourPlusProcheVoisin = APPV.execute();
        tourPlusProcheVoisin.afficherInformations();
        
        
        //Insertion proche
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVilleInsertionProche = new ArrayList(listeVille);
        AlgoInsertionProche AIP = new AlgoInsertionProche(listeVilleInsertionProche);
        Tour tourInsertionProche = AIP.execute();
        tourInsertionProche.afficherInformations();
        
        
        
        //Insertion loin
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVilleInsertionLoin = new ArrayList(listeVille);
        AlgoInsertionLoin AIL = new AlgoInsertionLoin(listeVilleInsertionLoin);
        Tour tourInsertionLoin = AIL.execute();
        tourInsertionLoin.afficherInformations();
        
        //Échange de successeurs : premier d'abord
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVilleEchangeSuccesseurs_P = new ArrayList(listeVille);
        AlgoEchangeSuccesseurs_P AES_P = new AlgoEchangeSuccesseurs_P(listeVilleEchangeSuccesseurs_P);
        Tour tourEchangeSuccesseur_P = AES_P.execute();
        tourEchangeSuccesseur_P.afficherInformations();
        
        //Échange de successeurs : meilleur d'abord
        System.out.println("-------------------------------------------------------------------------------------------------------");
        ArrayList<Ville> listeVilleEchangeSuccesseurs_M = new ArrayList(listeVille);
        AlgoEchangeSuccesseurs_M AES_M = new AlgoEchangeSuccesseurs_M(listeVilleEchangeSuccesseurs_M);
        Tour tourEchangeSuccesseur_M = AES_M.execute();
        tourEchangeSuccesseur_M.afficherInformations();
        

    }
    
}
