package prob.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe utilitaire pour divers fonctions mathématiques
 * 
 * @author Axel Lormeau
 * @author Xavier Mourgues
 */
public class MathUtils {

	public static final int NB_CLASS = 10;

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

	public static double getMin(List<Double> pValues) {
		double min = pValues.get(0);

		for (Double value : pValues) {
			if (value < min) {
				min = value;
			}
		}

		return min;
	}

	public static double getMax(List<Double> pValues) {
		double max = pValues.get(0);

		for (Double value : pValues) {
			if (value > max) {
				max = value;
			}
		}

		return max;
	}

	public static List<Double> getValuesBetween(List<Double> list, double min,
			double max) {
		List<Double> result = new ArrayList<Double>();
		for (Double value : list) {
			if (value >= min && value < max) {
				result.add(value);
			}
		}
		return result;
	}

	public static double calculIndicateurKhi2(ILoi loi,
			List<Double> calculObserve) {
		double intervalleClass = (getMax(calculObserve) - getMin(calculObserve))
				/ NB_CLASS;

		double min = getMin(calculObserve);
		double max = min + intervalleClass;

		double khi2 = 0.0;

		while (max <= getMax(calculObserve)) {
			// calcul de la fréquence dans la classe
			double frequenceObserve = getValuesBetween(calculObserve, min, max)
					.size();

			double frequenceTheorique = (loi.loi(max) - loi.loi(min))
					* calculObserve.size();

			khi2 += Math.pow(frequenceObserve - frequenceTheorique, 2)
					/ frequenceTheorique;
			min = min + intervalleClass;
			max = min + intervalleClass;

		}

		return khi2;
	}
}
