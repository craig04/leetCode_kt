package cn_solution

fun sumDivisibleByK(nums: IntArray, k: Int): Int {
    return nums.asSequence()
        .groupingBy { it }
        .eachCount()
        .entries
        .sumOf { (num, cnt) -> if (cnt % k == 0) num * cnt else 0 }
}