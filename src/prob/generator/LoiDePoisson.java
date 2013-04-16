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
	public double loiInverse() {
		int i = 0;
		double sum = 0.0;
		while (sum < intervalle) {
			sum += loiExponentielle.loiInverse();
			i++;
		}

		return i - 1;
	}

}
