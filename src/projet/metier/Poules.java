package projet.metier;

import java.util.Random;

public class Poules extends Animal implements AnimalRepository {

	public Poules(String co, double pdp, double pr, int batk, int catk, int cdf, int vde, int en, int es) {
		super("Jaune", 0.1, 0.4, 6, 15, 23, 2, 20, 150);
		// TODO Auto-generated constructor stub
	}
	
	public Poules() {
		super();
	}

	@Override
	public void manger(Animal a) {
		
		// On crée un objet de type random pour génerer un nombre aléatoire
		Random r = new Random() ;
	
		
		/*  Si l'animal qu'il veux manger n'est pas sa proie on lui envoi un message d'alerte*/
		if(!(a instanceof Vipere)) {
			System.out.println("Tu ne peux pas le manger, il n'est pas ta proie") ;
		}else {
			/* On tire un nombre au hasard entre  0 et la valeur de son bonus d'attaque*/ 
			
			int nbre =  r.nextInt(this.getBonusATK()) + this.getCapaciteATK() ;
			
			/*Si sa puissance obtenu est supérieure à la capacité de défense 
			 * de sa proie il la mange, sinon sa proie fuit
			 * */
			if(nbre > a.getCapaciteATK()) {
				System.out.println("Le " + a.getClass().getName()+ " a été mangé par le "+ this.getClass().getName());
				mourir(a);
			}else {
				((Vipere) a).seDeplacer(a.getVitesseDE());
			}
			
		}

	}

	@Override
	public Animal seReproduire(Animal a) {
		Random tirage = new Random() ;
		double nbre = 0;
		
		do {
			nbre = tirage.nextDouble();
		}while(nbre == this.getProbaRepro());
		
		Poules bebe = (Poules) this.clone();
		//bebe.seDeplacer(bebe.getVitesseDE());
	return bebe;
		
	}

	@Override
	public void seDeplacer(int vitesse) {
		// TODO Auto-generated method stub

	}



}
