package entities;

import exceptions.RequiredValueMissingException;
import exceptions.ValidationException;

public abstract class User {
	private static int usersCreated; // TUTTI GLI OGGETTI CONDIVIDERANNO LO STESSO VALORE
	// ATTRIBUTI
	private String name;
	private String surname;
	private String email;
	private String password;
	private int age;
	private Role role; // USER, ADMIN, SUPERADMIN

	public User(String name, String surname, String email, String password, int age) {
		// Grazie ai parametri del costruttore, quando creeremo oggetti entities.User, si potrà fornire dei valori per nome, cognome, email, password, età
		// che verranno assegnati ai vari attributi

		if (name == null || name.isBlank()) throw new RequiredValueMissingException("Il nome non può essere vuoto!");
		this.name = name; // Siccome sia il parametro si chiama name, sia l'attributo. Uso il THIS per distinguere i 2. Il this.name
		// quindi si riferirà all'ATTRIBUTO name, non al parametro. Il parametro sarà quello senza il this
		if (surname == null || surname.isBlank()) throw new RequiredValueMissingException("Il cognome non può essere vuoto!");
		this.surname = surname;
		if (email == null || email.isBlank()) throw new RequiredValueMissingException("L'email non può essere vuota!");
		if (!email.contains("@")) throw new ValidationException("L'email non è nel formato corretto");
		this.email = email;
		if (password == null || password.isBlank()) throw new RequiredValueMissingException("La password non può essere vuota!");
		if (password.length() < 8) throw new ValidationException("La password non può avere meno di 8 caratteri");
		this.password = password;
		if (age < 0 || age > 120) throw new ValidationException("L'età non può essere un numero inferiore a zero o maggiore di 120");
		this.age = age;
		this.role = Role.USER; // Tutti gli utenti creati saranno inizialmente USER
		usersCreated++; // <-- Quando abbiamo attributi/metodi statici NON si usa il this
	}

	public static int getUsersCreated() { // Questo metodo può essere statico
		// perché utilizza solo un attributo statico (NON USA ATTRIBUTI NON STATICI)
		return usersCreated;
	}

	// GETTERS & SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isBlank()) throw new RequiredValueMissingException("Il nome non può essere vuoto!");
		this.name = name;
	}

	public void setPassword(String password) {
		if (password == null || password.isBlank()) throw new RequiredValueMissingException("La password non può essere vuota!");
		if (password.length() < 8) throw new ValidationException("La password non può avere meno di 8 caratteri");
		this.password = password;
	}

	public String getEmail() { // LEGGI EMAIL
		return email;
	}

	public void setEmail(String email) { // SOVRASCRIVI EMAIL
		if (email == null || email.isBlank()) throw new RequiredValueMissingException("L'email non può essere vuota!");
		if (!email.contains("@")) throw new ValidationException("L'email non è nel formato corretto");
		this.email = email;
	}

	// METODI
	public abstract void sayHello(); // La classe entities.User è troppo generica per poter stabilire
	// come fare sayHello(). Lo mettiamo ABSTRACT in maniera tale da esser certi che tutti i figli
	// abbiano quel metodo, ognuno lo implementerà a modo suo.

	public int getAge() {
		return age;
	}

	public boolean eMaggiorenne() {
//		if (age >= 18) return true;
//		else return false;

		return age >= 18;
	}

	public String getNomeCompleto() {
		return name + " " + surname;
	}

	@Override
	public String toString() {
		return "entities.User{" +
				"role=" + role +
				", age=" + age +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", surname='" + surname + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
