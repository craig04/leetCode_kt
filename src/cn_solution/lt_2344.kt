package cn_solution

class Solution_2344 {
    fun minOperations(nums: IntArray, numsDivide: IntArray): Int {
        fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
        val gcd = numsDivide.reduce { a, b -> gcd(a, b) }
        val factor = nums.asSequence().filter { gcd % it == 0 }.minOrNull() ?: return -1
        return nums.count { it < factor }
    }
}