package cn_solution

import java.util.*

class Solution_3589 {

    companion object {
        val p = BooleanArray(50001) { true }

        init {
            p[1] = false
            for (i in 2 until p.size)
                if (p[i] && i < p.size / i)
                    for (j in i * i until p.size step i)
                        p[j] = false
        }
    }

    fun primeSubarray(nums: IntArray, k: Int): Int {
        var ans = 0
        val min = ArrayDeque<Int>()
        val max = ArrayDeque<Int>()
        var last2 = -1
        var last1 = -1
        var l = 0
        for (r in nums.indices) {
            val num = nums[r]
            if (p[num]) {
                last2 = last1
                last1 = r
                while (min.isNotEmpty() && nums[min.last()] >= num)
                    min.removeLast()
                while (max.isNotEmpty() && nums[max.last()] <= num)
                    max.removeLast()
                min.addLast(r)
                max.addLast(r)
            }
            while (min.isNotEmpty() && nums[max.first()] - nums[min.first()] > k) {
                if (min.first() == l)
                    min.removeFirst()
                if (max.first() == l)
                    max.removeFirst()
                l++
            }
            ans += last2 - l + 1
        }
        return ans
    }
}