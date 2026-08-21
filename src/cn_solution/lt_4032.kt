package cn_solution

class Solution_4032 {

    companion object {

        const val MAX = 100000
        val fac = Array(MAX + 1) { ArrayList<Int>() }

        init {
            for (i in 2..MAX)
                if (fac[i].isEmpty())
                    for (j in i..MAX step i)
                        fac[j] += i
        }
    }

    fun longestSubarray(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        var i = 0
        return nums.indices.maxOf { j ->
            if (fac[nums[j]].size > k) {
                map.clear()
                i = j + 1
                return@maxOf 0
            }
            for (x in fac[nums[j]])
                map.merge(x, 1, Int::plus)
            while (map.size > k)
                for (x in fac[nums[i++]])
                    map.merge(x, -1) { a, b ->
                        if (a + b == 0) null else a + b
                    }
            j - i + 1
        }
    }
}