/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro.source.Algo.Echange.EchangeSuccesseurs;

import java.util.ArrayList;
import java.util.Collections;
import tp_ro.source.Ville;
import tp_ro.source.Algo.Algo;
import tp_ro.source.Algo.AlgoPlusProcheVoisin;
import tp_ro.source.Tour;

/**
 *
 * @author lm178867
 */
public class AlgoEchangeSuccesseurs_P implements Algo{

    private ArrayList<Ville> listeVille;
    private String type;
    
    public AlgoEchangeSuccesseurs_P(ArrayList<Ville> listeVille){
        this.listeVille = listeVille;
        this.type = "échange de succeseurs (premier d'abord)";
    }
    
    @Override
    public Tour execute() {
        ArrayList<Ville> listeVillePlusProcheVoisin = new ArrayList(listeVille);
        AlgoPlusProcheVoisin APPV = new AlgoPlusProcheVoisin(listeVillePlusProcheVoisin);
        Tour tourPlusProcheVoisin = APPV.execute();
        Tour T_entree = new Tour(tourPlusProcheVoisin.getListeTournee(), this.type);
        Tour T_sortie = recherche_locale(T_entree);
        
        return T_sortie;
    }
    
    
    public Tour recherche_locale(Tour T_entree){
        Tour Tcourante = new Tour(T_entree.getListeTournee(), T_entree.getType());
        boolean fini = false;
        boolean trouver = false;
        
        while(fini == false){
            fini = true;
            trouver = false;
            //Explorer voisinage de Tcourante
            Tour Tvoisin = new Tour(Tcourante.getListeTournee(), Tcourante.getType());
            for (int i = 0; i < Tcourante.getListeTournee().size() && !trouver; i++){
                Tvoisin = Echanger(Tcourante,i, (i+1)%Tcourante.getListeTournee().size());
            
               // System.out.println(Tvoisin.getListeTournee());
                if(Tvoisin.calculerCout() < Tcourante.calculerCout()){
                    Tcourante = new Tour(Tvoisin.getListeTournee(), Tvoisin.getType());
                    fini = false;
                    trouver = true;
                }
            }
        }
        
        return Tcourante;
    }
    
    
    public Tour Echanger(Tour T, int id1, int id2){
        ArrayList<Ville> lv = new ArrayList<>(T.getListeTournee());
        Collections.swap(lv,id1,id2);
        Tour T2 = new Tour(lv, type);
        
        //System.out.println("T2 = " +  T2.getListeTournee());
        
        return T2;
    }
    
    
}
