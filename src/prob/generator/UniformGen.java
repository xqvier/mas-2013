package prob.generator;


/**
 * Classe de génération de nombre aléatoires suivant la loi Uniforme
 * @author axel lormeau
 * @author mourgues xavier
 *
 */
public class UniformGen extends AbstractGen {

	/**
	 * Abscisse minimale (Probabilite = 0)
	 */
	private double min;
	
	/**
	 * Abscisse minimale (Probabilite = 1)
	 */
	private double max;
	
	/**
	 * Constructeur d'un generateur de loi uniforme
	 * @param seed
	 */
	public UniformGen(double min, double max) {
		super();
		this.min = min;
		this.max = max;
	}

	/**
     * Génération du nombre aléatoire 
     * @return nombre aléatoire suivant la loi choisie
     */
	@Override
	public double nextDouble() {
		//L'implementation par defaut de java retourne des nombres entre 0 et 1
		return rand.nextDouble()*(max-min)+min;
	}

	@Override
	public double getTheory(double x) {
		return (x-min)/(max-min);
	}

	/* (non-Javadoc)
	 * @see prob.generator.Generator#getMinSupport()
	 */
	@Override
	public double getMinSupport() {
		return min;
	}

	/* (non-Javadoc)
	 * @see prob.generator.Generator#getMaxSupport()
	 */
	@Override
	public double getMaxSupport() {
		return max;
	}

	@Override
	public int getParamLoi() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see prob.generator.Generator#estDiscret()
	 */
	@Override
	public boolean estDiscret() {
		return false;
	}

	/* (non-Javadoc)
	 * @see prob.generator.Generator#getNomLoi()
	 */
	@Override
	public String getNomLoi() {
		return "Loi Uniforme";
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Uniforme -  Min="+min+ " Max="+max;
	}

	@Override
	public double getMoyenneTheorique(int nb) {
		return (min + max) / 2;
	}
}
