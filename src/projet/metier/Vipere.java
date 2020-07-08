package projet.metier;

import java.awt.Color;
import java.util.List;

/* 
 * 	Classe  Vipere qui étend Animal
	Auteurs : Boris Tibago & Yann Evariste Tekedo
 * 	Date Création : 18/06/2020  -  03:00
 * 	Date Mise à Jour : 29/06/2020 - 14:15
 * */

import java.util.Random;

import projet.grid.ChampGraphique;


public class Vipere extends Animal implements AnimalRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3928081839497632532L;

	public Vipere(Color co, double pdp, double pr, int batk, int catk, int cdf, int vde, int en, int es,int x,int y) {
	
		super(co,pdp,pr,batk,catk,cdf,vde,en,es,x,y) ;
		//super("Vert", 0.5, 0.5, 8, 5, 17, 1, 35, 120);

	}
	
	public Vipere(int x, int y) {
		super(x,y);
	}

// l'explication de cette methode est la meme dans la methode manger des classes Renard, Poules	
	public List<Animal> manger(Animal a, List<Animal> liste) {

		//System.out.println(" Vipere : je detecte ") ;
		// On crée un objet de type random pour génerer un nombre aléatoire
		Random r = new Random() ;
	
		/*  Si l'animal qu'il veux manger n'est pas sa proie on lui envoi un message d'alerte*/
		if(!(a instanceof Renard)) {
			System.out.println(" Vipère : Tu ne peux pas le manger, il n'est pas ta proie") ;
			a.aete = false ; // alors ce dernier n'a pas été attaqué
			return null;
		}else {
				this.fdt = true; a.fdt = true;  // ces 2 Animaux ne porront plus faire de tour
				if(a.isVamourir()==true || (a instanceof Renard)==true) {
					/* On tire un nombre au hasard entre  0 et la valeur de son bonus d'attaque*/ 
					int nbre =  r.nextInt(this.getBonusATK()) + this.getCapaciteATK() ;
					/*Si sa puissance obtenu est supérieure à la capacité de défense 
					 * de sa proie il la mange, sinon sa proie fuit
					 * */
					if(nbre > a.getCapaciteDF()) {
						System.out.println("Le " + a.getClass().getName()+ " a été mangé par le "+ this.getClass().getName());
						this.setEndurance(35); // l'experence de l'animal se renouvelle
						
						//this.aatt =true ; a.aete = true;
						this.move((int)a.getX(), (int)a.getY());  // l'animal this va dans la case de sa proie
						return mourir(a, liste);	// la proie meurs				
						
					}else {
						return null;
				}
			
			}
			
		}
		return null;

	}

	//// l'explication de cette methode est la meme dans la methode seReproduire des classes Renard, Poules
	@Override
	public Animal seReproduire(Animal a, ChampGraphique grid) {
		if(a instanceof Vipere) {
			
			Random tirage = new Random() ;
			double nbre = 0; int test=0; boolean b= false;
			
				nbre = tirage.nextDouble();
		
				if(nbre>=this.getProbaRepro())
					while(test<=grid.getLargeur()*grid.getHauteur() ) {
						Random r = new Random() ;
						int posx = r.nextInt(grid.getLargeur());
						int posy = r.nextInt(grid.getHauteur());  // ici l'idée est de tirer une case aleatoire sur le graphe et de verifier si elle n'est pas occupé
						for(Animal e: grid.casesAColorier) {
							if(posx != (int)e.getX() && posy!=(int)e.getY()) {
								b = true;  // alors elle est vide
							}
						}
						if( b == true) {
							// System.out.println(" Bebe en création \n ");
							Vipere m = new Vipere(Color.GREEN, 0.5, 0.5, 8, 5, 17, 1, 35, 120,posx,posy); // on cree le nouveau : Vipere
							System.out.println(m.toString());	
							this.serop = true; // le this s'est bel est bien reproduit
							return m;
						}
						test = test + 1;	// le test permet de verifier pour tirer jusqu'a ce qu'on est cherccher dans toutes les cases du champ 																
					}										
		}
		return null;
	}

/*	@Override
	public void seDeplacer(int vitesse) {
		// TODO Auto-generated method stub

	} */

	//Methode permettant de construire  la liste des voisins d'une vipere 
		
}
