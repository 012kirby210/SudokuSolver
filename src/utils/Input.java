package utils;

import utils.exceptions.noArrayException;
import utils.exceptions.InvalidCharException;
import utils.exceptions.InvalidGridDeclarationException;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Input
{
	/**
	 * Charge un fichier formatté contenant une grille de jeu
	 * @param filename le nom du fichier
	 * @return la grille de jeu sous forme de taleau de tableau.
	 */
	public char[][] load(String filename) throws noArrayException,
	FileNotFoundException,InvalidCharException,IOException,InvalidGridDeclarationException{
		char[][] grille = new char[9][9];
		String line = null;
		CharSequence char_seq_line = null;
		boolean array_parsing_started = false;
		
		int grille_line_index = 0;
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(filename));
	    	while((line=br.readLine()) != null) {
	    		line = line.trim();
	    		if(line.startsWith("#")) {
	    			if(!array_parsing_started) { continue; }
	    			else { throw new InvalidGridDeclarationException(); }
	    		}
	    		
	    		char_seq_line = line.subSequence(0,9);
	    		
	    		for (int i=0; i<9; i++) {
	    			char current_char = char_seq_line.charAt(i);
	    			// detect format
	    			if(this.detectFormat(current_char)) {
		    			grille[grille_line_index][i] = current_char;
	    			}else {
	    				throw new InvalidCharException();
	    			}
	    		}
	    		if(grille_line_index == 9) {
	    			break;
	    		}
    			grille_line_index++;
	    	}
	    }catch(FileNotFoundException e) {
	    	throw new FileNotFoundException("Le fichier spécfié est introuvable");
	    }
		return grille;
	}
	
	/**
	 * Vérifie que le format en entrée est conforme à ce qu'on attend
	 * @param c le caractère testé
	 * @return un boolean validant ou non le format du caractère 
	 */
	private boolean detectFormat(char c) {
		String allowed_chars= "123456789.";
		boolean authorized = false;
		
		for (int i=0; i<allowed_chars.length();i++) {
			if(c == allowed_chars.charAt(i)) {
				authorized = true;
				break;
			}
		}
		return authorized;
		
	}
}