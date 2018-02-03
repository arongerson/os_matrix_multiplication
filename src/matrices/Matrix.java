package matrices;

public class Matrix {
	
	private int[][] array;
	private int numberOfRows;
	private int numberOfColumns;
	
	public Matrix(int[][] array) {
		this.array = array;
		initRowsCols();
	}
	
	public Matrix(int rows, int columns) {
		this.numberOfRows = rows;
		this.numberOfColumns = columns;
		initEmptyArray();
	}

	private void initRowsCols() {
		numberOfRows = array.length;
		numberOfColumns = array[0].length;
	}
	
	private void initEmptyArray() {
		array = new int[numberOfRows][numberOfColumns];
	}
	
	public int getRows() {
		return numberOfRows;
	}
	
	public int getCols() {
		return numberOfColumns;
	}
	
	public void setIJValue(int i, int j, int value) {
		array[i][j] = value;
	}
	
	public boolean isCompatible(Matrix matrix) {
		return numberOfColumns == matrix.getRows();
	}
	
	public int ijProduct(Matrix matrix, int row, int column) {
		 int[] rowArray = array[row];
		 int sum = 0;
		 for (int i = 0; i < rowArray.length; i++) {
			 sum += rowArray[i] * matrix.array[i][column];
		 }
		 return sum;
	}
	
	public void print() {
		for (int i = 0; i < numberOfRows; i++) {
			System.out.print("["); 
			for (int j = 0; j < numberOfRows; j++) {
				System.out.print(array[i][j] + "\t"); 
			}
			System.out.print("]\n");
		}
	}
	
}
