package prob.generator;

import java.util.List;

/**
 * Interface de générateur de nombres aléatoires
 */
public interface Generator {
	
	/**
	 * Retourne un nombre aléatiore suivant le generateur aléatoire choisi
	 * @return Nombre aléatoire généré entre 0 et 1 (non compris)
	 */
	public double nextDouble();
	
	/**
	 * Retourne la probabilité que X<=x
	 * @param x seuil
	 * @return Probabilite d'avoir une valeur inferieur ou egal à x (suivant la fonction de répartition
	 */
	public double getTheory(double x);
	
	/**
	 * Retourne la limite inferieure pour l'etude de ce générateur
	 * @return limite inférieure pour ce générateur
	 */
	public double getMinSupport();
	
	/**
	 * Retourne la limite superieure pour l'etude de ce générateur
	 * @return  limite superieure pour ce générateur
	 */
	public double getMaxSupport();
	
	/**
	 * @return Nombre de degrés à retrancher lors du test du Khi2
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
	 * Tire une liste de nb nombre aléaoire
	 * @param nb Un de nombre à tirer
	 * @return nb nombre aléatoires dans une Liste<Double>
	 */
	public List<Double> nextDoubles(int nb);
}
