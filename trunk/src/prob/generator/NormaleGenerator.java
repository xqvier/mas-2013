package prob.generator;
/**
 * 
 */

/**
 * @author a.delevaux
 *
 */
public class NormaleGenerator extends AbstractGenerator {

	/**
	 * la moyenne de la loi normale
	 */
	private double moyenne;
	/**
	 * l'ecart type de la loi normale
	 */
	private double ecartType;
	
	/**
	 * Constructeur de générateur de la loi normale
	 * @param seed  Initialisateur du generateur pseudo-aleatoire
	 * @param moyenne moyenne de la loi normale générée
	 * @param ecartType ecart type de la loi normale générée
	 */
	public NormaleGenerator(double moyenne, double ecartType) {
		super();
		this.moyenne = moyenne;
		this.ecartType = ecartType;
	}

	/* (non-Javadoc)
	 * @see Generator#nextDouble()
	 */
	@Override
	public double nextDouble() {
		//variable aléatoire indépendante uniforme sur [0,1]
		double u = rand.nextDouble();
		///variable aléatoire indépendante uniforme sur [0,1]
		double v = rand.nextDouble();
		//variable aléatoire normale centrée réduite indépendante servant à générer une variable suivant la loi normale
		double xNormale = Math.sqrt(-2.0 * Math.log(u)) * Math.cos(2.0 * Math.PI * v);
		//variable générée suivant la loi normale
		double variableGeneree = xNormale * ecartType + moyenne;
		return variableGeneree;
	}

	/* (non-Javadoc)
	 * @see Generator#getTheory(double)
	 */
	@Override
	public double getTheory(double x) {
		
		//Cette approximation echoue au delas de 2
		
		//Correction pour prendre en compte les loi non centree reduite
		x = x/ecartType-moyenne;
		
		//Il s'agit d'une approximation, on restraint le domaine
		double th =0.5 + 1.0/(Math.sqrt(2.0*Math.PI))*(x-Math.pow(x, 3.0)/6.0+Math.pow(x, 5.0)/40.0);
		if (th<=0.0){
			th=0.0;
		}else if(th>=1.0){
			th=1.0;
		}
		return th;
	}

	/**
	 * Lent à calculer, donc memeorisation
	 */
	private Double minSupport = Double.NaN;
	
	/* (non-Javadoc)
	 * @see prob.generator.Generator#getMinSupport()
	 */
	@Override
	public double getMinSupport() {
		//la fonction de repartiton tend vers 1 sans l'atteindre.
		//On commence à rechercher la fin de l'intervalle
		if (this.minSupport.equals(Double.NaN)){
			this.minSupport = super.chercherValeur(this, 0.0, 0.0001);
		}
		
		return -2;
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
			this.maxSupport = super.chercherValeur(this, 0, 0.9999);
		}
		
		return this.maxSupport;
	}

	@Override
	public int getParamLoi() {
		return 2;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Normale - Moyenne="+moyenne+" EcartType="+ecartType;
	}
	
}
