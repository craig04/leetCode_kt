package cn_solution

fun alternatingSubarray(nums: IntArray): Int {
    var s = 0
    var result = 0
    while (s != nums.size) {
        var e = s + 1
        while (e != nums.size && nums[e] - nums[s] == (e - s) % 2)
            e++
        result = maxOf(result, e - s)
        s = maxOf(s + 1, e - 1)
    }
    return if (result == 1) -1 else result
}