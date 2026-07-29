package entities;

public class Driver extends User {
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
}
