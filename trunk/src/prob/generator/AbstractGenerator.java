package prob.generator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Superclasse des generateurs aleatoires
 * Gere l'encapsulation des generateurs
 * @author CnCBoy
 */
public abstract class AbstractGenerator implements Generator{

	/**
	 * Generateur utilisé comme fondement
	 */
	protected Random rand;
	
	/**
	 * Constructeur pour les sous classes
	 * @param seed Initialisateur du generateur pseudo-aleatoire
	 */
	public AbstractGenerator(){
		rand = new Random();
	}

	/* (non-Javadoc)
	 * @see prob.generator.Generator#nextDoubles(int)
	 */
	@Override
	public List<Double> nextDoubles(int nb) {
		List<Double> results = new ArrayList<Double>(200);
		for(int i =0; i < nb; i++){
			results.add(nextDouble());
		}
		return results;
	}

	
	/**
	 * Retourne une borne par la laqulle la prob cumulé est atteinte
	 * @param debRch
	 * @return
	 */
	public static double chercherValeur(Generator gen, double debRch, double cumul){
		double pas = 1.0;
		double oldValue = -1; //utilisation en cas de manque de precision
		double value = debRch;
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
