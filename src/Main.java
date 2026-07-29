import entities.*;
import exceptions.RequiredValueMissingException;
import exceptions.ValidationException;
import interfaces.Acquirente;
import interfaces.Consegnatore;

public class Main {
	public static void main(String[] args) {

		Customer customer = new Customer("Giovanni", "Storti", "giova@gmail.com", "12345678", 20, "2012131546456");
		customer.sayHello();

		Driver driver = new Driver("Giacomo", "Poretti", "giacomo@gmail.com", "12345678", 32, "1i2j3o12j3");
		driver.sayHello(); // è ereditato da entities.User


		System.out.println(customer); // Se facciamo un sout di un oggetto verrà chiamato il metodo .toString() di quell'oggetto
		System.out.println(driver);

		DroneConsegne droneConsegne = new DroneConsegne("12345678");

		driver.consegna("123");
		droneConsegne.consegna("125");

		Azienda azienda = new Azienda("Epicode", 100);
		azienda.acquista(20);

		customer.acquista(30);


		System.out.println(" ----------------------------------- POLIMORFISMO ------------------------------------------");


		User[] utenti = {driver, customer}; // Array POLIMORFICO di User, chiunque sia uno User può essere inserito in questo array

		for (User user : utenti) {
			user.sayHello();
		}

//		for (int i = 0; i < utenti.length; i++) {
//			utenti[i].sayHello();
//		}

		Consegnatore[] consegnatori = {driver, droneConsegne}; // Array POLIMORFICO di Consegnatore, chiunque sia un Consegnatore può essere inserito in questo array

		for (Consegnatore consegnatore : consegnatori) {
			consegnatore.consegna("1");
		}

		Acquirente[] acquirenti = {customer, azienda, driver}; // Array POLIMORFICO di Acquirente, chiunque sia un Acquirente può essere inserito in questo array

		for (Acquirente acquirente : acquirenti) {
			// acquirente.getBudgetResiduo(); // Gli acquirenti hanno solo il metodo acquista, non hanno il metodo getBudgetResiduo()

			if (acquirente instanceof Azienda) { // Se volessi usare metodi specifici dell'azienda DEVO fare una verifica se effettivamente
				// quell'oggetto acquirente sia un'azienda
				Azienda azienda2 = (Azienda) acquirente; // <-- Nelle tonde sto convertendo l'oggetto generico Acquirente
				// in Azienda. La conversione la posso fare SOLO DOPO AVER USATO INSTANCE OF!!

				System.out.println("L'oggetto " + acquirente + " è anche un'azienda");
				System.out.println("Il budget residuo è: " + azienda2.getBudgetResiduo());
			} else {
				System.out.println("L'oggetto " + acquirente + " non è un'azienda");
			}
		}

		// METODI POLIMORFICI

		doSomething(customer, 1000); // Il metodo doSomething vuole come parametro un Acquirente. customer è un'Acquirente? Si, allora è compatibile
		doSomething(azienda, 10000); // Il metodo doSomething vuole come parametro un Acquirente. azienda è un'Acquirente? Si, allora è compatibile
		doSomething(driver, 2); // Il metodo doSomething vuole come parametro un Acquirente. driver è un'Acquirente? Si, allora è compatibile


		System.out.println("---------------------------------- EXCEPTIONS ------------------------------");

		try {
			driver.setEmail(" ");
		} catch (ValidationException | ArrayIndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		} catch (RequiredValueMissingException ex) {
			System.out.println("Inviata email a Donald J.Trump con il messaggio di errore");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

	}

	public static void doSomething(Acquirente acquirente, double importo) {
		// Grazie al polimorfismo posso anche creare metodi con parametri POLIMORFICI. Cioè prendono un tipo interfaccia, o classe padre ecc ecc
		// Così facendo il metodo diventa compatibile con più tipi di oggetti
		acquirente.acquista(importo);
	}
}
