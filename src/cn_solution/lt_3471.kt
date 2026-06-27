package cn_solution

fun largestInteger(nums: IntArray, k: Int): Int {
    val n = nums.size
    return when (k) {
        n -> nums.max()
        1 -> nums.asSequence()
            .groupingBy { it }
            .eachCount()
            .filter { it.value == 1 }
            .maxOfOrNull { it.key } ?: -1
        else -> {
            fun test(l: Int, r: Int, p: Int): Int {
                val num = nums[p]
                return if ((l until r).any { nums[it] == num })
                    -1
                else
                    num
            }
            maxOf(test(0, n - 1, n - 1), test(1, n, 0))
        }
    }
}