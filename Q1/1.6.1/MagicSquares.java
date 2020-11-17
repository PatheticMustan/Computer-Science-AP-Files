import java.util.*;

public class MagicSquares {
	public static void main(String[] args) {
		int[][][] testCases = {
			{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
			{{17, 3, 13}, {7, 11, 15}, {9, 19, 5}},
			{{7, 7, 7}, {7, 7, 7}, {7, 7, 7}},
			{{-1, 1, 0}, {1, 0, -1}, {0, -1, 1}},
			{{-1, 1, 0}, {1, 0, -1}, {0, -1, 0}} // invalid
		};

		for (int[][] test : testCases) {
			System.out.println("isMagicSquare(" + Arrays.deepToString(test) + "): " + isMagicSquare(test));
		}
	}

	public static boolean isMagicSquare(int[][] grid) {
		// Note: your method should only return true if the array passed is a 3-by-3 magic square. If either the number of
		// rows or the number of columns of the array is not 3, or the sum of any row, column, or diagonal is different,
		// then your method should return false.
		if (grid.length != 3) return false;

		for (int[] row : grid) {
			if (row.length != 3) return false;
		}

		// most of the code should work for nxn magic squares, but I really don't want to test a 7x7 square, it'll take so long to type...

		// find sum
		int sum = 0;
		for (int num : grid[0]) {
			sum += num;
		}

		// A magic square is a square array of numbers in which the sum of each row, column, and the two main diagonals are the same.
		// check rows and grids at the same time
		for (int i=0; i<grid.length; i++) {
			int rowSum = 0;
			for (int num : grid[i]) {
				rowSum += num;
			}

			int columnSum = 0;
			for (int[] row : grid) {
				columnSum += row[i];
			}

			if (rowSum != sum) return false;
			if (columnSum != sum) return false;
		}

		// check diagonals
		int lds = 0;
		for (int i=0; i<grid.length; i++) {
			lds += grid[i][i];
		}

		int rds = 0;
		for (int i=0; i<grid.length; i++) {
			rds += grid[i][grid.length-1-i];
		}

		if (lds != sum) return false;
		if (rds != sum) return false;

		return true;
	}
}