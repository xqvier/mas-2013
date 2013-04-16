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
		List<Double> resultsGeneres = null;
		List<Double> resultsTheoriques;
		// LOI UNIFORME
		double param = MathUtils.rand();
		double param2;
		do {
			param2 = MathUtils.rand();
		} while (param2 <= param);
		int i;

		System.out
				.println("Test de la loi uniforme pour un param�tre min = 1 et max = 2");
		LoiUniforme loiUniforme = new LoiUniforme(1, 2);

		System.out.println("Moyenne th�orique = "
				+ loiUniforme.getMoyenneTheorique());

		// Test des grands nombres
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiUniforme.randomInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2		
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiUniforme, resultsGeneres));
		
		

		// LOI EXPONENTIELLE
		param = MathUtils.rand();
		System.out
				.println("Test de la loi exponnentiel pour un param�tre lambda g�n�r� al�atoirement : "
						+ param);

		LoiExponentielle loiExponentielle = new LoiExponentielle(param);

		System.out.println("Moyenne th�orique = "
				+ loiExponentielle.getMoyenneTheorique());

		// Test des grands nombres
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiExponentielle.randomInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2		
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiExponentielle, resultsGeneres));

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
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiNormale.randomInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2		
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiNormale, resultsGeneres));
		
		// LOI DE POISSON
		param = MathUtils.rand();
		System.out
				.println("Test de la loi de poisson pour un param�tre lambda g�n�r� al�atoirement : "
						+ param);
		LoiDePoisson loiDePoisson = new LoiDePoisson(param);

		System.out.println("Moyenne th�orique = "
				+ loiDePoisson.getMoyenneTheorique());

		// Test des grands nombres
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiDePoisson.randomInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2		
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiDePoisson, resultsGeneres));
		
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
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiDeWeibull.randomInverse(i);
			System.out.println("Moyenne r�elle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiDeWeibull, resultsGeneres));

	}
}
