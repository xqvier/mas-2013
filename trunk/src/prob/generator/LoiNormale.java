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
