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
				.println("Test de la loi uniforme pour un paramètre min = 1 et max = 2");
		LoiUniforme loiUniforme = new LoiUniforme(1, 2);

		System.out.println("Moyenne théorique = "
				+ loiUniforme.getMoyenneTheorique());

		// Test des grands nombres
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiUniforme.randomInverse(i);
			System.out.println("Moyenne réelle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2		
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiUniforme, resultsGeneres));
		
		

		// LOI EXPONENTIELLE
		param = MathUtils.rand();
		System.out
				.println("Test de la loi exponnentiel pour un paramètre lambda généré aléatoirement : "
						+ param);

		LoiExponentielle loiExponentielle = new LoiExponentielle(param);

		System.out.println("Moyenne théorique = "
				+ loiExponentielle.getMoyenneTheorique());

		// Test des grands nombres
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiExponentielle.randomInverse(i);
			System.out.println("Moyenne réelle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2		
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiExponentielle, resultsGeneres));

		// LOI NORMALE
		param = MathUtils.rand();
		param2 = MathUtils.rand();
		System.out
				.println("Test de la loi normale pour un paramètre moyenne généré aléatoirement : "
						+ param
						+ "et un paramètre ecart-type généré aléatoirement "
						+ param2);
		LoiNormale loiNormale = new LoiNormale(param, param2);

		System.out.println("Moyenne théorique = "
				+ loiNormale.getMoyenneTheorique());

		// Test des grands nombres
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiNormale.randomInverse(i);
			System.out.println("Moyenne réelle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2		
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiNormale, resultsGeneres));
		
		// LOI DE POISSON
		param = MathUtils.rand();
		System.out
				.println("Test de la loi de poisson pour un paramètre lambda généré aléatoirement : "
						+ param);
		LoiDePoisson loiDePoisson = new LoiDePoisson(param);

		System.out.println("Moyenne théorique = "
				+ loiDePoisson.getMoyenneTheorique());

		// Test des grands nombres
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiDePoisson.randomInverse(i);
			System.out.println("Moyenne réelle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2		
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiDePoisson, resultsGeneres));
		
		// LOI DE WEIBULL
		param = MathUtils.rand();
		param2 = MathUtils.rand();
		System.out
				.println("Test de la loi exponnentiel pour un paramètre lambda généré aléatoirement : "
						+ param
						+ " et de paramètre k généré aléatoirement"
						+ param2);
		LoiDeWeibull loiDeWeibull = new LoiDeWeibull(param, param2);

		System.out.println("Moyenne théorique = "
				+ loiDeWeibull.getMoyenneTheorique());

		// Test des grands nombres
		for (i = 100; i <= NB_ESSAI_MAX; i += 100) {
			resultsGeneres = loiDeWeibull.randomInverse(i);
			System.out.println("Moyenne réelle (pour " + i + " essais) = "
					+ MathUtils.moyenne(resultsGeneres));
		}
		// Test du KHI2
		System.out.println("L'indicateur du khi2 est : " +MathUtils.calculIndicateurKhi2(loiDeWeibull, resultsGeneres));

	}
}
