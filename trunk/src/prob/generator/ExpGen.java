package prob.generator;

/**
 * Classe de génération de nombre aléatoires suivant la loi exponentielle
 * Proprietés mathématiques de la loi
 * Parametres Lambda, elle est définie sur I = [0, POSITIVE_INFINITE]
 * x = -1/Lambda*ln(1-y) avec  0.0 <= y < 1.0 
 * @author axel lormeau
 * @author mourgues xavier
 *
 */
public class ExpGen extends AbstractGen {
    
	/** Parametre de la loi */
    private double lambda;
    
    /** Contructeur de générateur de nombre alétoire suivant la loi exponentielle de parametre lambda */
    public ExpGen(double lambda) {
    	super();
        this.lambda = lambda;
    }

    /**
     * Génération du nombre aléatoire 
     * @return nombre aléatoire suivant la loi choisie
     */
    @Override
    public double nextDouble() {
        double y = rand.nextDouble();
        return (-1.0 / lambda) * Math.log(1.0 - y);
    }

    /**
     * Fonction de répartition
     */
    @Override
    public double getTheory(double x) {
        return 1.0 - Math.exp(-1 * lambda * x);
    }
    
    /**
     * Retourne le parametre Lambda pour ce générateur
     * @return
     */
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

	/**
	 * Nombre de degre à retrancher lors du test du Khi2
	 */
	@Override
	public int getParamLoi() {
		return 0;
	}

	/**
	 * Indique si la loi est discrete
	 */
	@Override
	public boolean estDiscret() {
		return false;
	}

	/**
	 * Retourne le nom de la loi au
	 * @return nom de la loi (String)
	 */
	@Override
	public String getNomLoi() {
		return "Loi expondentielle";
	}
	
	/**
	 * retourne le nom de la loi, ainsi que le parametre de cette loi
	 */
	@Override
	public String toString() {
		return "Expoentielle -  Lambda="+lambda;
	}
	
}
