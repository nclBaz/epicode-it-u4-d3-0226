package entities;

import interfaces.Acquirente;
import interfaces.Consegnatore;

public class Driver extends User implements Consegnatore, Acquirente {
	private boolean isAvailable;
	private String licenseNumber;

	public Driver(String name, String surname, String email, String password, int age, String licenseNumber) {
		super(name, surname, email, password, age);
		this.licenseNumber = licenseNumber;
		this.isAvailable = true;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	// OVERLOAD di sayHello. Cioè i entities.Driver avranno a disposizione un
	// sayHello() ereditato dal padre più questo sayHello(String saluto)
	// definito qua sotto
	public void sayHello(String saluto) {
		System.out.println(saluto);
	}

	@Override
	public void sayHello() {
		System.out.println("Sono un DRIVER e dico ciao");
	}

	@Override
	public String toString() {
		return "entities.Driver{" +
				"isAvailable=" + isAvailable +
				", licenseNumber='" + licenseNumber + '\'' +
				"} " + super.toString();
	}

	@Override
	public void consegna(String idOrdine) {
		if (isAvailable) {
			isAvailable = false;
			System.out.println(this.getNomeCompleto() + " sta consegnando l'ordine " + idOrdine);
		} else {
			System.out.println(this.getNomeCompleto() + " non è disponibile per la consegna");
		}

	}

	@Override
	public void acquista(double importo) {
		System.out.println("Il driver " + this.getNomeCompleto() + " ha appena speso " + importo + "€");
	}
}
