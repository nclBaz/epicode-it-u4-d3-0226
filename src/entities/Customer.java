package entities;

import interfaces.Acquirente;

public class Customer extends User implements Acquirente {
	private String creditCardNumber;

	public Customer(String name, String surname, String email, String password, int age, String creditCardNumber) {
		super(name, surname, email, password, age); // Uso il costruttore del padre
		this.creditCardNumber = creditCardNumber; // Poi setto i campi specifici del figlio
	}

	public void makePurchase() {
		System.out.println("Ho acquistato un nuovo prodotto");
	}

//	@Override // Non è obbligatorio ma molto consigliato
//	// A differenza dell'Overload, l'OVERRIDE sovrascrive il metodo che ereditiamo
//	// dal padre
//	public void sayHello() {
//
//		super.sayHello(); // Grazie a super.sayHello(); richiamo prima il sayHello del padre
//		// per poi aggiungere un comportamento in più
//
//		System.out.println("Per la precisione sono un CUSTOMER");
//	}


	@Override
	public void sayHello() {
		System.out.println("Sono un CUSTOMER e dico ciao");
	}

	@Override // Mi sovrascrive il comportamento di default del toString() ereditato
	// da Object "entities.entities.Customer@23fc625e"
	public String toString() {
		return "entities.Customer{" +
				"creditCardNumber='" + creditCardNumber + '\'' +
				"} " + super.toString();
	}

	@Override
	public void acquista(double importo) {
		
	}
}
