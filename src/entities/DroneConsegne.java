package entities;

import interfaces.Consegnatore;

public class DroneConsegne implements Consegnatore {
	private final String codiceSeriale;
	private int caricaBatteria;

	public DroneConsegne(String codiceSeriale) {
		this.codiceSeriale = codiceSeriale;
		this.caricaBatteria = 100;
	}

	@Override
	public String toString() {
		return "DroneConsegne{" +
				"codiceSeriale='" + codiceSeriale + '\'' +
				", caricaBatteria=" + caricaBatteria +
				'}';
	}

	@Override
	public void consegna(String idOrdine) {
		if (caricaBatteria < 20) {
			System.out.println("Drone " + codiceSeriale + " scarico, metterlo in carica per consegnare");
		} else {
			System.out.println("Drone " + codiceSeriale + " parte per consegnare l'ordine " + idOrdine);
			caricaBatteria = caricaBatteria - 10;
			System.out.println("Stato batteria post ordine: " + caricaBatteria + "%");
		}
	}
}
