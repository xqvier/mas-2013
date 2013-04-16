package prob.generator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLoi implements ILoi {

	public final static double CLASSE_TAILLE = 0.00002;
	
	
	@Override
	public List<Double> randomInverse(int pNbAGenere) {
		ArrayList<Double> results = new ArrayList<>(pNbAGenere);
		for (int i = 0; i < pNbAGenere; i++) {
			results.add(random());
		}
		return results;
	}
	

	@Override
	public List<Double> loi(int pNbAGenere) {
		ArrayList<Double> results = new ArrayList<>(pNbAGenere);
		for (int i = 0; i < pNbAGenere; i++) {
			results.add(loi(CLASSE_TAILLE));
		}
		return results;
	}

	
	/**
	 * Retourne une borne par la laqulle la prob cumulé est atteinte
	 * @param debRch
	 * @return
	 */
	public static double chercherValeur(ILoi loi, double debRch, double cumul){
		double pas = 1.0;
		double oldValue = -1; //utilisation en cas de manque de precision
		double value = debRch;
		double prob = loi.loi(value);
		
		while(oldValue != value &&
				!(prob <= cumul + 0.000001 && prob >= cumul - 0.000001)){
			oldValue = value;
			prob = loi.loi(value);
			//Si devient superieur, inversion du pas
			if (pas >0.0 && prob>cumul){
				pas = pas / -2;
			} else if (pas <0.0 && prob<cumul){
				pas = pas / -2;
			}
			value += pas;
			
		}
		
		return value;
	}
	
	
}
