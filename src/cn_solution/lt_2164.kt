package cn_solution

fun sortEvenOdd(nums: IntArray): IntArray {
    val x = Array(2) { ArrayList<Int>() }
    for (i in nums.indices)
        x[i % 2].add(nums[i])
    x[0].sort()
    x[1].sortDescending()
    for (i in nums.indices)
        nums[i] = x[i % 2][i / 2]
    return nums
}