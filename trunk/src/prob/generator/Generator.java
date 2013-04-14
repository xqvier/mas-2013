package prob.generator;

import java.util.List;

/**
 * Interface de g�n�rateur de nombres al�atoires
 */
public interface Generator {
	
	/**
	 * Retourne un nombre al�atiore suivant le generateur al�atoire choisi
	 * @return Nombre al�atoire g�n�r� entre 0 et 1 (non compris)
	 */
	public double nextDouble();
	
	/**
	 * Retourne la probabilit� que X<=x
	 * @param x seuil
	 * @return Probabilite d'avoir une valeur inferieur ou egal � x (suivant la fonction de r�partition
	 */
	public double getTheory(double x);
	
	/**
	 * Retourne la limite inferieure pour l'etude de ce g�n�rateur
	 * @return limite inf�rieure pour ce g�n�rateur
	 */
	public double getMinSupport();
	
	/**
	 * Retourne la limite superieure pour l'etude de ce g�n�rateur
	 * @return  limite superieure pour ce g�n�rateur
	 */
	public double getMaxSupport();
	
	/**
	 * @return Nombre de degr�s � retrancher lors du test du Khi2
	 */
	public int getParamLoi();
	
	/**
	 * Indique si la loi est discrete
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
	 * @return nb nombre al�atoires dans une Liste<Double>
	 */
	public List<Double> nextDoubles(int nb);
}
