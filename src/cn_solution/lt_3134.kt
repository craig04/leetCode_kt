package cn_solution

fun medianOfUniquenessArray(nums: IntArray): Int {
    val n = nums.size.toLong()
    var l = 1L
    var r = (n + 1) shr 1
    val median = ((n * n + n).shr(1) + 1) shr 1
    while (l != r) {
        val m = (l + r) shr 1
        val freq = HashMap<Int, Int>()
        var i = 0
        val cnt = nums.indices.sumOf { j ->
            val start = nums[j]
            val fi = freq[start] ?: 0
            freq[start] = fi + 1
            while (freq.size > m) {
                val end = nums[i++]
                val fe = freq[end] ?: 1
                if (fe == 1)
                    freq.remove(end)
                else
                    freq[end] = fe - 1
            }
            j - i + 1L
        }
        if (cnt >= median)
            r = m
        else
            l = m + 1
    }
    return l.toInt()
}