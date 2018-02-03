package matrices;

import java.util.Random;

public class MatrixMultiplication {
	
	
	public static void main(String[] args) { 
		int rowsA = 3;
		int colsA = 4;
		int rowsB = 4;
		int colsB = 2;
		Matrix A = new Matrix(getRandomArray(rowsA, colsA));
		Matrix B = new Matrix(getRandomArray(rowsB, colsB));
		Matrix C = null;
		if (A.isCompatible(B)) {
			C = new Matrix(A.getRows(), B.getCols());
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
		A.print();
		System.out.println("------------------------------"); 
		B.print();
		System.out.println("=============================="); 
		C.print();
	}
	
	public static int[][] getRandomArray(int rows, int columns) {
		int[][] array = new int[rows][columns];
		Random random = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = -9 + random.nextInt(19); // random ints between -9 and 9 inclusive
			}
		}
		return array;
	}

}
