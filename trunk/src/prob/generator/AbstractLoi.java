package prob.generator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLoi implements ILoi {

	@Override
	public List<Double> loiInverse(int pNbAGenere) {
		ArrayList<Double> results = new ArrayList<>(pNbAGenere);
		for (int i = 0; i < pNbAGenere; i++) {
			results.add(loiInverse());
		}
		return results;
	}

}
