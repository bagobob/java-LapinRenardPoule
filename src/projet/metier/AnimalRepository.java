package projet.metier;

import java.util.ArrayList;
import java.util.List;

import projet.grid.ChampGraphique;

/* 
 * 	Il s'agit la de l'interface o� les seront d�clar�s les m�thodes impl�ment�s par chaque animal
 * 	Auteur : Boris Tibago
 * 	Date Cr�ation : 18/06/2020  -  02:44 
 * */
public interface AnimalRepository {
	
	public  Animal animal = null;

	// public void manger(Animal a)  ;
	
	public Animal seReproduire(Animal a, ChampGraphique grid) ;
	
	// public void seDeplacer(int vitesse) ;
	
	public default List<Animal> mourir(Animal a, List<Animal> liste) {
		// parce que lorsqu'on effectue un remove dans la liste; l'animal y reste toujours c'est pourquoi nous alors 
		// faire une recopie de Animaux dans la liste � l'exception de celui qu'on veut supprimer;
		List <Animal> nouveau = new ArrayList<Animal>();
		for(Animal e : liste) {
			if(e.equals(a)==false) {
				nouveau.add(e);
			}			
		}
		return nouveau;
	}
	
 
}
