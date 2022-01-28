package solution_cn;

class Solution_Offer_15 {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n &= ~(n & -n);
            result++;
        }
        return result;
    }
}
