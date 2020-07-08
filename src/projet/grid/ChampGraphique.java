package projet.grid;

import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;


import projet.metier.*;

//Merci à StackOverflow pour sa précieuse contribution !
//Update By : Boris Tibago & Yann Evariste Tekedo


public class ChampGraphique extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9131199592922499960L;
	private int largeur, hauteur;

	
	public List<Animal> casesAColorier;

	/**
	 * Constructeur.
	 * @param largeur La largeur (en nombre de cases) de la grille affichée.
	 * @param hauteur La hauteur (en nombre de cases) de la grille affichée.
	 */
	public ChampGraphique(int largeur, int hauteur) 
	{
		this.largeur = largeur;
		this.hauteur = hauteur;
		casesAColorier = new ArrayList<>();

		JFrame window = new JFrame();
		window.setSize(largeur*10+50, hauteur*10+50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("PouleRenardVipere Made By Tibago&Tekedo");
		window.add(this);
		window.setVisible(true);
	}

	@Override
	//Fonction d'affichage de la grille.
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		try {
			for (Animal fillCell : casesAColorier) 
			{	
				int cellX = 10 + (fillCell.x * 10);
				int cellY = 10 + (fillCell.y * 10);
				
			/* On choisis une couleur au hasard parmis les couleurs des animaux pr�sent 
				dans la liste d'animaux casesAColorier */
				
					g.setColor(fillCell.getCouleur());
					g.fillRect(cellX, cellY, 10, 10);
			}
		
			
			g.setColor(Color.BLACK);
			g.drawRect(10, 10, largeur*10, hauteur*10);

			for (int i = 10; i <= largeur*10; i += 10) {
				g.drawLine(i, 10, i, hauteur*10+10);
			}

			for (int i = 10; i <= hauteur*10; i += 10) {
				g.drawLine(10, i, largeur*10+10, i);
			}
		}catch(ConcurrentModificationException e)
		{
			e.getMessage() ;
		}catch(NullPointerException ex)
		{
			ex.getMessage() ;
		}
	}

	/**
	 * Fonction permettant de colorier, en rouge, une case de la grille
	 * @param x Abscisse de la case à colorier (entre 0 et largeur de grille - 1).
	 * @param y Ordonnée de la case à colorier (entre 0 et hauteur de grille - 1).
	 */
	
	public void colorierCase(Animal m) {
		if(m instanceof Poules) {
			casesAColorier.add(m);
			
			repaint();
		}
		if(m instanceof Renard) {
			casesAColorier.add(m);
			
			repaint();
		}
		if(m instanceof Vipere) {
			casesAColorier.add(m);
			
			repaint();
		}
	}
	
	/**
	 * Accesseur.
	 * @return Renvoie la largeur de la grille
	 */
	public int getLargeur()
	{
		return largeur;
	}
	
	/**
	 * Accesseur.
	 * @return Renvoie la hauteur de la grille
	 */
	public int getHauteur()
	{
		return hauteur;
	}
	
	public List<Animal> getCasesAColorier(){
		return casesAColorier ;
	}
	

	public void setCasesAColorier(List<Animal> casesAColorier) {
				this.casesAColorier = casesAColorier;
			
		
	}
	
}
