package prob.generator;
public class ExponentialGenerator extends AbstractGenerator {
    
    private double lambda;
    
    public ExponentialGenerator(double lambda) {
    	super();
        this.lambda = lambda;
    }

    @Override
    public double nextDouble() {
        double y = rand.nextDouble();
        return (-1.0 / lambda) * Math.log(1.0 - y);
    }

    @Override
    public double getTheory(double x) {
        return 1.0 - Math.exp(-1 * lambda * x);
    }
    
    public double getLambda() {
        return this.lambda;
    }

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
			this.maxSupport = super.chercherValeur(this, 0, 0.99);
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
		return "Loi expondentielle";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Expoentielle -  Lambda="+lambda;
	}
	
}
