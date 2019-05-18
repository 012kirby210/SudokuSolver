package sudoku.sudoku;


import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import sudoku.sudoku.Cell;

public class Board {

	// une board est un ensemble de cells
	private List<Cell> cells_list ;
	private Cell[][] cell_tab ;
    private Logger logger;
	
	public Board() {
		this.cells_list = new ArrayList<Cell>();
		this.cell_tab = new Cell[9][9];
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				this.cell_tab[i][j] = new Cell();
			}
		}
		this.logger = LogManager.getLogger();
	}
	
	/**
	 * Fetch the list of peer's cell in a row
	 * @param x abscissa of the cell
	 * @param y ordinate of the cell
	 * @return the list of the peer's cell inside the same row 
	 */
	public List<Cell> getRowForCellCoordinate(int x,int y) {
		ArrayList<Cell> peer_list = new ArrayList<Cell>();
		for(int ordinate = 0 ; ordinate < 9; ordinate++) {
			peer_list.add(this.cell_tab[x][ordinate]);
		}
		return peer_list;
	}
	
	/**
	 * Retrieve every peers in the same row as the cell's coordinate passed 
	 * to the function
	 * @param x abscissa of the cell
	 * @param y ordinate of the cell
	 * @return the list of peer's cell as a list
	 */
	public List<Cell> getRowPeersForCellCoordinate(int x, int y) {
		ArrayList<Cell> peer_list = new ArrayList<Cell>();
		for(int ordinate = 0 ; ordinate < 9 ; ordinate++) {
			if(ordinate == y) continue;
			peer_list.add(this.cell_tab[x][ordinate]);
		}
		return peer_list;
	}
	
	/**
	 * Fetch the list of peer's cell in a column
	 * @param x abscissa of the cell
	 * @param y ordinate of the cell
	 * @return the list of the peer's cell inside the same column
	 */
	public List<Cell> getColumnForCellCoordinate(int x,int y){
		ArrayList<Cell> peer_list = new ArrayList<Cell>();
		for(int abscissa = 0 ; abscissa < 9; abscissa++) {
			peer_list.add(this.cell_tab[abscissa][y]);
		}
		return peer_list;
	}
	
	/**
	 * Retrieve the list of peer's cells in column for a cell localized at
	 * the coordinate passed as arguments
	 * @param x abscissa of the cell
	 * @param y ordinate of the cell
	 * @return the peer's list as a List
	 */
	public List<Cell> getColumnPeersForCellCoordinate(int x,int y){
		ArrayList<Cell> peer_list = new ArrayList<Cell>();
		for(int abscissa = 0 ; abscissa < 9; abscissa++) {
			if(abscissa == x) continue;
			peer_list.add(this.cell_tab[abscissa][y]);
		}
		return peer_list;
	}
	
	/**
	 * Fetch the list of peer's cell in a unit
	 * @param x abscissa of the cell
	 * @param y ordinate of the cell
	 * @return the list of the peer's cell inside the same unit
	 */
	public List<Cell> getUnitForCellCoordinate(int x, int y){
		ArrayList<Cell> peer_list = new ArrayList<Cell>();
		int start_x = x / 3, start_y = y / 3;
		for(int abscissa = start_x; abscissa < 3; abscissa++) {
			for(int ordinate = start_y; ordinate < 3; ordinate++) {
				peer_list.add(this.cell_tab[abscissa][ordinate]);
			}
		}
		return peer_list;
	}
	
	/**
	 * Retrieve the list of Peers inside a unit for associated with a cell upon
	 * coordinate passed as arguments
	 * @param x abscissa of the cell
	 * @param y ordinate of the cell
	 * @return the peer's list as a list
	 */
	public List<Cell> getPeerUnitForCellCoordinate(int x, int y){
		ArrayList<Cell> peer_list = new ArrayList<Cell>();
		int start_x = x / 3, start_y = y / 3;
		for(int abscissa = start_x; abscissa < 3; abscissa++) {
			for(int ordinate = start_y; ordinate < 3; ordinate++) {
				if(abscissa == x && ordinate == y) continue;
				peer_list.add(this.cell_tab[abscissa][ordinate]);
			}
		}
		return peer_list;
	}
	
	/**
	 * Set the value of the cell and remove that value from the peer's cells
	 * @param value the value of the cell
	 * @param x the abscissa of the cell
	 * @param y the ordinate of the cell
	 * @return the board itself to comply in a reflexive way
	 */
	public Board setCellValueAtCoordinate(int value,int x,int y) {
		this.cell_tab[x][y].setValue(value);
        // then remove that value from it's the peers .
		List column = this.getColumnPeersForCellCoordinate(x, y);
		Iterator iterator = column.iterator();
		return this;
	}
	
	public void drawBoard() {
		for(int i=0 ; i<9; i++) {
			for(int j=0; j<9 ; j++) {
				System.out.print((char)( this.cell_tab[i][j].getValue() + 48));
			}
			System.out.println();
		}
	}
	
}
