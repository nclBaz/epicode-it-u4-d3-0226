package entities;

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

		this.name = name; // Siccome sia il parametro si chiama name, sia l'attributo. Uso il THIS per distinguere i 2. Il this.name
		// quindi si riferirà all'ATTRIBUTO name, non al parametro. Il parametro sarà quello senza il this
		this.surname = surname;
		this.email = email;
		this.password = password;
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

	public String getEmail() { // LEGGI EMAIL
		return email;
	}

	public void setEmail(String email) { // SOVRASCRIVI EMAIL
		if (!email.isEmpty()) // Il vantaggio di avere i SETTER è quello
			// di poter effettuare dei controlli prima di settare un certo valore
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
