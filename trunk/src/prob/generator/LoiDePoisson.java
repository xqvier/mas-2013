package prob.generator;

public class LoiDePoisson extends AbstractLoi {

	/**
	 * paramètre lambda de la loi de Poisson
	 */
	private double lambda;

	/**
	 * intervalle de la loi de Poisson
	 */
	private double intervalle;

	/**
	 * Loi exponentielle pour générer le nombre d'évenement dans une intervalle
	 */
	private LoiExponentielle loiExponentielle;

	public LoiDePoisson(double pLambda) {
		lambda = pLambda;
		double lambdaExponentielle = MathUtils.rand();
		loiExponentielle = new LoiExponentielle(lambdaExponentielle);
		intervalle = lambda / lambdaExponentielle;
	}

	@Override
	public double getMoyenneTheorique() {
		return lambda;
	}

	@Override
	public double random() {
		int i = 0;
		double sum = 0.0;
		while (sum < intervalle) {
			sum += loiExponentielle.random();
			i++;
		}

		return i - 1;
	}

	@Override
	public int getParamLoi() {
		return 0;
	}

	@Override
	public double loi(double x) {
		int xEntier = (int) Math.ceil(x);

		double value = 0;
		for (int i = 0; i <= xEntier; i++) {
			double inc = Math.pow(lambda, i) * Math.exp(-lambda)
					/ MathUtils.fact(i);

			value += inc;
		}

		return value;
	}

	@Override
	public boolean isDiscret() {
		return true;
	}

	@Override
	public double getBorneMin() {
		return 0;
	}

	@Override
	public double getBorneMax() {
		int cpt = 0;
		// Condtion de limite flottante + marge cumul
		while (loi(cpt) != loi(cpt + 1) && loi(cpt) < 0.99) {
			cpt++;
		}
		return cpt;
	}

}
