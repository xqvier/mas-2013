/**
 * 
 */
package prob.khi2;

import java.util.List;

/**
 * Represente le resultat d'un test Khi2
 */
public final class ResultKhi2 {

	/**
	 * Khi2 calculé durant le test
	 */
	private double khi2;
	
	/**
	 * Marge d'erreur 
	 */
	private double margeErreur;
	
	/**
	 * Seuil
	 */
	private double seuil;
	
	/**
	 * Tirage experimental
	 */
	private List<Double> tirageExperimental;

	/**
	 * @param tirageExperimental
	 * @param khi2
	 * @param margeErreur
	 * @param seuil
	 */
	public ResultKhi2(List<Double> tirageExperimental, double khi2,
			double margeErreur, double seuil) {
		super();
		this.tirageExperimental = tirageExperimental;
		this.khi2 = khi2;
		this.margeErreur = margeErreur;
		this.seuil = seuil;
	}
	
	/**
	 * Le test est t-il valide en focntion du seuil d'erreur
	 * @return
	 */
	public boolean isValid(){
		return margeErreur < seuil;
	}

	/**
	 * @return the khi2
	 */
	public double getKhi2() {
		return khi2;
	}

	/**
	 * @return the margeErreur
	 */
	public double getMargeErreur() {
		return margeErreur;
	}

	/**
	 * @return the seuil
	 */
	public double getSeuil() {
		return seuil;
	}

	/**
	 * @return the tirageExperimental
	 */
	public List<Double> getTirageExperimental() {
		return tirageExperimental;
	}
	
}
