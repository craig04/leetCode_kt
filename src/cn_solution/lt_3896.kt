package cn_solution

class Solution_3896 {

    companion object {

        const val MAX = 100004
        val not = BooleanArray(MAX)

        init {
            not[1] = true
            var i = 2
            while (i * i <= MAX) {
                if (!not[i]) {
                    for (j in i * i until MAX step i)
                        not[j] = true
                }
                i++
            }
        }
    }

    fun minOperations(nums: IntArray): Int {
        var ans = 0
        for (i in nums.indices) {
            var x = nums[i]
            while (i % 2 == 0 == not[x])
                x++
            ans += x - nums[i]
        }
        return ans
    }
}