package prob.generator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Superclasse des generateurs aleatoires
 * Gere l'encapsulation des generateurs
 */
public abstract class AbstractGen implements Generator{

	/**
	 * Generateur fondamental
	 */
	protected Random rand;
	
	/**
	 * Constructeur pour les sous classes
	 */
	public AbstractGen(){
		rand = new Random();
	}

	/**
	 * Charge un arrayList avec des nombre aléatoire
	 */
	public List<Double> nextDoubles(int nb) {
		List<Double> results = new ArrayList<Double>(nb);
		for(int i =0; i < nb; i++){
			results.add(nextDouble());
		}
		return results;
	}

	
	/**
	 * Retourne une borne par la laquelle la prob cumulée est atteinte
	 * @param debutRecherche
	 * @return value : borne par laquelle la probabilité cumulée est atteinte
	 */
	public static double chercherValeur(Generator gen, double debutRecherche, double cumul){
		double pas = 1.0;
		double oldValue = -1; //utilisation en cas de manque de precision
		double value = debutRecherche;
		double prob = gen.getTheory(value);
		
		while(oldValue != value &&
				!(prob <= cumul + 0.000001 && prob >= cumul - 0.000001)){
			oldValue = value;
			prob = gen.getTheory(value);
			//Si devient superieur, inversion du pas
			if (pas >0.0 && prob>cumul){
				pas = pas / -2;
			} else if (pas <0.0 && prob<cumul){
				pas = pas / -2;
			}
			value += pas;
		}
		return value;
	}
}
