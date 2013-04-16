import java.util.List;

import prob.generator.LoiExponentielle;
import prob.generator.MathUtils;

public class Main {

	private static final int NB_ESSAI_MAX = 1000;

	public static void main(String[] args) {

		double param = MathUtils.rand();
		System.out
				.println("Test de la loi exponnentiel pour un paramètre lambda généré aléatoirement : "
						+ param);
		LoiExponentielle loiExponentielle = new LoiExponentielle(param);

		System.out.println("Moyenne théorique = "
				+ loiExponentielle.getMoyenneTheorique());

		// Test des grands nombres
		for (int i = 100; i <= NB_ESSAI_MAX; i += 100) {
			List<Double> results = loiExponentielle
					.loiInverse(i);
			System.out.println("Moyenne réelle (pour " + i + " essais) = "
					+ MathUtils.moyenne(results));
		}
		// Test du KHI2
		

		// Generator gen = new UniformGen(0, 1);
		// CalculKhi2 khi2 = new CalculKhi2(gen);
		// List<Double> results = gen.nextDoubles(251);
		//
		// // Test nb aleatoire
		//
		// System.out.println(results);
		//
		// // Test loi uniforme
		//
		// gen = new UniformGen(1, 2);
		// results = gen.nextDoubles(251);
		// khi2.setTirage(results);
		// System.out.println("Test de la loi : " + gen);
		//
		// System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());
		//
		// for (int i = 50; i < results.size(); i += 50) {
		//
		// System.out.println("valeur moyenne pour " + i + " :");
		// System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
		// System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		// }
		//
		// // test loi exponentielle
		//
		// gen = new ExpGen(0.8);
		// results = gen.nextDoubles(251);
		// khi2.setTirage(results);
		// System.out.println("Test de la loi : " + gen);
		//
		// System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());
		//
		// for (int i = 50; i < results.size(); i += 50) {
		//
		// System.out.println("valeur moyenne pour " + i + " :");
		// System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
		// System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		// }
		//
		// // Test loi normale
		// gen = new NormalGen(0.4, 0.02);
		// results = gen.nextDoubles(251);
		// khi2.setTirage(results);
		// System.out.println("Test de la loi : " + gen);
		//
		// System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());
		//
		// for (int i = 50; i < results.size(); i += 50) {
		//
		// System.out.println("valeur moyenne pour " + i + " :");
		// System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
		// System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		// }
		//
		//
		// // Test loi de poisson
		// gen = new PoissonGen(0.4);
		// results = gen.nextDoubles(251);
		// khi2.setTirage(results);
		// System.out.println("Test de la loi : " + gen);
		//
		// System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());
		//
		// for (int i = 50; i < results.size(); i += 50) {
		//
		// System.out.println("valeur moyenne pour " + i + " :");
		// System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
		// System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		// }
		//
		// // Test loi de Weibull
		// gen = new WeibullGen(2, 0.8);
		// results = gen.nextDoubles(251);
		// khi2.setTirage(results);
		// System.out.println("Test de la loi : " + gen);
		//
		// System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());
		//
		// for (int i = 50; i < results.size(); i += 50) {
		//
		// System.out.println("valeur moyenne pour " + i + " :");
		// System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
		// System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		// }

	}
}
