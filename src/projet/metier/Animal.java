package projet.metier;
/* 
 * 	Classe mère qui serviras de base pour l'implémentation des classes Renard, Poule et Vipère
 * 	Auteur : Boris Tibago
 * 	Date Création : 18/06/2020  -  02:35
 * 	Date Mise à Jour :
 * */

public  abstract class Animal {

	//Définition des attributs de la classe
	
	private String couleur ;
	private double probaDP ;   // Probabilité de détection de la proie
	private double probaRepro ; //Probabilité de reproduction
	private int bonusATK;  //Bonus d'ataque
	private int capaciteATK; //Capacité d'ataque
	private int capaciteDF;  //Capacité Défense
	private int vitesseDE;  //Vitesse Déplacement
	private int endurance;  //Endurance alimentaire
	private int esperance;  //Espérance de vie
	
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
