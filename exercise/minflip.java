package exercise;

import java.util.Arrays;

public class minflip {
	private void flip(int[][] mat, int row, int col) {
		int top = row - 1, bottom = row + 1, left = col - 1, right = col + 1;
		mat[row][col] ^= 1;
		if (top >= 0)
			mat[top][col] ^= 1;
		if (bottom < mat.length)
			mat[bottom][col] ^= 1;
		if (left >= 0)
			mat[row][left] ^= 1;
		if (right < mat[0].length)
			mat[row][right] ^= 1;
	}

	private int[][] copy(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			arr[i] = Arrays.copyOf(mat[i], n);
		}
		return arr;
	}

	private boolean isAllZero(int[][] mat) {
		int m = mat.length, n = mat[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	public int minFlips(int[][] mat) {
		if(isAllZero(mat)) return 0;
		int m = mat.length, n = mat[0].length;
		int mask = (int) Math.pow(2, m * n);
		int res = 10;
		for (int i = 0; i < mask; i++) {
			int[][] arr = copy(mat);
			int count = 0;
			for(int j = 0;j < m * n;j++) {
				if((1 << j & i) >> j == 1) {
					flip(arr, j / n,j -  j / n * n);
					count++;
					if(isAllZero(arr))
						res = Math.min(res, count);
				}
			}
		}
		return res == 10 ? -1 : res;

	}

	public static void main(String[] args) {
		int[][] mat = { { 0, 0 }, { 0, 1 } };
		System.out.println(new minflip().minFlips(mat));
	}
}
