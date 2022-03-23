/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro;

import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Ville {
    private int numVille;
    private String nom;
    private double latitude;
    private double longitude;

    public Ville(int numVille, String nom, double latitude, double longitude) {
        this.numVille = numVille;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getNumVille() {
        return numVille;
    }

    public void setNumVille(int numVille) {
        this.numVille = numVille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    @Override
    public String toString(){
        //String res = this.numVille + " " + this.nom + " " + this.latitude + " " + this.longitude;
        String res = this.numVille + "";
        return res;
    }
    
    
    public float getDistance(Ville v2){
        double y1 = Math.toRadians(this.getLatitude());
        double y2 = Math.toRadians(v2.getLatitude());
        double x1 = Math.toRadians(this.getLongitude());
        double x2 = Math.toRadians(v2.getLongitude());    
        int r = 6371;
        
        float res =  (float) abs(r * acos( (sin(y1) * sin(y2))  + ( cos(y1) * cos(y2) * cos(x2-x1) ) ) );
        
        return res;
    }
    
    public float getDistance(Ville A, Ville B){
        float calculDetour = A.getDistance(this) + this.getDistance(B) - A.getDistance(B);
        
        return calculDetour;
    }
    
    
    public double getDistance(ArrayList<Ville> tournee){
        double Distance = Double.MAX_VALUE;
        for (int i = 0 ; i < tournee.size()-1; i++)
        {
            if (Distance > this.getDistance(tournee.get(i),
                    tournee.get(i+1)))
            {
                Distance=this.getDistance(tournee.get(i),
                    tournee.get(i+1));
            }
               
        }
        if (Distance > this.getDistance(tournee.get(tournee.size()-1),
                    tournee.get(0)))
        {
             {
                Distance = this.getDistance(tournee.get(tournee.size()-1),
                    tournee.get(0));
            }
        }
        return Distance;
    }
    
}
