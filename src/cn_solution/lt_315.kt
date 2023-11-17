package cn_solution

const val RANGE = 10000
const val UPPER = RANGE * 2 + 1

fun countSmaller(nums: IntArray): List<Int> {
    val a = IntArray(UPPER + 1)
    val result = ArrayList<Int>()
    for (n in nums.indices.reversed()) {
        var t = nums[n] + RANGE
        var count = 0
        while (t > 0) {
            count += a[t]
            t -= t and -t
        }
        result.add(count)
        t = nums[n] + RANGE + 1
        while (t <= UPPER) {
            a[t]++
            t += t and -t
        }
    }
    return result.asReversed()
}