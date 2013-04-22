package prob.generator;

import java.util.ArrayList;
import java.util.List;

public class PoissonProcess {

	/** Attributs de classe */
	private int deltaT; // intervalle de tempx pour compter
	private int nbTirages; // nombre de deltaT
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private LoiExponentielle expGen;
	private List<Double> tirageExponentielle;

	public PoissonProcess(int pDeltaT, double pLambda, int pNbTirage) {
		this.deltaT = pDeltaT;
		this.nbTirages = pNbTirage;
		expGen = new LoiExponentielle(pLambda);
	}

	public ArrayList<Integer> poissonProcessRandom() {
		int result = 0;
		double pas = 0.0;
		tirageExponentielle = expGen.randomInverse(nbTirages * 20);
		for (Double exp : tirageExponentielle) {

			if (list.size() != nbTirages) {
				if (pas > deltaT) {
					list.add(result);
					result = 0;
					pas = 0.0;
				} else {
					result++;
					pas += exp;
				}
			}

		}
		return list;
	}

	public List<Double> getTirageExponentielle() {
		return tirageExponentielle;
	}

	public int getDeltaT() {
		return deltaT;
	}

	public int getNbTirages() {
		return nbTirages;
	}

}
