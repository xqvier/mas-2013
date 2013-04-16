package prob.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Générateur de la loi exponentielle.
 * 
 * @author Axel Lormeau
 * @author Xavier Mourgues
 */
public class LoiExponentielle extends AbstractLoi {
	private double lambda;

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
	public double loiInverse() {
		
		return (-1.0 / lambda) * Math.log(1.0 - MathUtils.rand());
	}


}
