package utils.exceptions;

public class InvalidCharException extends Exception {

	public static final String DEFAULT_MESSAGE = "Le caractère ne peut être inséré dans la grille de jeu";
	private String message;
	
	/**
	 * Exception levée lorsque le fichier spécifiant la grille  
	 * contient un autre caractère que ceux attendus pour l'expression
	 * de la grille de jeu.
	 * @param le message à afficher  
	 */
	public InvalidCharException(String message) {
		this.message = message.trim().isEmpty()? InvalidCharException.DEFAULT_MESSAGE : message;
	}
	
	/**
	 * Exception levée lorsque le fichier spécifiant la grille  
	 * contient un autre caractère que ceux attendus pour l'expression
	 * de la grille de jeu.
	 */
	public InvalidCharException() {
		this.message = InvalidCharException.DEFAULT_MESSAGE;
	}
	
	/**
	 * Renvoie le message stocké dans la classe de l'exception
	 */
	public String toString() {
		return this.message;
	}
	
}
