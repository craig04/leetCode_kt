package cn_solution

fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    var ans = 0
    var cnt = 0
    var i = 0
    var j = 0
    for (t in nums.indices) {
        cnt += nums[t] % 2
        while (cnt >= k + 1)
            cnt -= nums[i++] % 2
        if (cnt < k)
            continue
        j = maxOf(j, i)
        while (nums[j] % 2 == 0)
            j++
        ans += j - i + 1
    }
    return ans
}