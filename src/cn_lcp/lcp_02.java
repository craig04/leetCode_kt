package cn_lcp;

class Solution_LCP_02 {
    public int[] fraction(int[] cont) {
        int x = cont[cont.length - 1], y = 1;
        for (int i = cont.length - 2; i >= 0; i--) {
            int z = x;
            x = y;
            y = z;
            x += cont[i] * y;
        }
        return new int[]{x, y};
    }
}
