package projet.metier;
/* 
 * 	Classe m�re qui serviras de base pour l'impl�mentation des classes Renard, Poule et Vip�re
 * 	Auteur : Boris Tibago
 * 	Date Cr�ation : 18/06/2020  -  02:35
 * 	Date Mise � Jour :
 * */

public  abstract class Animal {

	//D�finition des attributs de la classe
	
	private String couleur ;
	private double probaDP ;   // Probabilit� de d�tection de la proie
	private double probaRepro ; //Probabilit� de reproduction
	private int bonusATK;  //Bonus d'ataque
	private int capaciteATK; //Capacit� d'ataque
	private int capaciteDF;  //Capacit� D�fense
	private int vitesseDE;  //Vitesse D�placement
	private int endurance;  //Endurance alimentaire
	private int esperance;  //Esp�rance de vie
	
	public Animal() {
		super();
	}
	
	//Constructeur de la classe Animal
	
	public Animal(String co,double pdp,double pr, int batk, int catk, int cdf, int vde, int en, int es) {
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
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
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
		try {
			a = (Animal)super.clone();
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return a;
	}
	
}
