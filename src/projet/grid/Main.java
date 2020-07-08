package projet.grid;

import projet.metier.*;

import java.awt.Color;
import java.util.*;
//Updated By Yann Tekedo & Boris Tibago

public class Main 
{
	//cette fonction permet de renouveller la liste des animaux du champ Graphique
	public static void nouvelle(List<Animal> intermediare, List<Animal> casesAColorier) {
		casesAColorier.clear();  //on vide l'ancienne liste  
		for(Animal e : intermediare) {
				casesAColorier.add(e);	//et on ajoute les nouveaux éléments sauf ceux qui ont été mangés
		}
	}
		
	public static void main(String[] args)
	{
		//On crÃ©e un objet ChampGraphique de 50 cases de large, et 60 de haut
		ChampGraphique grid = new ChampGraphique(50, 60);
		final int nbrevipere = 200 ;
		final int nbrerenard = 150 ;
		final int nbrepoules = 150 ;
		
		int posx, posy ;
		Random r = new Random();
		
		int i;
		//Trente fois...
		for(i=0; i<nbrepoules; i++)
		{
			posx = r.nextInt(grid.getLargeur());
			posy = r.nextInt(grid.getHauteur());
			Animal m = null;
			m = new Poules(Color.YELLOW, 0.1, 0.4, 6, 15, 23, 2, 20, 150,posx,posy) ;			
			grid.colorierCase(m);
			try 
			{
	            Thread.sleep(10);
	        } 
			catch (InterruptedException e) 
			{
	            e.printStackTrace();
	        }			
		} 
		for(i=0; i<nbrerenard; i++)
		{			
			posx = r.nextInt(grid.getLargeur());
			posy = r.nextInt(grid.getHauteur());
			Animal m = null;	
			m = new Renard(Color.ORANGE,  0.2, 0.14, 12, 20, 7, 3, 8, 250,posx,posy) ;
			grid.colorierCase(m);				
			try 
			{
	            Thread.sleep(10);
	        } 
			catch (InterruptedException e) 
			{
	            e.printStackTrace();
	        }			
		} 
		for(i=0; i<nbrevipere; i++)
		{			
			posx = r.nextInt(grid.getLargeur());
			posy = r.nextInt(grid.getHauteur());
			Animal m = null;	
			m = new Vipere(Color.GREEN, 0.5, 0.5, 8, 5, 17, 1, 35, 120,posx,posy) ;
			grid.colorierCase(m);				
			try 
			{
	            Thread.sleep(10);
	        } 
			catch (InterruptedException e) 
			{
	            e.printStackTrace();
	        }			
		} 
		

			List<Animal> intermediare = new ArrayList<Animal>();
			List<Animal> intermediare2 = new ArrayList<Animal>(); // les 2 listes qui permettront de récuperer les animaux conservés dans le graphe
			int nombrejours = 0;
			//on suppose que notre simulation fera 4 saisons dont une saison represente 30 jours
			for(int saison=0; saison<4; saison++ ) {  // represente les 4 saisons
				// on suppose que le primptemps correspond à la saison numero 3
				
				System.out.println(" *******************   Saison "+  saison  +"  ************************");
				
				for(i=0; i<30;i++) {  // chaque journée du mois 
					nombrejours++;
					intermediare.clear();
					for(Animal e:grid.getCasesAColorier()) {
						
						intermediare.add(e);
					}
					 
					//	System.out.println("\n"+grid.casesAColorier.size()) ;
					//	System.out.println("\n"+intermediare.size()) ;
					
					for(Animal a : intermediare)
					{ 				
							System.out.println(" jour Actuel  : "+ nombrejours + "\n ");
							if(( nombrejours > a.getEndurance() + 10) && a.isVamourir()==true) {
								// System.out.println(" est mort de famine ou de viellesse \n ");
								intermediare2 = a.mourir2(a,intermediare);
								nouvelle(intermediare2,grid.casesAColorier);
								try 
								{
						            Thread.sleep(100);
						        } 
								catch (InterruptedException e2) 
								{
						            e2.printStackTrace();
						        }	 
								grid.repaint();  
							}			 
									
						//
						if(a.getEndurance() < nombrejours || a.getEsperance() < nombrejours) {
							a.setVamourir(true);
							a.setCapaciteDF(-1);
						}
						
						if(a.isFdt() == false) {
							System.out.println("\n"+a.toString()) ;
							
							List<Animal> list =  a.voisinsPoint(grid.getCasesAColorier()); 
							if(list != null) {
								for(Animal b : list)
								{					
										 System.out.println("je suis le voisin : "+ b.toString()+ "\n ");
										 intermediare2 = a.manger(b,grid.casesAColorier);
										 if(intermediare2 != null) {
											 nouvelle(intermediare2, grid.casesAColorier);
											 System.out.println("taille grille "+ grid.casesAColorier.size()+ "\n ");
											 try 
												{
											        Thread.sleep(100);
											    } 
												catch (InterruptedException e) 
												{
											        e.printStackTrace();
											    }
												grid.repaint(); 
												break;
										 }
										 if(saison == 1 ) {   // correspond au primptemps
											 Animal nouveau;
											 nouveau = a.seReproduire(b,grid);
											 if(nouveau != null) {
												// System.out.println(" fils crée : "+ nouveau.toString());						
													grid.colorierCase(nouveau);
													// System.out.println("taille grille "+ grid.casesAColorier.size()+ "\n ");
													try 
													{
											            Thread.sleep(100);
											        } 
													catch (InterruptedException e) 
													{
											            System.out.println(" element vide ");
											        }
													grid.repaint();
											 }
											 break;
										 }
																								
								}
							}
							
							if(a.aete == false && a.aatt == false && a.serop== false) {
								//se deplacer();
								// System.out.println("je suis le voisin : "+ a.toString()+ "\n ");
								// System.out.println(" se deplacer ");
								a.seDeplacer(list, grid);
								grid.repaint();
							}
						}						
											
				}
				 // A la fin de la journée on réinitialise l'attribut fin de tour pour spécifier qu'a la 
				// journée suivante aucun animal n'a passé de tour;
					
					for(Animal a: grid.casesAColorier) { 
						a.fdt = false ;
					}
					
					// System.out.println("taille grille "+ grid.casesAColorier.size()+ "\n ");
			}				
		}
		
	}
}
