package cn_solution

fun mostFrequentEven(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    nums.forEach {
        if (it and 1 == 0)
            map[it] = (map[it] ?: 0) + 1
    }
    var result = -1
    var count = 0
    map.forEach { (key, value) ->
        if (value > count || (value == count && key < result)) {
            result = key
            count = value
        }
    }
    return result
}