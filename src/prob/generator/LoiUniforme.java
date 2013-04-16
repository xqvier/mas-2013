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
	public double random() {
		return min + (MathUtils.rand() * (max - min));
	}

	@Override
	public int getParamLoi() {
		return 0;
	}

	@Override
	public double loi(double x) {
		return (x - min) / (max - min);
	}

	@Override
	public boolean isDiscret() {
		return false;
	}

	@Override
	public double getBorneMin() {
		return min;
	}

	@Override
	public double getBorneMax() {
		return max;
	}

}
