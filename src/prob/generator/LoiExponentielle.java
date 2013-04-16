package prob.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * G�n�rateur de la loi exponentielle.
 * 
 * @author Axel Lormeau
 * @author Xavier Mourgues
 */
public class LoiExponentielle extends AbstractLoi {
	private double lambda;

	/**
	 * Constructeur prennant le param�tre lambda de la loi en param�tre.
	 * 
	 * @param pLambda
	 *            le param�tre lambda de la loi
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


}