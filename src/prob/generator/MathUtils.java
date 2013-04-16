package prob.generator;

import java.util.List;
import java.util.Random;

/**
 * Classe utilitaire pour divers fonctions mathématiques
 * 
 * @author Axel Lormeau
 * @author Xavier Mourgues
 */
public class MathUtils {
	/**
	 * Renvoie un nombre aléatoire entre 0 et 1
	 * 
	 * @return le nombre aléatoire.
	 */
	public static double rand() {
		Random rand = new Random();
		return rand.nextDouble();
	}

	/**
	 * Renvoie la factorielle du nombre en paramètre
	 * 
	 * @param x
	 *            le nombre à calculer
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
	 * Retourne le résultat de la fonction gamma pour le nombre passé en
	 * paramètre.
	 * 
	 * @param x
	 *            le nombre à passé dans la fonction gamma
	 * @return le résultat de la fonction gamma
	 */
	public static double gamma(double x) {
		
		return 0.0;
	}

	/**
	 * Retourne la moyenne d'une serie de nombre
	 * 
	 * @param pValues
	 *            la série de nombre.
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
