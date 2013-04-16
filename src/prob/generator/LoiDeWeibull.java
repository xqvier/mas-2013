package prob.generator;

public class LoiDeWeibull extends AbstractLoi {

	/**
	 * paramètre lambda de la loi de Weibull
	 */
	private double lambda;

	/**
	 * paramètre k de la loi de Weibull
	 */
	private double k;

	public LoiDeWeibull(double pLambda, double pK) {
		lambda = pLambda;
		k = pK;
	}

	@Override
	public double getMoyenneTheorique() {
		return lambda * MathUtils.gamma(1 + 1 / k);
	}

	@Override
	public double loiInverse() {
		return Math.pow(-Math.log(1.0 - MathUtils.rand()), 1.0 / k) / lambda;
	}

}
