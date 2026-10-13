package cn_solution

fun minOperations(nums: IntArray, locked: IntArray, k: Int): Int {
    var ans = 0
    var max = Int.MIN_VALUE
    for (i in nums.indices) {
        val num = nums[i]
        if (num < max && locked[i] == 1) {
            ans++
            locked[i] = 0
        }
        max = maxOf(max, num)
    }
    var min = Int.MAX_VALUE
    for (i in nums.indices.reversed()) {
        val num = nums[i]
        if (num > min && locked[i] == 1) {
            ans++
            locked[i] = 0
        }
        min = minOf(min, num)
    }
    if (ans > k)
        return -1
    val n = nums.size
    val a = IntArray(n + 1)
    for (i in nums.indices) {
        val num = nums[i]
        ans += i
        var x = num
        while (x > 0) {
            ans -= a[x]
            x = x and (x - 1)
        }
        x = num
        while (x <= n) {
            a[x]++
            x += x and -x
        }
    }
    return ans
}