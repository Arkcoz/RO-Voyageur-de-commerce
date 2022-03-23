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
public class AlgoInsertionProche implements Algo{

    private ArrayList<Ville> listeInitiale;
    private ArrayList<Ville> villesNonVisitees;
    private String type;
    
    public AlgoInsertionProche(ArrayList<Ville> listeVille){
        this.listeInitiale = new ArrayList<>();
        this.villesNonVisitees = new ArrayList<>(listeVille);
        this.type = "insertion proche";
    }

    @Override
    public Tour execute() {
        //Ajouter des deux villes les plus éloignées
        ArrayList<Ville> villesVisitees = ajoutLesPlusLoin();
        Ville villeActuel;
        
        //Tant que toute les villes ne sont pas visitées
        while (!villesNonVisitees.isEmpty())
        {
            villeActuel = Next(villesVisitees, villesNonVisitees);
            villesVisitees = addVille(villeActuel,villesVisitees);
        }
        
        //Création du tour
        return new Tour(villesVisitees, type);
    }
    
    
    public ArrayList<Ville> ajoutLesPlusLoin(){
        
        //Initialisation des valeurs 
        ArrayList<Ville> res = new ArrayList<>();
        Ville v1 = null;
        Ville v2 = null;
        
        int id1 = 0;
        int id2 = 0;
        float distanceMin = 0;
        
        for (int i = 0; i < this.villesNonVisitees.size(); i++){
            v1 = this.villesNonVisitees.get(i);
            
            for(int j=0; j < this.villesNonVisitees.size(); j++){
                v2 = this.villesNonVisitees.get(j);
                
                //Si les villes ne sont pas les mêmes
                if(v1 != v2){
                    float distanceVille = v1.getDistance(v2);
                    if(distanceVille > distanceMin){
                        distanceMin = distanceVille;
                        id1 = i;
                        id2 = j;
                    }
                }
            }
        }
        
        //On va ajouter les deux villes les plus éloignées à la liste des villes visités
        v1 = this.villesNonVisitees.get(id1);
        v2 = this.villesNonVisitees.get(id2);
        
        res.add(v1);
        res.add(v2); 
        
        //On supprimer les villes visitées de la liste des villes non visitées
        this.villesNonVisitees.remove(v1);
        this.villesNonVisitees.remove(v2);
        
        return res;
    }

    private Ville Next(ArrayList<Ville> listeInitiale,ArrayList<Ville> villesNonVisitees)
    { 
        double distance = Double.MAX_VALUE;
        Ville ville = null;
        for (int i = 0 ; i < villesNonVisitees.size() ; i ++ )
        {
                if (distance>villesNonVisitees.get(i).getDistance(listeInitiale))
                {
                    distance = villesNonVisitees.get(i).getDistance(listeInitiale);
                    ville = villesNonVisitees.get(i);
                }     
        }
        return ville;
        
    }
    
    private ArrayList<Ville> addVille(Ville ville,ArrayList<Ville> villesVisitees)
    {
        //On va supprimer la ville de la lister des villes non visitées
        villesNonVisitees.remove(ville);
        
        double distance = Double.MAX_VALUE;
        int index = 0;
        
        for (int i = 0 ; i < villesVisitees.size() ; i++)
        {
           if (distance > ville.getDistance(villesVisitees.get(i), villesVisitees.get((i+1)%villesVisitees.size()))) 
           {
              distance = ville.getDistance(villesVisitees.get(i), villesVisitees.get((i+1)%villesVisitees.size()));
              index = (i+1)%villesVisitees.size();
           }
        }
        
        //Ajouter la ville à l'index souhaiter
        villesVisitees.add(index,ville);
        
        return villesVisitees;   
    }
}
