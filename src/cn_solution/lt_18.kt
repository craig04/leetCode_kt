package cn_solution

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val n = nums.size
    val indexed = Array(n) { Pair(nums[it], it) }
    indexed.sortBy { it.first }
    fun Int.get() = indexed[this].first
    for (i in 0 until n) {
        if (i != 0 && i.get() == (i - 1).get())
            continue
        for (j in i + 1 until n) {
            if (j != i + 1 && j.get() == (j - 1).get())
                continue
            val partial = i.get().toLong() + j.get()
            var l = j + 1
            var r = n - 1
            while (l < r) {
                val sum = partial + l.get() + r.get()
                if (sum == target.toLong()) {
                    val temp = arrayOf(indexed[i], indexed[j], indexed[l], indexed[r])
                    result.add(temp.asSequence().sortedBy { it.second }.map { it.first }.toList())
                }
                if (sum <= target)
                    while (++l < r && l.get() == (l - 1).get()) Unit
                if (sum >= target)
                    while (r-- > l && r.get() == (r + 1).get()) Unit
            }
        }
    }
    return result
}