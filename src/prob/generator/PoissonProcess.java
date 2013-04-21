package prob.generator;

import java.util.ArrayList;
import java.util.LinkedList;



public class PoissonProcess {
		
	/** Attributs de classe */
	private int deltaT; // intervalle de tempx pour compter
	private double lambda;
	private int nbTirages ; //nombre de deltaT
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private LoiExponentielle expGen;
		

	public PoissonProcess(int pDeltaT, double pLambda, int pNbTirage) {
		this.deltaT = pDeltaT;
		this.lambda = pLambda;
		this.nbTirages = pNbTirage;
		expGen = new LoiExponentielle(pLambda);
	}
	
	public ArrayList<Integer> poissonProcessRandom(){
		int result = 0;
		double pas = 0.0;
		for (int numInterval = 1 ; numInterval < nbTirages ; numInterval++) {
			while ((pas += expGen.random()) < deltaT*numInterval) {
				result++;
				System.out.println(pas);
			}
			list.add(result);
			result = 0;
		}
		return list;
	}
	

	
	public static void main (String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		PoissonProcess processusDePoisson = new PoissonProcess(20, 0.5, 5);
		list = processusDePoisson.poissonProcessRandom();
		System.out.println(list.toString());
		
	}
	
	
}
