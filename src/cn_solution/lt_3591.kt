package cn_solution

class Solution_3591 {

    companion object {
        val p = BooleanArray(101) { true }

        init {
            p[1] = false
            for (i in 2 until p.size)
                if (p[i])
                    for (j in i * i until p.size step i)
                        p[j] = false
        }
    }

    fun checkPrimeFrequency(nums: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        for (num in nums)
            map.merge(num, 1, Int::plus)
        return map.values.any { p[it] }
    }
}