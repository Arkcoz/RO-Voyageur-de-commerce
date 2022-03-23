/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_ro;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class ListeVille {
    private ArrayList<Ville> listeVille;
    
    public ListeVille() throws FileNotFoundException {
        this.listeVille = createListeVille();      
    }
    
    
    private ArrayList<Ville> createListeVille() throws FileNotFoundException{
        ArrayList<Ville> listeVille = new ArrayList<>();
        
        //Lecture du fichier top80
        String fileName = "top80.txt";
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNextLine()){
            
            //On va lire ligne par ligne
            String line = scan.nextLine();
            
            //Initialisation des variables utilisées
            String val_numVille = "";
            String val_nom = "";
            String val_latitude = "";
            String val_longitude = "";
            int nbEspace = 0;
            
            //Pour chaque caratère de la ligne
            for (int i=0; i < line.length(); i++){
                String car = String.valueOf(line.charAt(i));
                if(" ".equals(car)){
                    nbEspace++;
                }else{
                    switch(nbEspace){
                        case 0: val_numVille += car; break;
                        case 1: val_nom += car; break;
                        case 2: val_latitude += car; break;
                        case 3: val_longitude += car; break;
                    }
                }               
                
            }
            
            //Retranstypage des variables
            Integer numVille = Integer.valueOf(val_numVille);
            String nom = val_nom;
            double latitude = Float.valueOf(val_latitude);
            double longitude = Float.valueOf(val_longitude);
            
            
            //Création de la ville
            Ville ville = new Ville(numVille, nom, latitude, longitude);
            
            //Ajout à la liste
            listeVille.add(ville);
            
            
        }
        return listeVille;
    }

    public ArrayList<Ville> getListeVille() {
        return listeVille;
    }
    
    
    
    public float d(Ville v1, Ville v2){
        double y1 = Math.toRadians(v1.getLatitude());
        double y2 = Math.toRadians(v2.getLatitude());
        double x1 = Math.toRadians(v1.getLongitude());
        double x2 = Math.toRadians(v2.getLongitude());    
        int r = 6371;
        
        float res =  (float) abs(r * acos( (sin(y1) * sin(y2))  + ( cos(y1) * cos(y2) * cos(x2-x1) ) ) );
        
        return res;
    }

}
