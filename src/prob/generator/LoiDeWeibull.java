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
	

	private Double maxSupport = Double.NaN;

	public LoiDeWeibull(double pLambda, double pK) {
		lambda = pLambda;
		k = pK;
	}

	@Override
	public double getMoyenneTheorique() {
		return lambda * MathUtils.gamma(1 + 1 / k);
	}

	@Override
	public double random() {
		return Math.pow(-Math.log(1.0 - MathUtils.rand()), 1.0 / k) / lambda;
	}

	@Override
	public int getParamLoi() {
		return 0;
	}

	@Override
	public double loi(double x) {
		double value = 1.0- Math.exp(-1.0*Math.pow(x*lambda,k));
		return value;
	}

	@Override
	public boolean isDiscret() {
		return false;
	}

	@Override
	public double getBorneMin() {
		return 0;
	}

	@Override
	public double getBorneMax() {
		if (this.maxSupport.equals(Double.NaN)){
			this.maxSupport = super.chercherValeur(this, 0,0.99);
		}
		
		return this.maxSupport;
	}

}
