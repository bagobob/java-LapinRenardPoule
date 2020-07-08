package projet.metier;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import projet.grid.ChampGraphique;

/* 
 * 	Classe mère qui serviras de base pour l'implémentation des classes Renard, Poule et Vipère
 * Auteurs : Boris Tibago & Yann Evariste Tekedo
 * 	Date Création : 18/06/2020  -  02:35
 * */

public class Animal extends Point {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9161296027990105561L;
	//Définition des attributs de la classe
	
	private Color couleur ;
	private double probaDP ;   // Probabilité de détection de la proie
	private double probaRepro ; //Probabilité de reproduction
	private int bonusATK;  //Bonus d'ataque
	private int capaciteATK; //Capacité d'ataque
	private int capaciteDF;  //Capacité Défense
	private int vitesseDE;  //Vitesse Déplacement
	private int endurance;  //Endurance alimentaire
	private int esperance;  //Espérance de vie
	public boolean vamourir = false;
	public boolean aete = false; // determine si un Animal a été attaqué
	public boolean aatt = false; //determine si un a attaqué un Animal
	public boolean serop = false; // determine si un Animal s'est reproduit
	public boolean fdt = true; // determine la fin de tour d'un Animal
	

	public Animal(int x, int y) {
		super(x,y);  //
	}
	
	//Constructeur de la classe Animal
	
	public Animal(Color co,double pdp,double pr, int batk, int catk, int cdf, int vde, int en, int es,int x,int y) {
		super(x,y) ;
		this.couleur = co ;
		this.probaDP = pdp ;
		this.probaRepro = pr ;
		this.bonusATK = batk ; 
		this.capaciteATK = catk ; 
		this.capaciteDF = cdf ;
		this.vitesseDE = vde ;
		this.endurance = en ;
		this.esperance = es;
	
	}
	
	
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	public double getProbaDP() {
		return probaDP;
	}
	public void setProbaDP(double probaDP) {
		this.probaDP = probaDP;
	}
	public double getProbaRepro() {
		return probaRepro;
	}
	public void setProbaRepro(double probaRepro) {
		this.probaRepro = probaRepro;
	}
	public int getBonusATK() {
		return bonusATK;
	}
	public void setBonusATK(int bonusATK) {
		this.bonusATK = bonusATK;
	}
	public int getCapaciteATK() {
		return capaciteATK;
	}
	public void setCapaciteATK(int capaciteATK) {
		this.capaciteATK = capaciteATK;
	}
	public int getCapaciteDF() {
		return capaciteDF;
	}
	public void setCapaciteDF(int capaciteDF) {
		this.capaciteDF = capaciteDF;
	}
	public int getVitesseDE() {
		return vitesseDE;
	}
	public void setVitesseDE(int vitesseDE) {
		this.vitesseDE = vitesseDE;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public int getEsperance() {
		return esperance;
	}
	public void setEsperance(int esperance) {
		this.esperance = esperance;
	}
	
	@Override
	public Animal clone() {
		Animal a = null ;
		a = (Animal)super.clone();
		return a;
	}
	
	//Methode permettant de construire  la liste des voisins d'un Renard
			
	public List<Animal> voisinsPoint(List<Animal> liste){
		List<Animal> voisins  = new ArrayList<Animal>();
		//1
		// ce qu'on va faire c'est cree 3 differents animaux et faire la comparaison dans la liste
		Renard r = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y+1); // on prends le premier Renard a ces positions là
		if(liste.contains(r))  // on verfie qu'il est dans la liste de nos animaux
			voisins.add(r); // si oui alors celui ci est u,, voisins donc on l'ajoute à la liste des voisins de this
		else {  //sinon alors son voisins est soit une vipere ou une poules 
			Vipere v = new Vipere(Color.GREEN,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y+1);
			if(liste.contains(v))   // si c'est une vipere alors on l'ajoute 
				voisins.add(v);
			else {					//sinon alors c'est un poule
				Poules p = new Poules(Color.YELLOW,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y+1);
				if(liste.contains(p))  // si c'est une poule alors on l'ajoute et sinon cette case est vide
					voisins.add(p);
			}
		}
								
		//2
		Renard r1 = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y+1);
		if(liste.contains(r1))
			voisins.add(r1);
		else {
			Vipere v1 = new Vipere(Color.GREEN,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y+1);
			if(liste.contains(v1))
				voisins.add(v1);
			else {
				Poules p1 = new Poules(Color.YELLOW,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y+1);
				if(liste.contains(p1))
					voisins.add(p1);
			}					
		}
		
		//3
		Renard r2 = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y+1);
		if(liste.contains(r2))
			voisins.add(r2);
		else {
			Vipere v2 = new Vipere(Color.GREEN,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y+1);
			if(liste.contains(v2))
				voisins.add(v2);
			else {
				Poules p2 = new Poules(Color.YELLOW,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y+1);
				if(liste.contains(p2))
					voisins.add(p2);
			}						
		}
		
		//4
		Renard r3 = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x-1,this.y);
		if(liste.contains(r3))
			voisins.add(r3);
		else {
			Vipere v3 = new Vipere(Color.GREEN,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x-1,this.y);
			if(liste.contains(v3))
				voisins.add(v3);
			else {
				Poules p3 = new Poules(Color.YELLOW,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x-1,this.y);
				if(liste.contains(p3))
					voisins.add(p3);
			}
			
		}
		
		//5
		Renard r4 = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y);
		if(liste.contains(r4))
			voisins.add(r4);
		else {
			Vipere v4 = new Vipere(Color.GREEN,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y);
			if(liste.contains(v4))
				voisins.add(v4);
			else {
				Poules p4 = new Poules(Color.YELLOW,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y);
				if(liste.contains(p4))
					voisins.add(p4);
			}
			
		}
		
		//6
		Renard r5 = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x-1,this.y-1);
		if(liste.contains(r5))
			voisins.add(r5);
		else {
			Vipere v5 = new Vipere(Color.GREEN,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x-1,this.y-1);
			if(liste.contains(v5))
				voisins.add(v5);
			else {
				Poules p5 = new Poules(Color.YELLOW,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x-1,this.y-1);
				if(liste.contains(p5))
					voisins.add(p5);
			}
			
		}
		
		//7
		Renard r6 = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y-1);
		if(liste.contains(r6))
			voisins.add(r6);
		else {
			Vipere v6 = new Vipere(Color.GREEN,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y-1);
			if(liste.contains(v6))
				voisins.add(v6);
			else {
				Poules p6 = new Poules(Color.YELLOW,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x,this.y-1);
				if(liste.contains(p6))
					voisins.add(p6);
			}
			
		}
		
		//8
		Renard r7 = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y-1);
		if(liste.contains(r7))
			voisins.add(r7);
		else {
			Vipere v7 = new Vipere(Color.GREEN,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y-1);
			if(liste.contains(v7))
				voisins.add(v7);
			else {
				Poules p7 = new Poules(Color.YELLOW,  0.2, 0.14, 12, 20, 7, 3, 8, 250,this.x+1,this.y-1);
				if(liste.contains(p7))
					voisins.add(p7); 
					
			}
			
		}					
			return voisins ;
	}
	
		public List<Animal> manger(Animal a, List<Animal> liste) {
			return null;
		}

		
		public Animal seReproduire(Animal a, ChampGraphique grid) {
			return null;
		}
		
		public void seDeplacer(List<Animal> list1, ChampGraphique grid) {
			for(int j=0; j<this.vitesseDE; j++) {
				if(list1.isEmpty()==true) { 		// ici si la liste de ses voisins est vide alors il a 8
													// possibilités de se déplacer
					Random r = new Random(); 	// on tire au hasard un nombre puis selon ce nombre on 
					int k = r.nextInt(8); 		// determine une case	
					switch (k) {
					case 0 : 
							this.move(Valeurs((int)this.getX()-1,grid.getLargeur()), Valeurs2((int)this.getY()+1, grid.getHauteur()));
						break;
					case 1 : 
						 this.move(Valeurs((int)this.getX(),grid.getLargeur()), Valeurs2((int)this.getY()+1, grid.getHauteur()));
						break;
					case 2 : 
							this.move(Valeurs((int)this.getX()+1,grid.getLargeur()), Valeurs2((int)this.getY()+1, grid.getHauteur()));
						break;
					case 3 : 
						this.move(Valeurs((int)this.getX()-1,grid.getLargeur()), Valeurs2((int)this.getY(), grid.getHauteur()));
						
						break;
					case 4 : 
						this.move(Valeurs((int)this.getX()+1,grid.getLargeur()), Valeurs2((int)this.getY(), grid.getHauteur()));
						break;
					case 5 : 
						this.move(Valeurs((int)this.getX()-1,grid.getLargeur()), Valeurs2((int)this.getY()-1, grid.getHauteur()));
						break;
					case 6 : 
						this.move(Valeurs((int)this.getX(),grid.getLargeur()), Valeurs2((int)this.getY()-1, grid.getHauteur()));
						break;
					case 7 : 
						this.move(Valeurs((int)this.getX()+1,grid.getLargeur()), Valeurs2((int)this.getY()-1, grid.getHauteur()));
						break;
					}
				}
				else {   //sinon c'est à dire il y'a des voisins eventuelles alors on va determiner parmis ces voisins la case qui est libre
					if(list1.size()<=8) {   
						boolean b = false; 
						int position[][] = { {(int)this.getX()-1 , (int)this.getY()+1 } , {(int)this.getX() ,(int)this.getY()+1 } , {(int)this.getX()+1 , (int)this.getY()+1} , {(int)this.getX()-1 ,(int)this.getY() }, {(int)this.getX()+1 , (int)this.getY()}, { (int)this.getX()-1, (int)this.getY()-1} , { (int)this.getX(),(int)this.getY()-1 } , { (int)this.getX()+1, (int)this.getY()-1} } ;
					    // ce tableau permet de dresser la liste de ses cases voisines
						for(int i=0;i<8;i++) {
					    	// l'idéé ici est de tirer une case dont il n'y a aucun animal c'est a dire n'est pas dans notre liste des Animaux
					    		for(Animal e: list1) {
					    			if(position[i][0] != (int)e.getX() && position[i][1]!= (int)e.getY()) {
					    				b = true ;  // alors oui cette case est vide
					    			
					    		}				    		
					    		if(b == true) {
					    			this.move(Valeurs(position[i][0],grid.getLargeur()), Valeurs2(position[i][1], grid.getHauteur()));
					    			// il va ainsi a cette case vide
					    			break;
					    		}			    	
					    }
					}
				}
			}
		
			}	
			
		}
		
		public void AeteAttaquer(boolean b) {
			aete = b;
			
		}
		public boolean getAete() {
			return aete;
		}
		
		public int Valeurs(int x,int max){  // cette methode permet de genrer un nombe afin qu'l ne depasse pas la longueur du champ
			if(x>=max) {
				x -= 1; 
			}	
			if(x<0) {
				x += 1; 
			}
			return x;
		}
		
		public int Valeurs2(int y, int max2) { // cette methode permet de genrer un nombe afin qu'l ne depasse pas la hauteur du champ
			if(y>=max2) {
				y -= 1; 
			}
			
			if(y<0) {
				y += 1; 
			}
			return y;
		}
		
		public List<Animal> mourir2(Animal a, List<Animal> liste) {
			// cette methode a le meme processus que celle mourrir() dans l'interface AnimalRepository
			List <Animal> nouveau = new ArrayList<Animal>();
			for(Animal e : liste) {
				if(e.equals(a)==false) {
					nouveau.add(e);
				}			
			}
			return nouveau;
		}

		public boolean isVamourir() {
			return vamourir;
		}

		public void setVamourir(boolean vamourir) {
			this.vamourir = vamourir;
		}
		
		public boolean isFdt() {
			return fdt;
		}
}
