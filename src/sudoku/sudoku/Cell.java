package sudoku.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private List<Integer> potential_values;
	private int value;
	
	public Cell() {
		this.potential_values = new ArrayList();
		this.fullfill();
		this.value = 0;
	}
	
	public Cell(int value) {
		this.potential_values = new ArrayList();
		this.fullfill();
		this.value = value;
	}
	
	
	public int getValue() {
		return this.value;
	}

	public void setValue(int v) {
		this.value = v;
		//imply remove value for the peers 
	}
	
	private void fullfill() {
		for(int i = 1; i <= 9 ; i++) {
			this.potential_values.add(i);
		}
	}
	
	public void removePotentialValue(int value) {
		this.potential_values.remove(value);
	}
	
	public String toString() {
		return "Je suis une cellule de valeur " + this.value;
	}
}
