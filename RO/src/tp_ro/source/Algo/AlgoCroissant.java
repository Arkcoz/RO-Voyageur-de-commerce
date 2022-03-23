/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro.source.Algo;

import java.util.ArrayList;
import tp_ro.source.Ville;
import tp_ro.source.Tour;

/**
 *
 * @author lm178867
 */
public class AlgoCroissant implements Algo{

    private ArrayList<Ville> listeVille = new ArrayList<>();
    private String type;
    
    public AlgoCroissant(ArrayList<Ville> listeVille){
        this.listeVille = listeVille;
        this.type = "croissant";
    }
    
    @Override
    public Tour execute() {
        ordreCroissant(this.listeVille);
        Tour res = new Tour(this.listeVille, this.type);
        
        return res;
    }
    
    public void ordreCroissant(ArrayList<Ville> listeVille){
        for (int i=0; i < this.listeVille.size(); i++){
            if(i+1 != listeVille.size()){
                if (listeVille.get(i).getNumVille() > listeVille.get(i+1).getNumVille()){
                    Ville ville1 = listeVille.get(i);
                    Ville ville2 = listeVille.get(i+1);

                    listeVille.set(i, ville2);
                    listeVille.set(i+1, ville1);
                }
            }
        }
        
        this.listeVille = listeVille;
    }
    
}
