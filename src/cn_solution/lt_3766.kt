package cn_solution

import java.util.*

class Solution_3766 {

    companion object {

        val set = TreeSet<Int>()

        init {
            for (num in 1..Int.MAX_VALUE) {
                val s = num.toString(2)
                var i = -1
                var j = s.length
                while (++i < --j)
                    if (s[i] != s[j])
                        break
                if (i < j)
                    continue
                set.add(num)
                if (num >= 5000)
                    break
            }
        }
    }

    fun minOperations(nums: IntArray): IntArray {
        return IntArray(nums.size) {
            val num = nums[it]
            val l = set.floor(num) ?: 0
            val r = set.ceiling(num) ?: 0
            minOf(num - l, r - num)
        }
    }
}