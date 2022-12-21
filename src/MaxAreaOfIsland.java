import java.util.ArrayDeque;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    grid[row][col] = 0;
                    stack.add(new int[]{row, col});
                }
                if (!stack.isEmpty()) {
                    max = Math.max(max, useStack(stack, grid));
                }
            }
        }
        return max;
    }

    public static int useStack(ArrayDeque<int[]> stack, int[][] grid) {
        int max = 0;
        while (!stack.isEmpty()) {
            int[] curPoint = stack.poll();
            int row = curPoint[0];
            int col = curPoint[1];
            max++;
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = 0;
                stack.add(new int[]{row - 1, col});
            }
            if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                grid[row + 1][col] = 0;
                stack.add(new int[]{row + 1, col});
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = 0;
                stack.add(new int[]{row, col - 1});
            }
            if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                grid[row][col + 1] = 0;
                stack.add(new int[]{row, col + 1});
            }
        }
        return max;
    }
}
