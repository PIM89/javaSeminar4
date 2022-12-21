import java.util.ArrayDeque;
import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        System.out.println(Arrays.deepToString(mat).replace("], ", "]\n"));
        System.out.println();
        System.out.println(Arrays.deepToString(updateMatrix(mat)).replace("], ", "]\n"));
    }

    public static int[][] updateMatrix(int[][] mat) {
        int EMPTY = Integer.MAX_VALUE;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    stack.add(new int[]{i, j});
                } else {
                    mat[i][j] = EMPTY;
                }
            }
        }
        while (!stack.isEmpty()) {
            int[] curPoint = stack.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            for (int[] step : steps) {
                int newRow = curRow + step[0];
                int newCol = curCol + step[1];
                if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length &&
                        mat[newRow][newCol] > mat[curRow][curCol] + 1) {
                    mat[newRow][newCol] = mat[curRow][curCol] + 1;
                    stack.add(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}
