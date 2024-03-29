package prob.generator;

public class LoiNormale extends AbstractLoi {

	/**
	 * param�tre m de la loi normale (moyenne)
	 */
	private double moyenne;

	/**
	 * param�tre teta de la loi normal (�cart-type)
	 */
	private double ecartType;

	private Double minSupport = Double.NaN;

	private Double maxSupport = Double.NaN;

	public LoiNormale(double pMoyenne, double pEcartType) {
		moyenne = pMoyenne;
		ecartType = pEcartType;
	}

	@Override
	public double getMoyenneTheorique() {
		return moyenne;
	}

	@Override
	public double random() {
		double u = MathUtils.rand();
		double v = MathUtils.rand();
		double xNormal = Math.sqrt(-2.0 * Math.log(u))
				* Math.cos(2.0 * Math.PI * v);

		return xNormal * ecartType + moyenne;
	}

	@Override
	public int getParamLoi() {
		return 2;
	}

	@Override
	public double loi(double x) {
		x = x / ecartType - moyenne;

		double th = 0.5 + 1.0 / (Math.sqrt(2.0 * Math.PI))
				* (x - Math.pow(x, 3.0) / 6.0 + Math.pow(x, 5.0) / 40.0);
		if (th <= 0.0) {
			th = 0.0;
		} else if (th >= 1.0) {
			th = 1.0;
		}
		return th;
	}

	@Override
	public boolean isDiscret() {
		return false;
	}

	@Override
	public double getBorneMin() {
		if (this.minSupport.equals(Double.NaN)) {
			this.minSupport = super.chercherValeur(this, 0.0, 0.0001);
		}

		return -2;
	}

	@Override
	public double getBorneMax() {
		if (this.maxSupport.equals(Double.NaN)) {
			this.maxSupport = super.chercherValeur(this, 0, 0.9999);
		}

		return this.maxSupport;
	}
}
