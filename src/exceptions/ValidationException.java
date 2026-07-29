package exceptions;

public class ValidationException extends RuntimeException { // Estendendo RuntimeException sto creando un'eccezione customizzata

	public ValidationException(String message) { // Quando la utilizzerò potrò passare un messaggio come parametro
		// Questo sarà il messaggio che si vede nel terminale quando l'eccezione scatta
		super(message);
	}
}
