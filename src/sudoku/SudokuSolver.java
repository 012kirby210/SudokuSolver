package sudoku;
import utils.Input;

import java.io.IOException;
import java.io.FileNotFoundException;
import utils.exceptions.noArrayException;
import utils.exceptions.InvalidCharException;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import sudoku.sudoku.Board;
import sudoku.sudoku.Cell;

public class SudokuSolver {

	private static final Logger logger = LogManager.getLogger("logger 1");
	
	public static void main(String[] args) {
		Input myInput = new Input();
		System.out.println("hello");
				
		Board board = new Board();
		Logger luc_logger = LogManager.getLogger("luc");
		
		logger.trace("trace message");
		logger.debug("debug message");
		logger.info("info message");
		luc_logger.info("ne devrait pas apparaitre");
		luc_logger.error("hello error logger ");
		try {
			char[][] grille = myInput.load("./grille1.txt");
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(grille[i][j]);
					if(grille[i][j] != '.') {
						board.setCellValueAtCoordinate(grille[i][j]-48, i, j);
					}
				}
				System.out.println();
			}
			
			board.drawBoard();
			
		}catch(Exception e) {
			System.out.println("there");
			System.out.println(e.toString());
		}
	}
}
