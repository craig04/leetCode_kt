package cn_solution

fun mostFrequent(nums: IntArray, key: Int): Int {
    val map = HashMap<Int, Int>()
    for (i in 1 until nums.size)
        if (nums[i - 1] == key)
            map.merge(nums[i], 1, Int::plus)
    return map.maxBy { it.value }.key
}