/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro.source.Algo;

import java.util.ArrayList;
import java.util.Collections;
import tp_ro.Ville;
import tp_ro.source.Tour;

/**
 *
 * @author lm178867
 */
public class AlgoAleatoire implements Algo {
    
    private ArrayList<Ville> listeVille;
    private String type;
    
    public AlgoAleatoire(ArrayList<Ville> listeVille){
        this.type = "aléatoire";
        this.listeVille = listeVille;
    }
    
    
    @Override
    public Tour execute() {
        //this.listeVille = createListeVille();
        Collections.shuffle(this.listeVille);
        
        Tour tour = new Tour(this.listeVille,this.type);
        
        return tour;
    }

}
