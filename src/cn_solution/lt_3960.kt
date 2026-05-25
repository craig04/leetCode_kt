package cn_solution

fun getLength(nums: IntArray): Int {
    var ans = 0
    for (i in nums.indices) {
        val map = HashMap<Int, Int>()
        val fre = HashMap<Int, Int>()
        var max = 0
        for (j in i until nums.size) {
            val cnt = map[nums[j]] ?: 0
            map[nums[j]] = cnt + 1
            max = maxOf(max, cnt + 1)
            if (cnt != 0)
                fre.merge(cnt, -1) { a, b ->
                    if (a + b == 0) null else a + b
                }
            fre.merge(cnt + 1, 1, Int::plus)
            if ((fre.size == 1 && fre[max] == 1) || (fre.size == 2 && max % 2 == 0 && max / 2 in fre))
                ans = maxOf(ans, j - i + 1)
        }
    }
    return ans
}