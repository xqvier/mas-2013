import javax.swing.JFrame;

import prob.generator.PoissonProcess;
import prob.ui.Fenetre;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PoissonProcess processusDePoisson = new PoissonProcess(20, 0.5, 5);
		
		JFrame fenetre = new Fenetre(processusDePoisson);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);

	}

}
