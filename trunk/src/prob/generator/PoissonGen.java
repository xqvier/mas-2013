package prob.generator;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe de génération de nombre aléatoires suivant la loi d
 * Proprietés mathématiques de la loi
 * Parametres Lambda
 * @author axel lormeau
 * @author mourgues xavier
 *
 */
public class PoissonGen extends AbstractGen {
    
    /**
     * Parametre de la loi de poisson
     */
    private double lambdaPoisson;
    
    /**
     * Générateur suivant la loi exponentielle
     */
    private ExpGen exponentialGenerator;
    
    /**
     * Constructeur du générateur de nombres suivant une loi de poisson
     * @param lambda : parametre de la loi de poisson
     */
    public PoissonGen(double lambda) {
    	super();
        this.lambdaPoisson = lambda;
        this.exponentialGenerator = new ExpGen(Math.random());
    }
    
    /**
     * Générateur de nombre aléatoire suivant la loi de Poisson
     * 
     * Cet algorithme se déroule comme ceci : 
     * 1 - génération de nombre aléatoire suivant une loi exponentielle*
     * 2 - lorsque la somme de ces nombres générée est > a la periode T (T = lambdaPoisson/1) l'algo retourne le nombre de valeur générée
     * 3 - Cette valeur N suit alors la loi de poisson du générateur
     */
    @Override
    public double nextDouble() {
        double periode = lambdaPoisson / exponentialGenerator.getLambda();        
        List<Double> exponentialValues = new ArrayList<Double>();        
        while (periode >= sum(exponentialValues)) {
            exponentialValues.add(this.exponentialGenerator.nextDouble());
        }
        return exponentialValues.size() - 1;
    }
    
    

    /**
     * Surcharge de l'implementation pour tenir compte de l'evenement en cours
     * lors de fin du derniers evenement exponentiel
	 */
	
/*	@Override
	public List<Double> nextDoubles(int nb) {
		
		//Periode
		double t = lambdaPoisson / exponentialGenerator.getLambda();
		
		//Liste resultat (pre-dimentionnÃ©e)
		List<Double> poissonValues = new ArrayList<Double>(nb);
		//Temps deja ecoule lors du nouveau tirage
		double report = 0.0;
		//Somme des valeurs exponentielles de la periode
		List<Double> exponentialValues;
		for (int i = 0; i < nb; i++){
		
	        exponentialValues = new ArrayList<Double>();
	        exponentialValues.add(report);
	        
	        while (t >= sum(exponentialValues)) {
	            exponentialValues.add(this.exponentialGenerator.nextDouble());
	        }
	        //Ajout de la valeur
	        poissonValues.add((double) (exponentialValues.size() - 1));
	        report =  sum(exponentialValues) - t;     
		}
        
		
		return poissonValues;
	}
/*

	/**
     * Retourne la probabilité théorique (d'apres l'expression de la loi de Poisson)
     * d'une valeur x
     * @param x : la valeur dont on souhaite la probabilité, doit être un entier
     */
    @Override
    public double getTheory(double x) {
        int xEntier = (int) Math.ceil(x);

        double value = 0;
        for (int i = 0; i <=xEntier; i++){
        	double inc = Math.pow(lambdaPoisson, i)*Math.exp(-lambdaPoisson) / fact(i);

        	value += inc;
        }
        
        return value;
    }
    
    /**
     * Calcul la somme des nombres d'une liste  .
     * @param list liste des nombres dont on veut la somme
     * @return la somme des nombres dans list
     */
    private double sum(List<Double> list) {
        double sum = 0.0;
        for (Double number : list) {
            sum += number;
        }
        return sum;
    }
    
    /**
     * Calcul la factorielle de x
     * @param x
     * @return la factorielle de x
     */
    private double fact(int x) {
    	if (x == 0){    		
    		return 1;
    	}
    	
        int fact = x;
        while (x > 1) {
            x--;
            fact *= x;
        }
        
        return fact;
    }

	@Override
	public double getMinSupport() {
		return 0;
	}

	@Override
	public double getMaxSupport() {
		int cpt =0;
		//Condtion de limite flottante + marge cumul
		while(getTheory(cpt)!= getTheory(cpt+1) && getTheory(cpt) < 0.99){
			cpt++;
		}
		return cpt;
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
		return true;
	}

	/* (non-Javadoc)
	 * @see prob.generator.Generator#getNomLoi()
	 */
	@Override
	public String getNomLoi() {
		return "Loi de poisson";
	}

	/**
	 * @return the lambdaPoisson
	 */
	public double getLambdaPoisson() {
		return lambdaPoisson;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Poisson - Lambda="+lambdaPoisson;
	}
	
}
