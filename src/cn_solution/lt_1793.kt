package cn_solution

fun maximumScore(nums: IntArray, k: Int): Int {
    val n = nums.size
    var i = k - 1
    var j = k + 1
    var min = nums[k]
    var result = 0
    while (true) {
        while (i != -1 && nums[i] >= min)
            i--
        while (j != n && nums[j] >= min)
            j++
        result = maxOf(result, (j - i - 1) * min)
        min = maxOf(
            if (i == -1) -1 else nums[i],
            if (j == n) -1 else nums[j]
        )
        if (min == -1)
            break
    }
    return result
}