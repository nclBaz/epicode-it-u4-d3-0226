import entities.Customer;
import entities.Driver;

public class Main {
	public static void main(String[] args) {

		Customer customer = new Customer("Giovanni", "Storti", "giova@gmail.com", "1234", 20, "2012131546456");
		customer.sayHello();

		Driver driver = new Driver("Giacomo", "Poretti", "giacomo@gmail.com", "1234", 32, "1i2j3o12j3");
		driver.sayHello(); // è ereditato da entities.User


		System.out.println(customer); // Se facciamo un sout di un oggetto verrà chiamato il metodo .toString() di quell'oggetto
		System.out.println(driver);

	}
}
