package utils.exceptions;

public class noArrayException extends Exception {

	public static final String DEFAULT_MESSAGE = "Le fichier ne contient pas de grille de jeu";
	private String message;
	
	/**
	 * Exception levée lorsque le fichier ne contient pas de 
	 * grille de jeu
	 * @param le message à afficher  
	 */
	public noArrayException(String message) {
		this.message = message.trim().isEmpty()? noArrayException.DEFAULT_MESSAGE : message;
	}
	
	/**
	 * Exception levée lorsque le fichier ne contient pas de 
	 * grille de jeu
	 */
	public noArrayException() {
		this.message = noArrayException.DEFAULT_MESSAGE;
	}
	
	/**
	 * Renvoie le message stocké dans la classe de l'exception
	 */
	public String toString() {
		return this.message;
	}
}
