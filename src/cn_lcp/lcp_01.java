package cn_lcp;

class Solution_LCP_01 {
    public int game(int[] guess, int[] answer) {
        int ans = 0;
        for (int i = 0; i < guess.length; i++)
            if (guess[i] == answer[i])
                ans++;
        return ans;
    }
}
