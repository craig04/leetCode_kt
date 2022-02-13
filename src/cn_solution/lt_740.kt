package cn_solution

fun deleteAndEarn(nums: IntArray): Int {
    val p = IntArray(1 + (nums.maxOrNull() ?: 0))
    nums.forEach { p[it] += it }
    var a = 0
    var b = 0
    var temp: Int
    for (i in 1 until p.size) {
        temp = b
        b = a + p[i]
        a = maxOf(a, temp)
    }
    return maxOf(a, b)
}