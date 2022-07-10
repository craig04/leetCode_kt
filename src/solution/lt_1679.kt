package solution

/**
 * Lower complexity but actually runs slower
 */
@Suppress("FunctionName")
fun maxOperations(nums: IntArray, k: Int): Int {
    var ops = 0
    val map = hashMapOf<Int, Int>()
    nums.forEach {
        val count = map.getOrDefault(k - it, 0)
        if (count != 0) {
            ops++
            map[k - it] = count - 1
        } else {
            map[it] = map.getOrDefault(it, 0) + 1
        }
    }
    return ops
}

/**
 * Higher complexity but actually runs faster
 */
@Suppress("FunctionName")
fun maxOperations_sort(nums: IntArray, k: Int): Int {
    nums.sort()
    var ops = 0
    var i = 0
    var j = nums.size - 1
    while (i < j) {
        val sum = nums[i] + nums[j]
        if (sum < k) {
            i++
        } else if (sum > k) {
            j--
        } else {
            i++
            j--
            ops++
        }
    }
    return ops
}