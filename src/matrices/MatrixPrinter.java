package matrices;

public class MatrixPrinter {
	public static void print(Matrix matrix) {
		for (int i = 0; i < matrix.getRows(); i++) {
			System.out.print("["); 
			for (int j = 0; j < matrix.getCols(); j++) {
				int number = matrix.getIJValue(i, j);
				String sign = getSign(number);
				String tab = getTab(j, matrix.getCols());
				System.out.print(sign + number + tab);
			}
			System.out.print("]\n");
		}
	}
	
	private static String getSign(int number) {
		String sign = "";
		if (number >= 0) {
			sign = "+";
		}
		return sign;
	}
	
	private static String getTab(int index, int columns) {
		String tab = "\t";
		if (index == columns - 1) {
			tab = "";
		}
		return tab;
	}
}
