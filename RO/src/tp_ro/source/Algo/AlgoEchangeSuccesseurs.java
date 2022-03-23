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
public class AlgoEchangeSuccesseurs implements Algo{

    private ArrayList<Ville> listeInitiale;
    private ArrayList<Ville> villesNonVisitees;
    private String type;
    
    public AlgoEchangeSuccesseurs(ArrayList<Ville> listeVille){
        this.listeInitiale = new ArrayList<>();
        this.villesNonVisitees = new ArrayList<>(listeVille);
        this.type = "échange de succeseurs";
    }
    
    @Override
    public Tour execute() {
        return null;
    }
    
}
