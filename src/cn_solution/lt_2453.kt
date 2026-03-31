package cn_solution

fun destroyTargets(nums: IntArray, space: Int): Int {
    val map = HashMap<Int, IntArray>()
    var max = 0
    for (num in nums) {
        val a = map.computeIfAbsent(num % space) { intArrayOf(0, Int.MAX_VALUE) }
        max = maxOf(max, ++a[0])
        a[1] = minOf(a[1], num)
    }
    var ans = Int.MAX_VALUE
    for ((cnt, min) in map.values)
        if (cnt == max)
            ans = minOf(ans, min)
    return ans
}