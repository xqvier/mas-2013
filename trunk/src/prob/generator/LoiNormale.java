package prob.generator;

public class LoiNormale extends AbstractLoi {

	/**
	 * paramètre m de la loi normale (moyenne)
	 */
	private double moyenne;

	/**
	 * paramètre teta de la loi normal (écart-type)
	 */
	private double ecartType;

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

}
