package cn_solution

fun minMirrorPairDistance(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    var ans = Int.MAX_VALUE
    for (r in nums.indices) {
        var num = nums[r]
        val l = map[num]
        if (l != null)
            ans = minOf(ans, r - l)
        var rev = 0
        while (num != 0) {
            rev = rev * 10 + num % 10
            num /= 10
        }
        map[rev] = r
    }
    return if (ans == Int.MAX_VALUE) -1 else ans
}