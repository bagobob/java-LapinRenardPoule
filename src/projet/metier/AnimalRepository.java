package projet.metier;

/* 
 * 	Il s'agit la de l'interface o� les seront d�clar�s les m�thodes impl�ment�s par chaque animal
 * 	Auteur : Boris Tibago
 * 	Date Cr�ation : 18/06/2020  -  02:44
 * 	Date Mise � Jour :
 * */
public interface AnimalRepository {

	public void manger(Animal a)  ;
	
	public Animal seReproduire(Animal a) ;
	
	public void seDeplacer(int vitesse) ;
	
	public default void mourir(Animal a) {
			a = null;
	};
 
}
