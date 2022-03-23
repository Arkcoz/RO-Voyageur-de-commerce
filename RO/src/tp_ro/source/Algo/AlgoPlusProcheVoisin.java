/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro.source.Algo;

import java.util.ArrayList;
import tp_ro.Ville;
import tp_ro.source.Tour;

/**
 *
 * @author lm178867
 */
public class AlgoPlusProcheVoisin implements Algo{

    private ArrayList<Ville> villesNonVisites;
    private ArrayList<Ville> villesVisitees;
    private String type;
    
    public AlgoPlusProcheVoisin(ArrayList<Ville> listeVille){
        this.villesVisitees  = new ArrayList<>();
        this.villesNonVisites = listeVille;
        this.type = "plus proche voisin";
    }
    
    @Override
    public Tour execute() {
        Tour res = plus_proche_voisin();
        return res;
    }
    
    public Tour plus_proche_voisin(){

        this.villesVisitees.add(this.villesNonVisites.get(0));
        Ville villeActuelle = this.villesVisitees.get(0);
        this.villesNonVisites.remove(villeActuelle);
            
        while(!villesNonVisites.isEmpty()){
            villeActuelle = this.villesVisitees.get(this.villesVisitees.size()-1);
            
            Ville ville_plus_proche = ville_plus_proche(this.villesNonVisites, villeActuelle);
            
            this.villesVisitees.add(ville_plus_proche);
            this.villesNonVisites.remove(ville_plus_proche);
        
        }
        
        Tour tour = new Tour(this.villesVisitees, type);
        return tour;
    }
    
    public Ville ville_plus_proche(ArrayList<Ville> liste, Ville v){
        Ville ville_plus_proche = null;
        
        double distanceMin = 1000000000;
        for (int i=0; i<liste.size();i++){
            if (v.getDistance(liste.get(i)) < distanceMin){
                distanceMin = v.getDistance(liste.get(i));
                ville_plus_proche = liste.get(i);
            }
        }
        
        return ville_plus_proche;
    }
    
}
