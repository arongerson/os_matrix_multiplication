package matrices;

public class MatrixMultiplication {
	
	
	public static void main(String[] args) { 
		Matrix A = new Matrix(new int [][] {
			{1, 2},
			{3, 4}
			});
		Matrix B = new Matrix(new int [][] {
			{1, 2},
			{3, 4}
			});
		Matrix C = null;
		if (A.isCompatible(B)) {
			C = new Matrix(A.getCols(), B.getRows());
		}
		int threadCount = A.getRows() * B.getCols();
		int threadIndex = 0;
		ThreadMultiplier[] workers = new ThreadMultiplier[threadCount];
		for (int i = 0; i < A.getRows(); i++) {
			for (int j = 0; j < B.getCols(); j++) {
				workers[threadIndex] = new ThreadMultiplier(i, j, A, B, C);
				workers[threadIndex].start();
				threadIndex++;
			}
		}
		for (int i = 0; i < workers.length; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		C.print();
	}

}
