/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro.source;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author lucas
 */
public class Tour {
    private ArrayList<Ville> listeTournee;
    private String type;
    
    
    public Tour(ArrayList<Ville> listeTournee, String type){
        this.listeTournee = listeTournee;
        this.type = type;
    }
    
    public Tour(){
        
    }

    public void setListeTournee(ArrayList<Ville> listeTournee) {
        this.listeTournee = listeTournee;
    }

    public String getType() {
        return type;
    }
    
    
    
    public double calculerCout() {
        double res= 0;
        for(int i=0; i<this.listeTournee.size();i++){
            if(i+1 == this.listeTournee.size()){
                res += this.listeTournee.get(i).getDistance(this.listeTournee.get(0));
            }else{
                res += this.listeTournee.get(i).getDistance(this.listeTournee.get(i+1));
            }
        }
       
        return res;
    }
    
    
    public void afficherCout(){
        System.out.println("Le coût du tour est de " + this.calculerCout() + " km");
    }
    
    public void afficherTour() {
        String res = "Tournée "+this.type+" [";
        for(int i=0; i<this.listeTournee.size(); i++){
            res += this.listeTournee.get(i).getNumVille();
            if(i+1 == this.listeTournee.size()){
                res += "]";
            }else{
                res+= ", ";
            }
        }
        
        System.out.println(res);
    }
    
    public void afficherInformations() {
        afficherTour();
        afficherCout();
    }

    public ArrayList<Ville> getListeTournee() {
        return listeTournee;
    }
    
    
}
