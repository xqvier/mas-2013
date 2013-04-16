package prob.generator;

import java.util.List;
import java.util.Random;

/**
 * Classe utilitaire pour divers fonctions math�matiques
 * 
 * @author Axel Lormeau
 * @author Xavier Mourgues
 */
public class MathUtils {
	/**
	 * Renvoie un nombre al�atoire entre 0 et 1
	 * 
	 * @return le nombre al�atoire.
	 */
	public static double rand() {
		Random rand = new Random();
		return rand.nextDouble();
	}

	/**
	 * Renvoie la factorielle du nombre en param�tre
	 * 
	 * @param x
	 *            le nombre � calculer
	 * @return la factorielle
	 */
	public static int fact(int x) {
		if (x == 0) {
			return 1;
		}

		int fact = x;
		while (x > 1) {
			x--;
			fact *= x;
		}

		return fact;
	}

	/**
	 * Retourne le r�sultat de la fonction gamma pour le nombre pass� en
	 * param�tre.
	 * 
	 * @param x
	 *            le nombre � pass� dans la fonction gamma
	 * @return le r�sultat de la fonction gamma
	 */
	public static double gamma(double x) {
		
		return 0.0;
	}

	/**
	 * Retourne la moyenne d'une serie de nombre
	 * 
	 * @param pValues
	 *            la s�rie de nombre.
	 * @return la moyenne.
	 */
	public static Double moyenne(List<Double> pValues) {
		double sum = 0.0;
		for (double value : pValues) {
			sum += value;
		}
		return sum / pValues.size();
	}

}
