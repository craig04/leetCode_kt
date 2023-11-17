package cn_solution

class Solution_2342 {
    fun maximumSum(nums: IntArray): Int {
        val top = IntArray(164)
        for (n in nums) {
            var sum = 0
            var temp = n
            while (temp != 0) {
                sum += temp % 10
                temp /= 10
            }
            val a = sum * 2
            val b = a + 1
            if (n > top[a]) {
                top[b] = top[a]
                top[a] = n
            } else if (n > top[b])
                top[b] = n
        }
        return (top.indices step 2).maxOf { if (top[it + 1] == 0) -1 else top[it] + top[it + 1] }
    }
}