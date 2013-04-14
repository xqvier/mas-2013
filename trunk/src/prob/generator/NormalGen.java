package prob.generator;

/**
 * Classe de g�n�ration de nombre al�atoires suivant la loi normale Propriet�s
 * math�matiques de la loi De moyenne moyenne et �cart-type ecartType d�finie
 * sur I = [NEGATIVE_INFINITE, POSITIVE_INFINITE]
 * 
 * @author axel lormeau
 * @author mourgues xavier
 * 
 */
public class NormalGen extends AbstractGen {

	/**
	 * Moyenne de la loi normale
	 */
	private double moyenne;

	/**
	 * Ecart type de la loi normale
	 */
	private double ecartType;

	/**
	 * Constructeur de g�n�rateur de la loi normale
	 * 
	 * @param moyenne
	 *            moyenne de la loi normale g�n�r�e
	 * @param ecartType
	 *            ecart type de la loi normale g�n�r�e
	 */
	public NormalGen(double moyenne, double ecartType) {
		super();
		this.moyenne = moyenne;
		this.ecartType = ecartType;
	}

	/**
	 * G�n�ration du nombre al�atoire
	 * 
	 * @return nombre al�atoire suivant la loi choisie
	 */
	@Override
	public double nextDouble() {
		double u = rand.nextDouble();
		double v = rand.nextDouble();
		// variable al�atoire normale centr�e r�duite ind�pendante servant �
		// g�n�rer une variable suivant la loi normale
		double xNormale = Math.sqrt(-2.0 * Math.log(u))
				* Math.cos(2.0 * Math.PI * v);
		// variable g�n�r�e suivant la loi normale
		double variableGeneree = xNormale * ecartType + moyenne;
		return variableGeneree;
	}

	/**
	 * Fonction de r�partition
	 */
	@Override
	public double getTheory(double x) {
		// Correction pour prendre en compte les loi non centree reduite
		x = x / ecartType - moyenne;

		// Il s'agit d'une approximation, on restraint le domaine
		double th = 0.5 + 1.0 / (Math.sqrt(2.0 * Math.PI))
				* (x - Math.pow(x, 3.0) / 6.0 + Math.pow(x, 5.0) / 40.0);
		if (th <= 0.0) {
			th = 0.0;
		} else if (th >= 1.0) {
			th = 1.0;
		}
		return th;
	}

	/**
	 * Lent � calculer, donc memeorisation
	 */
	private Double minSupport = Double.NaN;

	/*
	 * (non-Javadoc)
	 * 
	 * @see prob.generator.Generator#getMinSupport()
	 */
	@Override
	public double getMinSupport() {
		// la fonction de repartiton tend vers 1 sans l'atteindre.
		// On commence � rechercher la fin de l'intervalle
		if (this.minSupport.equals(Double.NaN)) {
			this.minSupport = super.chercherValeur(this, 0.0, 0.0001);
		}

		return -2;
	}

	/**
	 * Lent � calculer, donc memeorisation
	 */
	private Double maxSupport = Double.NaN;

	/*
	 * (non-Javadoc)
	 * 
	 * @see prob.generator.Generator#getMaxSupport()
	 */
	@Override
	public double getMaxSupport() {
		// la fonction de repartiton tend vers 1 sans l'atteindre.
		// On commence � rechercher la fin de l'intervalle
		if (this.maxSupport.equals(Double.NaN)) {
			this.maxSupport = super.chercherValeur(this, 0, 0.9999);
		}

		return this.maxSupport;
	}

	@Override
	public int getParamLoi() {
		return 2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see prob.generator.Generator#estDiscret()
	 */
	@Override
	public boolean estDiscret() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see prob.generator.Generator#getNomLoi()
	 */
	@Override
	public String getNomLoi() {
		return "Loi Normale";
	}

	/**
	 * @return the moyenne
	 */
	public double getMoyenne() {
		return moyenne;
	}

	/**
	 * @return the ecartType
	 */
	public double getEcartType() {
		return ecartType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Normale - Moyenne=" + moyenne + " EcartType=" + ecartType;
	}

	@Override
	public double getMoyenneTheorique(int nb) {
		return moyenne;
	}

}
