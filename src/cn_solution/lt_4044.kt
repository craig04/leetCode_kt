package cn_solution

fun countGoodRotations(nums: IntArray): Int {
    val sum = nums.fold(0, Long::plus)
    val a = nums + nums
    var s = 0L
    val len = nums.size / 2
    var ans = 0
    for (i in 0 until nums.size + len - 1) {
        s += a[i]
        if (i >= len - 1) {
            if (s * 2 > sum)
                ans++
            s -= a[i - len + 1]
        }
    }
    return ans
}