package prob.generator;

import java.util.List;

/**
 * Générateur de la loi exponentielle.
 * 
 * @author Axel Lormeau
 * @author Xavier Mourgues
 */
public class LoiExponentielle extends AbstractLoi {
	private double lambda;
	private Double maxSupport = Double.NaN;

	/**
	 * Constructeur prennant le paramètre lambda de la loi en paramètre.
	 * 
	 * @param pLambda
	 *            le paramètre lambda de la loi
	 */
	public LoiExponentielle(double pLambda) {
		lambda = pLambda;
	}

	@Override
	public double getMoyenneTheorique() {
		return 1.0 / lambda;
	}

	@Override
	public double random() {

		return (-1.0 / lambda) * Math.log(1.0 - MathUtils.rand());
	}

	@Override
	public int getParamLoi() {
		return 0;
	}

	@Override
	public double loi(double x) {
		return 1.0 - Math.exp(-1 * lambda * x);
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
		if (this.maxSupport.equals(Double.NaN)) {
			this.maxSupport = super.chercherValeur(this, 0, 0.99);
		}

		return this.maxSupport;
	}
}
