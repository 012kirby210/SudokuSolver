package utils.exceptions;

public class InvalidGridDeclarationException extends Exception {

	public static final String DEFAULT_MESSAGE = "La déclaration de la grille doit s'effectuer d'un seul tenant";
	private String message;
	
	/**
	 * Exception levée lorsque la déclaration de la grille est
	 * coupée en plusieurs parties
	 * @param le message à afficher  
	 */
	public InvalidGridDeclarationException(String message) {
		this.message = message.trim().isEmpty()? InvalidGridDeclarationException.DEFAULT_MESSAGE : message;
	}
	
	/**
	 * Exception levée lorsque la déclaration de la grille est
	 * coupée en plusieurs parties
	 */
	public InvalidGridDeclarationException() {
		this.message = InvalidGridDeclarationException.DEFAULT_MESSAGE;
	}
	
	/**
	 * Renvoie le message stocké dans la classe de l'exception
	 */
	public String toString() {
		return this.message;
	}

}
