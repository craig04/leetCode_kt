package cn_solution

fun countCompleteSubarrays(nums: IntArray): Int {
    val cnt = nums.toHashSet().size
    val map = HashMap<Int, Int>()
    var i = 0
    return nums.indices.sumOf { j ->
        map.merge(nums[j], 1, Int::plus)
        while (map.size == cnt)
            map.merge(nums[i++], -1) { a, b ->
                if (a + b == 0) null else a + b
            }
        i
    }
}