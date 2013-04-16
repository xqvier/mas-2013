package prob.generator;

import java.util.List;

public interface ILoi {
	/**
	 * Retourne la moyenne théorique de la loi.
	 * 
	 * @return la moyenne théorique
	 */
	public double getMoyenneTheorique();

	/**
	 * Retourne la valeur x du nombre y passé en paramètre suivant la loi
	 * inverse
	 * 
	 * @return la valeur associé au nombre y de la loi inverse.
	 */
	public double random();

	/**
	 * Retourne une série générée par la loi inverse en générant plusieurs
	 * nombres aléatoires.
	 * 
	 * @param pNbAGenere
	 *            Le nombre d'évènements à générer
	 * @return la série générée
	 */
	public List<Double> loiInverse(int pNbAGenere);

	public double loi(double x);

	public int getParamLoi();

	public boolean isDiscret();

	public double getBorneMin();

	public double getBorneMax();
}
