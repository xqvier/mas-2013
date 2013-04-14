package prob.generator;

public class WeibullGenerator extends AbstractGenerator {

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
	 * @param k /k > 0 est le paramètre de forme
	 * @param  λ > 0 le paramètre d'échelle de la distribution.
	 */
	public WeibullGenerator(double k, double l) {
		super();
		this.kForme = k;
		this.lambda = l;
	}

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
	 * Lent � calculer, donc memeorisation
	 */
	private Double maxSupport = Double.NaN;
	
	/* (non-Javadoc)
	 * @see prob.generator.Generator#getMaxSupport()
	 */
	@Override
	public double getMaxSupport() {
		//la fonction de repartiton tend vers 1 sans l'atteindre.
		//On commence � rechercher la fin de l'intervalle
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
}
