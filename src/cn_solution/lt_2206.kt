package cn_solution

fun divideArray(nums: IntArray): Boolean {
    return nums.asSequence().groupingBy { it }.eachCount().all { it.value % 2 == 0 }
}