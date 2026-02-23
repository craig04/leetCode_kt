package cn_solution

fun targetIndices(nums: IntArray, target: Int): List<Int> {
    var less = 0
    var same = 0
    for (num in nums)
        if (num < target)
            less++
        else if (num == target)
            same++
    return (less until less + same).toList()
}