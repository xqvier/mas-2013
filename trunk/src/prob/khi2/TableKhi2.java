/**
 * 
 */
package prob.khi2;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Retourne le risque d'erreur en fonction du degre de liberte
 * @author a.delevaux
 */
public class TableKhi2 {

	/***
	 * Referentiel
	 */
	private static HashMap<Integer, HashMap<Double,Double>> ref;

	/**
	 * Bloc d'initialisation statique
	 */
	static{
		ref =  new HashMap<Integer, HashMap<Double,Double>>();
		
		//Degré 1
		HashMap<Double, Double> map1 = new HashMap<Double, Double>();
		map1.put(0.990, 0.0316);
		map1.put(0.975, 0.0398);
		map1.put(0.950, 0.0239);
		map1.put(0.9  , 0.0158);
		map1.put(0.1  , 2.71);
		map1.put(0.050, 3.84);
		map1.put(0.025, 5.02);
		map1.put(0.010, 6.63);
		ref.put(1,map1);
		
		//Degré 2
		HashMap<Double, Double> map2 = new HashMap<Double, Double>();
		map2.put(0.990, 0.02);
		map2.put(0.975, 0.05);
		map2.put(0.950, 0.10);
		map2.put(0.9  , 0.21);
		map2.put(0.1  , 4.60);
		map2.put(0.050, 5.99);
		map2.put(0.025, 7.38);
		map2.put(0.010, 9.21);
		ref.put(2,map2);
		
		//Degré 3
		HashMap<Double, Double> map3 = new HashMap<Double, Double>();
		map3.put(0.990, 0.12);
		map3.put(0.975, 0.22);
		map3.put(0.950, 0.35);
		map3.put(0.9  , 0.58);
		map3.put(0.1  , 6.25);
		map3.put(0.050, 7.81);
		map3.put(0.025, 9.35);
		map3.put(0.010, 11.34);
		ref.put(3,map3);
		
		//Degré 4
		HashMap<Double, Double> map4 = new HashMap<Double, Double>();
		map4.put(0.990, 0.30);
		map4.put(0.975, 0.48);
		map4.put(0.950, 0.71);
		map4.put(0.9  , 1.06);
		map4.put(0.1  , 7.78);
		map4.put(0.050, 9.49);
		map4.put(0.025, 11.1);
		map4.put(0.010, 13.28);
		ref.put(4,map4);
		
		//Degré 5
		HashMap<Double, Double> map5 = new HashMap<Double, Double>();
		map5.put(0.990, 0.55);
		map5.put(0.975, 0.83);
		map5.put(0.950, 1.15);
		map5.put(0.9  , 1.61);
		map5.put(0.1  , 9.24);
		map5.put(0.050, 11.07);
		map5.put(0.025, 12.8);
		map5.put(0.010, 15.09);
		ref.put(5,map5);
		
		//Degré 6
		HashMap<Double, Double> map6 = new HashMap<Double, Double>();
		map6.put(0.990, 0.87);
		map6.put(0.975, 1.24);
		map6.put(0.950, 1.64);
		map6.put(0.9  , 2.20);
		map6.put(0.1  , 10.64);
		map6.put(0.050, 12.59);
		map6.put(0.025, 14.0);
		map6.put(0.010, 16.81);
		ref.put(6,map6);
		
		//Degré 7
		HashMap<Double, Double> map7 = new HashMap<Double, Double>();
		map7.put(0.990, 1.24);
		map7.put(0.975, 1.69);
		map7.put(0.950, 2.17);
		map7.put(0.9  , 2.83);
		map7.put(0.1  , 12.02);
		map7.put(0.050, 14.07);
		map7.put(0.025, 16.0);
		map7.put(0.010, 18.47);
		ref.put(7,map7);
		
		//Degré 8
		HashMap<Double, Double> map8 = new HashMap<Double, Double>();
		map8.put(0.990, 1.65);
		map8.put(0.975, 2.18);
		map8.put(0.950, 2.73);
		map8.put(0.9  , 3.49);
		map8.put(0.1  , 13.36);
		map8.put(0.050, 15.51);
		map8.put(0.025, 17.5);
		map8.put(0.010, 20.09);
		ref.put(8,map8);
		
		//Degré 9
		HashMap<Double, Double> map9 = new HashMap<Double, Double>();
		map9.put(0.990, 2.09);
		map9.put(0.975, 2.70);
		map9.put(0.950, 3.33);
		map9.put(0.9  , 4.17);
		map9.put(0.1  , 14.68);
		map9.put(0.050, 16.92);
		map9.put(0.025, 19.0);
		map9.put(0.010, 21.67);
		ref.put(9,map9);
		
		//Degré 10
		HashMap<Double, Double> map10 = new HashMap<Double, Double>();
		map10.put(0.990, 2.56);
		map10.put(0.975, 3.25);
		map10.put(0.950, 3.94);
		map10.put(0.9  , 4.86);
		map10.put(0.1  , 15.99);
		map10.put(0.050, 18.31);
		map10.put(0.025, 20.5);
		map10.put(0.010, 23.21);
		ref.put(10,map10);
		
		//Degré 11
		HashMap<Double, Double> map11 = new HashMap<Double, Double>();
		map11.put(0.990, 3.05);
		map11.put(0.975, 3.82);
		map11.put(0.950, 4.57);
		map11.put(0.9  , 5.58);
		map11.put(0.1  , 17.27);
		map11.put(0.050, 19.67);
		map11.put(0.025, 21.9);
		map11.put(0.010, 24.72);
		ref.put(11,map11);
		
		//Degré 12
		HashMap<Double, Double> map12 = new HashMap<Double, Double>();
		map12.put(0.990, 3.57);
		map12.put(0.975, 4.40);
		map12.put(0.950, 5.23);
		map12.put(0.9  , 6.30);
		map12.put(0.1  , 18.55);
		map12.put(0.050, 21.03);
		map12.put(0.025, 23.3);
		map12.put(0.010, 26.22);
		ref.put(12,map12);
		
		//Degré 13
		HashMap<Double, Double> map13 = new HashMap<Double, Double>();
		map13.put(0.990, 4.11);
		map13.put(0.975, 5.01);
		map13.put(0.950, 5.89);
		map13.put(0.9  , 7.04);
		map13.put(0.1  , 19.81);
		map13.put(0.050, 22.36);
		map13.put(0.025, 24.7);
		map13.put(0.010, 27.69);
		ref.put(13,map13);
		
		//Degré 14
		HashMap<Double, Double> map14 = new HashMap<Double, Double>();
		map14.put(0.990, 4.66);
		map14.put(0.975, 5.63);
		map14.put(0.950, 6.57);
		map14.put(0.9  , 7.79);
		map14.put(0.1  , 21.06);
		map14.put(0.050, 23.68);
		map14.put(0.025, 26.1);
		map14.put(0.010, 29.14);
		ref.put(14,map14);
		
		//Degré 15
		HashMap<Double, Double> map15 = new HashMap<Double, Double>();
		map15.put(0.990, 5.23);
		map15.put(0.975, 6.26);
		map15.put(0.950, 7.26);
		map15.put(0.9  , 8.55);
		map15.put(0.1  , 22.31);
		map15.put(0.050, 25.00);
		map15.put(0.025, 27.5);
		map15.put(0.010, 30.58);
		ref.put(15,map15);
		
		//Degré 16
		HashMap<Double, Double> map16 = new HashMap<Double, Double>();
		map16.put(0.990, 5.81);
		map16.put(0.975, 6.81);
		map16.put(0.950, 7.96);
		map16.put(0.9  , 9.31);
		map16.put(0.1  , 23.54);
		map16.put(0.050, 26.30);
		map16.put(0.025, 28.8);
		map16.put(0.010, 32.01);
		ref.put(16,map16);
		
		//Degré 17
		HashMap<Double, Double> map17 = new HashMap<Double, Double>();
		map17.put(0.990, 6.41);
		map17.put(0.975, 7.56);
		map17.put(0.950, 8.67);
		map17.put(0.9  , 10.08);
		map17.put(0.1  , 24.77);
		map17.put(0.050, 27.59);
		map17.put(0.025, 30.2);
		map17.put(0.010, 33.41);
		ref.put(17,map17);
		
		//Degré 18
		HashMap<Double, Double> map18 = new HashMap<Double, Double>();
		map18.put(0.990, 7.01);
		map18.put(0.975, 8.23);
		map18.put(0.950, 9.39);
		map18.put(0.9  , 10.86);
		map18.put(0.1  , 25.99);
		map18.put(0.050, 28.87);
		map18.put(0.025, 31.3);
		map18.put(0.010, 34.80);
		ref.put(18,map18);
		
		//Degré 19
		HashMap<Double, Double> map19 = new HashMap<Double, Double>();
		map19.put(0.990, 7.63);
		map19.put(0.975, 8.91);
		map19.put(0.950, 10.1);
		map19.put(0.9  , 11.65);
		map19.put(0.1  , 27.20);
		map19.put(0.050, 30.14);
		map19.put(0.025, 32.9);
		map19.put(0.010, 36.19);
		ref.put(19,map19);
	}
	
	/**
	 * Risque d'erreur en fonction du degre de liberte et du khi2 calcule
	 * @param degre
	 * @param khi2
	 * @return
	 */
	public static double getRisqueErreur(int degre,double khi2){
		if (degre<1){
			return 100.0;
		}
		
		//Selection de la map pour ce degré
		HashMap<Double,Double> mapDegre = ref.get(degre);
		
		//Parcour des clefs du risque de defaillance le plus faible au risque le plus fort
		List<Double> keys = new LinkedList<Double>(); 
		keys.addAll(mapDegre.keySet());
		Collections.sort(keys); //trier
		Collections.reverse(keys); //inverser
		
		//Parcour des clefs et comparaison avec le Khi2Calcul
		int cpt = 0;
		while(cpt<keys.size() && mapDegre.get(keys.get(cpt))<= khi2){
			cpt++;
		}
		
		//Evite de depasser
		if (cpt>=keys.size()){
			cpt--;
		}
		
		return keys.get(cpt);
	}
	
	/**
	 * Constructeur privee, cacher la classe
	 */
	private TableKhi2(){
		
		
	}
}
