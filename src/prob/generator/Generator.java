package prob.generator;

import java.util.List;

/**
 * 
 */

/**
 * Interface principale d'un generateur al�atoire
 * @author CnCBoy
 */
public interface Generator {
	
	/**
	 * Retourne une valeur conforme au generateur al�atoire
	 * @return Valeur du generateur entre 0 et 1
	 */
	public double nextDouble();
	
	/**
	 * Retourne la valeur P((X<=x) de la fonction de repartion
	 * @param x seuil
	 * @return Probabilite d'avoir une valeur inferieur ou egal � x
	 */
	public double getTheory(double x);
	
	/**
	 * Retourne la limite inferieure pour l'etude de ce generateur
	 * @return 
	 */
	public double getMinSupport();
	
	/**
	 * Retourne la limite superieure pour l'etude de ce generateur
	 * @return 
	 */
	public double getMaxSupport();
	
	/**
	 * Obtient le nombre de degre � retrancher lors du test du Khi2
	 */
	public int getParamLoi();
	
	/**
	 * Indique que la loi est discrete
	 * @return
	 */
	public boolean estDiscret();
	
	/**
	 * Retourne le nom de la loi
	 * @return
	 */
	public String getNomLoi();
	
	/**
	 * Tire une liste de nb nombre al�aoire
	 * @param nb Un de nombre � tirer
	 * @return
	 */
	public List<Double> nextDoubles(int nb);
}
