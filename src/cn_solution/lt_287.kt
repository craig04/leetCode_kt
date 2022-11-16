package cn_solution

fun findDuplicate(nums: IntArray): Int {
    return (0 until 32).sumBy { bit ->
        val mask = 1 shl bit
        var count = 0
        nums.forEachIndexed { i, n ->
            if (n and mask != 0) count++
            if (i and mask != 0) count--
        }
        if (count > 0) mask else 0
    }
}
