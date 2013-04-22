import javax.swing.JFrame;

import prob.generator.PoissonProcess;
import prob.ui.Fenetre;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PoissonProcess processusDePoisson = new PoissonProcess(10, 0.8, 10);
		
		JFrame fenetre = new Fenetre(processusDePoisson);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);

	}

}
