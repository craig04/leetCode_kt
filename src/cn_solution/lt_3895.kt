package cn_solution

fun countDigitOccurrences(nums: IntArray, digit: Int): Int {
    return nums.sumOf { num -> num.toString().count { it - '0' == digit } }
}