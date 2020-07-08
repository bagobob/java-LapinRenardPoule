package projet.metier;

import java.awt.*;
import java.util.List;

/* 
 * 	Classe  Poule 
 * 	Auteurs : Boris Tibago & Yann Evariste Tekedo
 * 	Date Création : 18/06/2020  -  02:40
 * 	Date Mise à Jour : 29/06/2020 - 14:07
 * */

import java.util.Random;

import projet.grid.ChampGraphique;

public class Poules extends Animal implements AnimalRepository {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5917420331941344425L;


	public Poules(Color co, double pdp, double pr, int batk, int catk, int cdf, int vde, int en, int es,int x,int y) {
			super(co,pdp,pr,batk,catk,cdf,vde,en,es,x,y) ;
		//super("Jaune", 0.1, 0.4, 6, 15, 23, 2, 20, 150);
		
	}
	
	public Poules(int x, int y) {
		super(x,y);
	}

	
	public List<Animal> manger(Animal a, List<Animal> liste) {
		
		//System.out.println(" Poules : je detecte") ;
		// On crée un objet de type random pour génerer un nombre aléatoire
		Random r = new Random() ;
	
		
		/*  Si l'animal qu'il veux manger n'est pas sa proie on lui envoi un message d'alerte*/
		if(!(a instanceof Vipere)) {
			System.out.println("Poules : Tu ne peux pas le manger, il n'est pas ta proie") ;
			
			this.aatt =false ; a.aete = false;
			return null;
		}else { 
			this.fdt = true; a.fdt = true;
			/* On tire un nombre au hasard entre  0 et la valeur de son bonus d'attaque*/ 
			if(a.isVamourir()==true || (a instanceof Vipere)==true) {
				int nbre =  r.nextInt(this.getBonusATK()) + this.getCapaciteATK() ;
				/*Si sa puissance obtenu est supérieure à la capacité de défense 
				 * de sa proie il la mange, sinon sa proie fuit
				 * */
				if(nbre > a.getCapaciteDF()) {
					System.out.println("Le " + a.getClass().getName()+ " a été mangé par le "+ this.getClass().getName()); 
					a.aete = true;
					this.setEndurance(20);
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
		if(a instanceof Poules) {
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
							Poules m = new Poules(Color.YELLOW, 0.1, 0.4, 6, 15, 23, 2, 20, 150,posx,posy);
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
