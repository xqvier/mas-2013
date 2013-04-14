import java.util.List;

import prob.generator.ExpGen;
import prob.generator.Generator;
import prob.generator.NormalGen;
import prob.generator.PoissonGen;
import prob.generator.UniformGen;
import prob.generator.WeibullGen;
import prob.khi2.CalculKhi2;

public class Main {
	public static void main(String[] args) {

		Generator gen = new UniformGen(0, 1);
		CalculKhi2 khi2 = new CalculKhi2(gen);
		List<Double> results = gen.nextDoubles(251);

		// Test nb aleatoire

		System.out
				.println("Test de génération de nombre aléatoire (entre 0 et 1)");
		System.out.println(results);

		// Test loi uniforme

		gen = new UniformGen(1, 2);
		results = gen.nextDoubles(251);
		khi2.setTirage(results);
		System.out.println("Test de la loi : " + gen);

		System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());

		for (int i = 50; i < results.size(); i += 50) {

			System.out.println("valeur moyenne pour " + i + " :");
			System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
			System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		}

		// test loi exponentielle

		gen = new ExpGen(0.8);
		results = gen.nextDoubles(251);
		khi2.setTirage(results);
		System.out.println("Test de la loi : " + gen);

		System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());

		for (int i = 50; i < results.size(); i += 50) {

			System.out.println("valeur moyenne pour " + i + " :");
			System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
			System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		}
		
		// Test loi normale
		gen = new NormalGen(0.4, 0.02);
		results = gen.nextDoubles(251);
		khi2.setTirage(results);
		System.out.println("Test de la loi : " + gen);

		System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());

		for (int i = 50; i < results.size(); i += 50) {

			System.out.println("valeur moyenne pour " + i + " :");
			System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
			System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		}
		

		// Test loi de poisson
		gen = new PoissonGen(0.4);
		results = gen.nextDoubles(251);
		khi2.setTirage(results);
		System.out.println("Test de la loi : " + gen);

		System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());

		for (int i = 50; i < results.size(); i += 50) {

			System.out.println("valeur moyenne pour " + i + " :");
			System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
			System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		}

		// Test loi de Weibull
		gen = new WeibullGen(2, 0.8);
		results = gen.nextDoubles(251);
		khi2.setTirage(results);
		System.out.println("Test de la loi : " + gen);

		System.out.println(khi2.compareKhi2TheoriqueKhi2Calcule());

		for (int i = 50; i < results.size(); i += 50) {

			System.out.println("valeur moyenne pour " + i + " :");
			System.out.println(" - théorique : " + gen.getMoyenneTheorique(i));
			System.out.println(" - réelle : " + gen.getMoyenneReelle(i));
		}

	}
}
