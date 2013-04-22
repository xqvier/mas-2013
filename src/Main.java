import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import prob.generator.PoissonProcess;
import prob.ui.Fenetre;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		PoissonProcess processusDePoisson = new PoissonProcess(20, 0.5, 5);
		
		JFrame fenetre = new Fenetre(processusDePoisson);

	}

}
