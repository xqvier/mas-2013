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
	public double loiInverse() {		
		double u = MathUtils.rand();
		double v = MathUtils.rand();
		double xNormal = Math.sqrt(-2 * Math.log(u))*Math.cos(2 * Math.PI * v);
		
		return (xNormal - moyenne) / ecartType;
	}

}
