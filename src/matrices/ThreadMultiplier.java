package matrices;

public class ThreadMultiplier extends Thread {

	private int row;
	private int column;
	private Matrix A;
	private Matrix B;
	private Matrix C;
	
	public ThreadMultiplier(int row, int column, Matrix A, Matrix B, Matrix C) {
		this.row = row;
		this.column = column;
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	@Override
	public void run() {
		int ijProduct = A.ijProduct(B, row, column);
		C.setIJValue(row, column, ijProduct);
	}
}
