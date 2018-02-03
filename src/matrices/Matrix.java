package matrices;

public class Matrix {
	
	private int[][] array;
	private int numberOfRows;
	private int numberOfColumns;
	
	public Matrix(int[][] array) {
		this.array = array;
		initRowsCols();
	}

	private void initRowsCols() {
		numberOfRows = array.length;
		numberOfColumns = array[0].length;
	}	
	
	public int getRows() {
		return numberOfRows;
	}
	
	public int getCols() {
		return numberOfColumns;
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
	
}
