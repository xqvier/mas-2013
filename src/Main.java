import java.util.List;

import prob.generator.LoiDePoisson;
import prob.generator.LoiDeWeibull;
import prob.generator.LoiExponentielle;
import prob.generator.LoiNormale;
import prob.generator.LoiUniforme;
import prob.generator.MathUtils;

public class Main {

	private static final int NB_ESSAI_MAX = 600;

	public static void main(String[] args) {

		// LOI UNIFORME
		double param = MathUtils.rand();
		double param2;
		do {
			param2 = MathUtils.rand();
		} while (param2 <= param);

		System.out
				.println("Test de la loi uniforme pour un param�tre min = 1 et max = 2");
		LoiUniforme loiUniforme = new LoiUniforme(1, 2);

		System.out.println("Moyenne th�orique = "
				+ loiUniforme.getMoyenneTheorique());

		// Test des grands nombres
		for (int i = 100; i <= NB_ESSAI_MAX; i += 100) {
			List<Double> results = loiUniforme.loiInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(results));
		}
		// Test du KHI2

		// LOI EXPONENTIELLE
		param = MathUtils.rand();
		System.out
				.println("Test de la loi exponnentiel pour un param�tre lambda g�n�r� al�atoirement : "
						+ param);

		LoiExponentielle loiExponentielle = new LoiExponentielle(param);

		System.out.println("Moyenne th�orique = "
				+ loiExponentielle.getMoyenneTheorique());

		// Test des grands nombres
		for (int i = 100; i <= NB_ESSAI_MAX; i += 100) {
			List<Double> results = loiExponentielle.loiInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(results));
		}
		// Test du KHI2

		// LOI NORMALE
		param = MathUtils.rand();
		param2 = MathUtils.rand();
		System.out
				.println("Test de la loi normale pour un param�tre moyenne g�n�r� al�atoirement : "
						+ param
						+ "et un param�tre ecart-type g�n�r� al�atoirement "
						+ param2);
		LoiNormale loiNormale = new LoiNormale(param, param2);

		System.out.println("Moyenne th�orique = "
				+ loiNormale.getMoyenneTheorique());

		// Test des grands nombres
		for (int i = 100; i <= NB_ESSAI_MAX; i += 100) {
			List<Double> results = loiNormale.loiInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(results));
		}
		// Test du KHI2

		// LOI DE POISSON
		param = MathUtils.rand();
		System.out
				.println("Test de la loi de poisson pour un param�tre lambda g�n�r� al�atoirement : "
						+ param);
		LoiDePoisson loiDePoisson = new LoiDePoisson(param);

		System.out.println("Moyenne th�orique = "
				+ loiDePoisson.getMoyenneTheorique());

		// Test des grands nombres
		for (int i = 100; i <= NB_ESSAI_MAX; i += 100) {
			List<Double> results = loiDePoisson.loiInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(results));
		}
		// Test du KHI2

		// LOI DE WEIBULL
		param = MathUtils.rand();
		param2 = MathUtils.rand();
		System.out
				.println("Test de la loi exponnentiel pour un param�tre lambda g�n�r� al�atoirement : "
						+ param
						+ " et de param�tre k g�n�r� al�atoirement"
						+ param2);
		LoiDeWeibull loiDeWeibull = new LoiDeWeibull(param, param2);

		System.out.println("Moyenne th�orique = "
				+ loiDeWeibull.getMoyenneTheorique());

		// Test des grands nombres
		for (int i = 100; i <= NB_ESSAI_MAX; i += 100) {
			List<Double> results = loiDeWeibull.loiInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(results));
		}
		// Test du KHI2

	}
}
