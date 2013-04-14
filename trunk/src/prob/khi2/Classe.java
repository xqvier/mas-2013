/**
 * 
 */
package prob.khi2;

import java.util.LinkedList;
import java.util.List;

/**
 * Represente une classe
 * @author a.delevaux
 */
public class Classe implements Comparable<Classe> {

	/**
	 * Valeur minimal de la classe
	 */
	private double min;
	
	/***
	 * Valeur maximale de la classe
	 */
	private double max;
	
	/**
	 * Liste des elements de la classe
	 */
	private List<Double> items;
	
	/**
	 * Liste 
	 * @param min
	 * @param max
	 */
	public Classe(double min,double max){
		this.min = min;
		this.max = max;
		items = new LinkedList<Double>();
	}
	
	
	/**
	 * Fusionne deux classes ensembles si possibles
	 * @param classInf Classe avec la borne inferieure la plsu basse
	 * @param classSup Classe avec la borne superieure la plus haute
	 * @return Une classe d'intervalle elargie avec toute les valeurs à l'interieur
	 * @throws Si classe disjointe une erreur est levée
	 */
	public static Classe fusionner(Classe classInf, Classe classSup){
		if (classInf.max != classSup.min){
			throw new RuntimeException("Classe non jointe");	
		}//else
		
		Classe fuse = new Classe(classInf.min, classSup.max);
		fuse.items.addAll(classInf.items);
		fuse.items.addAll(classSup.items);
		
		return fuse;
	}
	
	/**
	 * Retourne la moyenne des bornes de la classe
	 * @return millieu de la classe
	 */
	public double getMoyenneBorne(){
		return min + ((max-min)/2.0);
	}
	
	/**
	 * Nombre d'element dans la classe
	 * @return elements
	 */
	public int getPopulation(){
		return items.size();
	}
	
	/**
	 * Indique si l'element value peut rentrer dans la classe
	 * @param value valeur à tester
	 * @return Si est contenable dans la classe
	 */
	public boolean isInside(double value){
		return value >=min && value < max;
	}
	
	/**
	 * Insere l'element dans la classe
	 * @param value
	 */
	public void insert(double value){
		if (!isInside(value)){
			throw new RuntimeException("L'element ne rentre pas dans la classe");
		}
		items.add(value);
	}

	@Override
	/**
	 * Pour le triage des classes dans l'ordre
	 */
	public int compareTo(Classe another) {
		if (min==another.min && max==another.max){
			return 0;
		}
		
		if (min<another.min){
			return -1;
		}
		return 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "["+this.min+";"+this.max+"[ {"+getPopulation()+"}";
	}
	
	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}
}
