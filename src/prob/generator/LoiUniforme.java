package prob.generator;


public class LoiUniforme extends AbstractLoi {

	/**
	 * param�tre a de la loi uniforme (min)
	 */
	private double min;

	/**
	 * param�tre b de la loi uniforme (max)
	 */
	private double max;

	public LoiUniforme(double pMin, double pMax) {
		min = pMin;
		max = pMax;
	}

	@Override
	public double getMoyenneTheorique() {
		return (min + max) / 2;
	}

	@Override
	public double loiInverse() {
		return min + (MathUtils.rand() * (max - min));
	}

}
