package prob.khi2;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import prob.generator.ILoi;



/**
 * Cette classe assure le calcul du Khi2
 * @author CnCBoy
 */
public class CalculKhi2 {
	
	//////////////////////////////////////////////////////////////
	////////////////////CONSTANTE DE LA CLASSE////////////////////
	//////////////////////////////////////////////////////////////
	
	/**
	 * Pour l'appel de CollecterDonne sans argument
	 */
	public final static int NB_TEST_DEFAUT = 300;
	
	/**
	 * Pour l'appel de CollecterDonne sans argument
	 */
	public final static int NB_CLASS_DEFAUT = 20;
	
	/**
	 * Population minimale d'une classe
	 */
	public final static int POP_MINI = 5;
	
	/**
	 * Pourcentage de classe peuplé correctement requis
	 */
	public final static double RATIO_POP_REQUIS = 0.8;
	
	
	//////////////////////////////////////////////////////////////
	//////////////////////MEMBRES DE LA CLASSE////////////////////
	//////////////////////////////////////////////////////////////
	
	/**
	 * Generateur mis à l'epreuve
	 */
	private ILoi loi;
	
	/**
	 * Nombre de classe pour le test
	 */
	private int nbClass;
	
	/**
	 * Echantillon tiré
	 */
	private List<Double> tirage;

	/**
	 * Tolerance d'erreur d'acceptation du test
	 */
	private double seuilToleranceErreur;
	
	//////////////////////////////////////////////////////////////
	////////////////////////CONSTRUCTEUR//////////////////////////
	//////////////////////////////////////////////////////////////
	
	/**
	 * Constructeur d'un evaluateur de Khi2
	 * @param gen Loi fournie, elle permet d'obtenir la repartion 
	 * theorique pour la comparer au tirage fourni par setTirage
	 */
	public CalculKhi2(ILoi loi){
		//Generateur
		this.loi = loi;
		
		//Enregistrement du nombre de classe
		this.nbClass = NB_CLASS_DEFAUT;
	}
	
	/**
	 * Constructeur d'un evaluateur de Khi2
	 * @param gen Loi fournie, elle permet d'obtenir la repartion 
	 * theorique pour la comparer au tirage fourni par setTirage
	 * @param nbClass Nombre de classe
	 */
	public CalculKhi2(ILoi loi, int nbClass){
		//Generateur
		this.loi = loi;
		
		//Enregistrement du nombre de classe
		this.nbClass = nbClass;
		
		//Enregistrement du nombre de test
		//this.nbTest = nbTest;

		//Coupure du tirage aleatoire, ce module
		//peut desormais valider des tirages fourni
		
	}
	
	//////////////////////////////////////////////////////////////
	////////////////////////TEST DU KHI2//////////////////////////
	//////////////////////////////////////////////////////////////
	
	/**
	 * Teste l'adaptation entre un tirage et la loi de probabilite (Generateur)
	 * @return Le resultat du test
	 */
	public ResultKhi2 test(){
		//Decoupage en classe
		List<Classe> classes = decoupeClasse();
		double khi2 = calculKhi2(classes);
		
		//Degree de liberte
		int degreLiberte = degreLiberte(classes.size());
		
		//Obtenir la marge d'erreur
		double margeErreur = TableKhi2.getRisqueErreur(degreLiberte, khi2);
		
		return new ResultKhi2(tirage, khi2, margeErreur, seuilToleranceErreur);
	}
	
	/**
	 * Degré de liberté en fonction du nombre de classes
	 * @param nbClasses : nombre de classes
	 * @return degré
	 */
	private int degreLiberte(int nbClasses) {
		return nbClasses - loi.getParamLoi() - 1;
	}
	
	/**
	 * Calcule la valeur du khi2 à partir du tirage et de la loi donnée
	 * @return la valeur du khi2
	 */
	private double calculKhi2(List<Classe> classes){
		
	    //Calcul du Khi2
	    double Khi2 = 0;
	    
		//Collecte des valeurs theoriques
		for (Classe c : classes){
			
			//Quantite observe
	    	double observe = c.getPopulation();
	    	
	    	//Pourcentage de la distribution total sur cette classe
	    	double pCent = loi.loi(c.getMax()) - loi.loi(c.getMin());
	    	
	    	//Protection sur les classes vide 
	    	double attendu = pCent * tirage.size();
	    	if (attendu>0){
	    		Khi2+= Math.pow(observe-attendu,2)/attendu;
	    	}
		}
		
		return Khi2;
	}
	
	
	//////////////////////////////////////////////////////////////
	//////////////////////DECOUPAGE EN CLASSE/////////////////////
	//////////////////////////////////////////////////////////////
	
	/**
	 * Realise le decoupage en classe
	 */
	private List<Classe> decoupeClasse(){
		LinkedList<Classe> classes = new LinkedList<Classe>();
		
		
		//Si la loi est discrete
		if(loi.estDiscret()){
			//Creation des listes à remplir
			for (int i=(int) loi.getMinSupport(); i <= loi.getMaxSupport(); i++){
				double vInf = i;
				double vSup = i+1;
				classes.add(new Classe(vInf, vSup));
			}
		}else {
			//Largeur de chaque classe
			double classWidth= (loi.getMaxSupport()-loi.getMinSupport())/nbClass;
			
			//Creation des listes à remplir
			//On utilise le support connu de la focntion de repartition
			for (int i=0; i < nbClass; i++){
				double vInf = loi.getMinSupport()+classWidth*i;
				double vSup = loi.getMinSupport()+classWidth*(i+1);
				classes.add(new Classe(vInf, vSup));
			}
		}
		
		//Duplication du conteneur de liste
		//Le triage détruit l'ordre de tirage, que l'on a parfois besoin
		//Le contenu n'a pas besoin d'être codé.
		List<Double> d_tirage = new ArrayList<Double>();
		d_tirage.addAll(tirage);
		
		
		//Triage du tirage
		Collections.sort(d_tirage);
		//Classement des données en classe
		for(Double value : d_tirage){
			
			int iClass= 0; //index de parcour des classes
			//Recherche classe contenante
			while (iClass < classes.size() && !classes.get(iClass).isInside(value)){
				iClass++;
			}
			
			//Protection en cas d'arrodnis qui sortirait des classes possibles
			if (iClass<classes.size()){
				classes.get(iClass).insert(value);
			}
		}
		
		//Si on a besoin de regrouper les classes
		//Car insuffisamment peuplé
		if (requisRegroup(classes)){
			regrouperClassesOptimalement(classes);
		}
		
		return classes;
	}

	/**
	 * Regroupe les classes pour respecter la population minimale de celle ci
	 * comme definit dans les constante POP_MINI et 
	 * @param classes
	 */
	private void regrouperClassesOptimalement(LinkedList<Classe> classes) {
		int cptC = 0; //compteur de parcour de classe
		
		//Fusion de classe de gauche à droite
		while(cptC < classes.size()-1){
			if (classes.get(cptC).getPopulation()<POP_MINI){
				Classe fusion = Classe.fusionner(classes.get(cptC), classes.get(cptC+1));
				classes.remove(cptC+1);
				classes.remove(cptC);
				classes.add(cptC, fusion);
			}else {
				cptC++;
			}
		}
		
		cptC = classes.size()-1;
		//Fusion de classe de droite à gauche
		while(cptC > 0){
			if (classes.get(cptC).getPopulation()<POP_MINI){
				Classe fusion = Classe.fusionner(classes.get(cptC-1), classes.get(cptC));
				classes.remove(cptC);
				classes.remove(cptC-1);
				classes.add(cptC-1, fusion);
			}
			cptC--;
		}
	}

	/**
	 * Cette methode verifie si les classes sont peuplés correctement
	 * RATIO_POP_REQUIS de classe avec au moins POP_MINI élements dedans
	 * @param classes Classes à etudier
	 * @return si les classes ont besoins d'être regroupées
	 */
	private boolean requisRegroup(LinkedList<Classe> classes) {
		//Optimisation des classes si necessaires
		int cptInfPopul = 0; //nombre de classes mal peuplée
		for (Classe c : classes){
			if (c.getPopulation()<POP_MINI){
				cptInfPopul++;
			}
		}
		
		double ratioPopul = 1-(double)cptInfPopul/classes.size();
		return ratioPopul  < RATIO_POP_REQUIS ;
	}
	
	//////////////////////////////////////////////////////////////
	////////////////////////SETTER & GETTER///////////////////////
	//////////////////////////////////////////////////////////////
	
	/**
	 * Setter
	 * @param gen
	 */
	public void setGenerator(ILoi loi) {
		this.loi = loi;
	}
	
	/**
	 * @param nbClass the nbClass to set
	 */
	public void setNbClass(int nbClass) {
		this.nbClass = nbClass;
	}

	
	/**
	 * Setter
	 * @param tirage
	 */
	public void setTirage(List<Double> tirage) {
		this.tirage = tirage;
	}
	
	/**
	 * Setter
	 * @param seuilToleranceErreur
	 */
	public void setSeuilToleranceErreur(double seuilToleranceErreur) {
		this.seuilToleranceErreur = seuilToleranceErreur;
	}
	

	//////////////////////////////////////////////////////////////
	//////////////////////PARTIE GRAPHIQUE TP1////////////////////
	//////////////////////////////////////////////////////////////
	
	/**
	 * Chaine texte de commentaire sur le resultat
	 * @return
	 */
	public String compareKhi2TheoriqueKhi2Calcule(){
		
		//Decoupage en classe, pour le nombre de degree
		List<Classe> classes = decoupeClasse();
		
		DecimalFormat formatMilli = new DecimalFormat("0.000");
		
		return "Le Khi2 experimental est de "+formatMilli.format(calculKhi2(classes))+
		", la loi de probabilite est verifiée avec un risque d'erreur de "+ 
		TableKhi2.getRisqueErreur(degreLiberte(classes.size()), calculKhi2(classes))*100+"%";
	}
}
