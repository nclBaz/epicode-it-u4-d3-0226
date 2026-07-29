package entities;

import interfaces.Acquirente;

public class Azienda implements Acquirente {
	private final String ragioneSociale;
	private double budgetResiduo;

	public Azienda(String ragioneSociale, double budgetResiduo) {
		this.ragioneSociale = ragioneSociale;
		this.budgetResiduo = budgetResiduo;
	}

	@Override
	public String toString() {
		return "Azienda{" +
				"ragioneSociale='" + ragioneSociale + '\'' +
				", budgetResiduo=" + budgetResiduo +
				'}';
	}

	@Override
	public void acquista(double importo) {
		if (importo < budgetResiduo) {
			System.out.println(ragioneSociale + " ha acquistato spendendo " + importo);
			budgetResiduo = budgetResiduo - importo;
		} else {
			System.out.println("Non hai abbastanza soldi");
		}
	}
}
