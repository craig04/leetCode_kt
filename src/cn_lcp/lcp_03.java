package cn_lcp;

import java.util.HashSet;

class Solution_LCP_03 {

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int u = 0;
        int v = 0;
        HashSet<Integer> set = new HashSet<>();
        for (char c : command.toCharArray()) {
            set.add(hash(u, v));
            if (c == 'R')
                u++;
            else
                v++;
        }
        if (!inPath(set, u, v, x, y))
            return false;
        for (int[] obstacle : obstacles) {
            int a = obstacle[0];
            int b = obstacle[1];
            if ((a < x || (a == x && b < y)) && inPath(set, u, v, a, b))
                return false;
        }
        return true;
    }

    private boolean inPath(HashSet<Integer> set, int u, int v, int x, int y) {
        int t = Math.min(x / u, y / v);
        return set.contains(hash(x - t * u, y - t * v));
    }

    private int hash(int x, int y) {
        return x * 1000 + y;
    }
}