package prob.ui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import prob.generator.PoissonProcess;

public class Fenetre extends JFrame {

	public Fenetre(PoissonProcess processusDePoisson) {
		JPanel panel = new JPanel();
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries intervalles = new XYSeries("intervalles");
		XYSeries expo = new XYSeries("expo");
		List<Integer> nbParIntervalle = processusDePoisson.poissonProcessRandom();
		dataset.addSeries(intervalles);
		dataset.addSeries(expo);
		
		for(int i = 0 ; i < processusDePoisson.getNbTirages(); i++){
			intervalles.add(i, 10);
		}
		for(Double exp : processusDePoisson.getTirageExponentielle()){
			expo.add(exp.doubleValue(), 1.0);			
		}
		
		
		
	}

}
