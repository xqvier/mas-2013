package prob.generator;

/**
 * Classe de g�n�ration de nombre al�atoires suivant la loi exponentielle
 * Propriet�s math�matiques de la loi
 * Parametres Lambda, elle est d�finie sur I = [0, POSITIVE_INFINITE]
 * x = -1/Lambda*ln(1-y) avec  0.0 <= y < 1.0 
 * @author axel lormeau
 * @author mourgues xavier
 *
 */
public class ExpGen extends AbstractGen {
    
	/** Parametre de la loi */
    private double lambda;
    
    /** Contructeur de g�n�rateur de nombre al�toire suivant la loi exponentielle de parametre lambda */
    public ExpGen(double lambda) {
    	super();
        this.lambda = lambda;
    }

    /**
     * G�n�ration du nombre al�atoire 
     * @return nombre al�atoire suivant la loi choisie
     */
    @Override
    public double nextDouble() {
        double y = rand.nextDouble();
        return (-1.0 / lambda) * Math.log(1.0 - y);
    }

    /**
     * Fonction de r�partition
     */
    @Override
    public double getTheory(double x) {
        return 1.0 - Math.exp(-1 * lambda * x);
    }
    
    /**
     * Retourne le parametre Lambda pour ce g�n�rateur
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
			this.maxSupport = super.chercherValeur(this, 0, 0.99);
		}
		
		return this.maxSupport;
	}

	/**
	 * Nombre de degre � retrancher lors du test du Khi2
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
