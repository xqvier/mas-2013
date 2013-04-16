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
	public double loiInverse() {
		
		return (-1.0 / lambda) * Math.log(1.0 - MathUtils.rand());
	}


}
