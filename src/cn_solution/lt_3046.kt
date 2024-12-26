package cn_solution

fun isPossibleToSplit(nums: IntArray): Boolean {
    val map = HashMap<Int, Int>()
    return nums.all { map.merge(it, 1, Int::plus)!! <= 2 }
}