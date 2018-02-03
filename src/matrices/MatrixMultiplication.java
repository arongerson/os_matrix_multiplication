package matrices;

import java.util.Random;

public class MatrixMultiplication {
	
	
	public static void main(String[] args) { 
		int rowsA = 3;
		int colsA = 5;
		int rowsB = 5;
		int colsB = 4;
		Matrix A = new Matrix(getRandomArray(rowsA, colsA));
		Matrix B = new Matrix(getRandomArray(rowsB, colsB));
		Matrix C = null;
		if (!A.isCompatible(B)) {
			System.out.println("Matrices A and B are not compatible");
			return;
		}
		C = new Matrix(A.getRows(), B.getCols());
		int threadCount = A.getRows() * B.getCols();
		ThreadMultiplier[] workers = new ThreadMultiplier[threadCount];
		createAndExecuteThreads(A, B, C, workers);
		waitForThreadsAndBeforeExiting(workers);
		printResults(A, B, C);
	}

	private static void printResults(Matrix A, Matrix B, Matrix C) {
		MatrixPrinter.print(A);
		System.out.println("------------------------------"); 
		MatrixPrinter.print(B);
		System.out.println("=============================="); 
		MatrixPrinter.print(C);
	}

	private static void waitForThreadsAndBeforeExiting(ThreadMultiplier[] workers) {
		for (int i = 0; i < workers.length; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void createAndExecuteThreads(Matrix A, Matrix B, Matrix C, ThreadMultiplier[] workers) {
		int threadIndex = 0;
		for (int i = 0; i < A.getRows(); i++) {
			for (int j = 0; j < B.getCols(); j++) {
				workers[threadIndex] = new ThreadMultiplier(i, j, A, B, C);
				workers[threadIndex].start();
				threadIndex++;
			}
		}
	}
	
	public static int[][] getRandomArray(int rows, int columns) {
		int[][] array = new int[rows][columns];
		Random random = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = -9 + random.nextInt(19); // random integers between -9 and 9 inclusive
			}
		}
		return array;
	}

}
