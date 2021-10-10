package exercise;

public class findNumIn2Darray {
	private boolean findNumberIn2DArray(int[][] matrix, int target, int l1, int l2, int r1, int r2) {
		if (l1 > r1 || l2 > r2)
			return false;
		if (l1 == r1 && l2 == r2 && target != matrix[l1][l2])
			return false;
		int midx = l1 + ((r1 - l1) >> 1);
		int midy = l2 + ((r2 - l2) >> 1);
		if (matrix[midx][midy] > target) {

			return findNumberIn2DArray(matrix,target,l1,l2,midx - 1,r2)
		            || findNumberIn2DArray(matrix,target,midx,l2,r1,midy - 1);
		} else if (matrix[midx][midy] < target) {

			return findNumberIn2DArray(matrix, target, l1, midy + 1, midx, r2)
					|| findNumberIn2DArray(matrix, target, midx + 1, l2, r1, r2);
		}
		return true;
	}

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int m = matrix.length - 1, n = matrix[0].length - 1;
		if (target > matrix[m][n])
			return false;
		return findNumberIn2DArray(matrix, target, 0, 0, m, n);
	}

	public static void main(String[] args) {
		int[][] matrix = { };
		System.out.println(matrix.length);
		for(int i = 1;i < 40;i++)
		System.out.println(i + "    " +new findNumIn2Darray().findNumberIn2DArray(matrix, i));

	}
}
