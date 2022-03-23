/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro.source.Algo.Echange.EchangeSommetsQuelconques;

import java.util.ArrayList;
import java.util.Collections;
import tp_ro.source.Algo.Algo;
import tp_ro.source.Algo.AlgoPlusProcheVoisin;
import tp_ro.source.Tour;
import tp_ro.source.Ville;

/**
 *
 * @author lucas
 */
public class AlgoEchangeSommetsQuelconques_M implements Algo{
    private ArrayList<Ville> listeVille;
    private String type;
    
    public AlgoEchangeSommetsQuelconques_M(ArrayList<Ville> listeVille){
        this.listeVille = listeVille;
        this.type = "échange de sommets quelconques (meilleur d'abord)";
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
        
        while(fini == false){
            fini = true;
            //Explorer voisinage de Tcourante
            Tour Tvoisin = new Tour(Tcourante.getListeTournee(), Tcourante.getType());
            for (int i = 0; i < Tcourante.getListeTournee().size(); i++){
                for (int j = 0; j < Tcourante.getListeTournee().size() ; j++){
                    Tvoisin = Echanger(Tcourante,i, j);
            
                    // System.out.println(Tvoisin.getListeTournee());
                    if(Tvoisin.calculerCout() < Tcourante.calculerCout()){
                        Tcourante = new Tour(Tvoisin.getListeTournee(), Tvoisin.getType());
                        fini = false;
                    }   
                }
                
            }
        }
        
        return Tcourante;
    }
    
    
    public Tour Echanger(Tour T, int id1, int id2){
        ArrayList<Ville> lv = new ArrayList<>(T.getListeTournee());
        Collections.swap(lv,id1,id2);
        Tour T2 = new Tour(lv, type);
        
        return T2;
    }
    
    

}
