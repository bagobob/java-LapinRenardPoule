package projet.metier;

/* 
 * 	Il s'agit la de l'interface où les seront déclarés les méthodes implémentés par chaque animal
 * 	Auteur : Boris Tibago
 * 	Date Création : 18/06/2020  -  02:44
 * 	Date Mise à Jour :
 * */
public interface AnimalRepository {

	public void manger(Animal a)  ;
	
	public Animal seReproduire(Animal a) ;
	
	public void seDeplacer(int vitesse) ;
	
	public default void mourir(Animal a) {
			a = null;
	};
 
}
