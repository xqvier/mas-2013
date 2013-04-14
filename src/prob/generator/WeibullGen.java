package prob.generator;

import cern.jet.stat.Gamma;


/**
 * Classe de génération de nombre aléatoires suivant la loi de Weibull

 * @author axel lormeau
 * @author mourgues xavier
 *
 */
public class WeibullGen extends AbstractGen {

	/**
	 * Parametre de forme
	 */
	private double kForme;
	
	/***
	 * Lamda, echelle de la distribution
	 */
	private double lambda;
	
	/**
	 * Generateur de weinbull
	 * @param k /k > 0 est le parametre de forme
	 * @param  l (lambda) echelle de la distribution.
	 */
	public WeibullGen(double k, double l) {
		super();
		this.kForme = k;
		this.lambda = l;
	}

	/**
     * Génération du nombre aléatoire
     * @return nombre aléatoire suivant la loi choisie 
     */
	@Override
	public double nextDouble() {		
		double x = super.rand.nextDouble();
		return Math.pow(-Math.log(1.0-x),1.0/kForme)/lambda;
	}

	@Override
	public double getTheory(double x) {
		//a = l et b = k)
		double value = 1.0- Math.exp(-1.0*Math.pow(x*lambda,kForme));
		return value;
	}

	/* (non-Javadoc)
	 * @see prob.generator.Generator#getMinSupport()
	 */
	@Override
	public double getMinSupport() {
		return 0;
	}

	/**
	 * Lent à calculer, donc memeorisation
	 */
	private Double maxSupport = Double.NaN;
	
	/* (non-Javadoc)
	 * @see prob.generator.Generator#getMaxSupport()
	 */
	@Override
	public double getMaxSupport() {
		//la fonction de repartiton tend vers 1 sans l'atteindre.
		//On commence à rechercher la fin de l'intervalle
		if (this.maxSupport.equals(Double.NaN)){
			this.maxSupport = super.chercherValeur(this, 0,0.99);
		}
		
		return this.maxSupport;
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
		return "Loi de Weibull";
	}

	/**
	 * @return the kForme
	 */
	public double getkForme() {
		return kForme;
	}

	/**
	 * @return the lambda
	 */
	public double getLambda() {
		return lambda;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weibull -  PForme="+kForme+ " Lambda="+lambda;
	}

	@Override
	public double getMoyenneTheorique(int nb) {
		return lambda * Gamma.gamma(1.0 + 1.0 / kForme);
	}
	
	
}
