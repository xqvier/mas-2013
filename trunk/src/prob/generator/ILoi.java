package prob.generator;

import java.util.List;

public interface ILoi {
	/**
	 * Retourne la moyenne th�orique de la loi.
	 * 
	 * @return la moyenne th�orique
	 */
	public double getMoyenneTheorique();

	/**
	 * Retourne la valeur x du nombre y pass� en param�tre suivant la loi
	 * inverse
	 * 
	 * @return la valeur associ� au nombre y de la loi inverse.
	 */
	public double random();

	/**
	 * Retourne une s�rie g�n�r�e par la loi inverse en g�n�rant plusieurs
	 * nombres al�atoires.
	 * 
	 * @param pNbAGenere
	 *            Le nombre d'�v�nements � g�n�rer
	 * @return la s�rie g�n�r�e
	 */
	public List<Double> loiInverse(int pNbAGenere);

	public double loi(double x);

	public int getParamLoi();

	public boolean isDiscret();

	public double getBorneMin();

	public double getBorneMax();
}
