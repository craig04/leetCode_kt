package cn_solution

fun frequencySort(nums: IntArray): IntArray {
    val freq = HashMap<Int, Int>()
    val weight = HashMap<Int, Int>()
    nums.forEach { freq[it] = (freq[it] ?: 0) + 1 }
    freq.forEach { (n, f) -> weight[n] = (f shl 10) - n }
    return nums.toMutableList().sortedBy { weight[it] }.toIntArray()
}