package projet.metier;

import java.awt.Color;
import java.util.List;

/* 
 * 	Classe  Renard qui étend animal et implémente les fonctions
 Auteurs : Boris Tibago & Yann Evariste Tekedo
 * 	Date Création : 18/06/2020  -  02:50
 * 	Date Mise à Jour : 29/06/2020 - 14:10
 * */

import java.util.Random;

import projet.grid.ChampGraphique;

public class Renard extends Animal implements AnimalRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5063600028734212217L;

	public Renard(Color co, double pdp, double pr, int batk, int catk, int cdf, int vde, int en, int es,int x, int y) {
		super(co,pdp,pr,batk,catk,cdf,vde,en,es,x,y) ;
		//super("Orange", 0.2, 0.14, 12, 20, 7, 3, 8, 250);
		
	}

	public Renard(int x, int y) {
		super(x, y);
	}
	
	public List<Animal> manger(Animal a, List<Animal> liste) {
		
		//System.out.println(" Renard : je detecter") ;
			// On crée un objet de type random pour génerer un nombre aléatoire
			Random r = new Random() ;
			
			/*  Si l'animal qu'il veux manger n'est pas sa proie on lui envoi un message d'alerte*/
			if(!(a instanceof Poules)) {
				System.out.println(" Renard : Tu ne peux pas le manger, il n'est pas ta proie") ;
				//this.aatt =false ;
				a.aete = false;
				return null;
			}else {
				this.fdt = true; a.fdt = true;
				/* On tire un nombre au hasard entre  0 et la valeur de  son bonus d'attaque*/ 
				if(a.isVamourir()==true || (a instanceof Poules)==true) {
					int nbre =  r.nextInt(this.getBonusATK()) + this.getCapaciteATK() ;		
					/*Si sa puissance obtenu est supérieure à la capacité de défense 
					 * de sa proie il la mange, sinon sa proie fuit
					 * */
					if(nbre > a.getCapaciteDF()) {
						System.out.println("Le " + a.getClass().getName()+ " a été mangé par le "+ this.getClass().getName());
						this.setEndurance(8);
						//this.aatt =true ; a.aete = true;
						this.move((int)a.getX(), (int)a.getY());
						return mourir(a, liste);
					}else {
						this.aatt =true ; a.aete = true;
						return null;
					}	
				}
							
			}
			return null;
		
	}

	@Override
	public Animal seReproduire(Animal a, ChampGraphique grid) {
		if(a instanceof Renard) {
			Random tirage = new Random() ;
			double nbre = 0; int test=0; boolean b= false;
			
				nbre = tirage.nextDouble();
		
				if(nbre>=this.getProbaRepro())
					while(test<=grid.getLargeur()*grid.getHauteur() ) {
						Random r = new Random() ;
						int posx = r.nextInt(grid.getLargeur());
						int posy = r.nextInt(grid.getHauteur());
						for(Animal e: grid.casesAColorier) {
							if(posx != (int)e.getX() && posy!=(int)e.getY()) {
								b = true;
							}
						}
						if( b == true) {
							//System.out.println(" Bebe en création \n ");
							Renard m = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,posx,posy);
							System.out.println(m.toString());	
							this.serop = true;
							return m;
						}
						test = test + 1;											
						
					}	
		}
		return null;
	}

/*	@Override
	public void seDeplacer(int vitesse) {
		// TODO Auto-generated method stub

	} */
 

}
