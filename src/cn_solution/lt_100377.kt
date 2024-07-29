package cn_solution

fun canAliceWin(nums: IntArray): Boolean {
    var a = 0
    var b = 0
    for (num in nums)
        if (num < 10)
            a += num
        else
            b += num
    return a != b
}