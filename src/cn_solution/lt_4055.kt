package cn_solution

private fun shadowPairs(nums: IntArray): Int {
    fun List<Int>.solve(min: Int, max: Int): Int {
        if (min == max)
            return 0
        val mid = (min + max) / 2
        val s = ArrayList<Int>()
        val b = ArrayList<Int>()
        val low = ArrayList<Int>()
        val high = ArrayList<Int>()
        var ans = 0
        for (i in indices) {
            val x = get(i)
            if (x <= mid) {
                while (s.isNotEmpty() && x > get(s.last()))
                    s.removeLast()
                s += i
                low += x
            } else {
                while (b.isNotEmpty() && x <= get(b.last()))
                    b.removeLast()
                ans += s.size
                if (b.isNotEmpty()) {
                    val pos = s.binarySearch(b.last())
                    ans -= maxOf(pos, pos.inv())
                }
                b += i
                high += x
            }
        }
        return ans + low.solve(min, mid) + high.solve(mid + 1, max)
    }

    val a = nums.toHashSet().toIntArray().apply(IntArray::sort)
    return nums.map { a.binarySearch(it) }.solve(0, a.lastIndex)
}