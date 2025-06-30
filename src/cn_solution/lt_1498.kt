package cn_solution

fun numSubseq(nums: IntArray, target: Int): Int {
    val n = nums.size
    val modulo = 1000000007
    val pow = LongArray(n)
    pow[0] = 1
    for (i in 1 until pow.size)
        pow[i] = pow[i - 1] * 2 % modulo
    nums.sort()
    var r = nums.lastIndex
    var ans = 0L
    for (l in nums.indices) {
        while (r >= l && nums[l] + nums[r] > target)
            r--
        if (r < l)
            break
        ans += pow[r - l]
    }
    return ans.mod(modulo)
}