package cn_solution;

class Solution_3128 {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        long ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    ans += (row[i] - 1L) * (col[j] - 1L);
        return ans;
    }
}