package prob.ui;

import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import prob.generator.PoissonProcess;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	public Fenetre(PoissonProcess processusDePoisson) {

		List<Integer> nbParIntervalle = processusDePoisson
				.poissonProcessRandom();

		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		XYSeries intervalles = new XYSeries("intervalles");
		XYSeries evenements = new XYSeries("evenements");
		xySeriesCollection.addSeries(evenements);
		XYBarDataset dataset = new XYBarDataset(xySeriesCollection, 0.1);

		for (int i = 0; i < processusDePoisson.getNbTirages(); i++) {
			intervalles = new XYSeries("N = " + nbParIntervalle.get(i));
			xySeriesCollection.addSeries(intervalles);
			for (int j = 0; j <= 10; j++) {
				intervalles.add(j, ((i + 1) * processusDePoisson.getDeltaT()));
			}
		}

		for (Integer nb : nbParIntervalle) {
			System.out.println(nb);
		}

		double sum = 0.0;
		for (int i = 0; i < processusDePoisson.getTirageExponentielle().size(); i++) {
			System.out.println(sum);
			System.out.println(processusDePoisson.getNbTirages()
					* processusDePoisson.getDeltaT());
			if (sum <= processusDePoisson.getNbTirages()
					* processusDePoisson.getDeltaT()) {
				evenements = new XYSeries("eve" + i);
				sum += processusDePoisson.getTirageExponentielle().get(i);
				xySeriesCollection.addSeries(evenements);
				for (int j = 0; j <= 1; j++) {
					evenements.add(j, sum);
				}
			}
		}

		JFreeChart chart = ChartFactory.createXYLineChart(
				"processus de poisson", "", "evenements", dataset,
				PlotOrientation.HORIZONTAL, false, true, false);

		ChartPanel panel = new ChartPanel(chart);
		this.add(panel);
		this.setSize(1024, 768);

	}
}
