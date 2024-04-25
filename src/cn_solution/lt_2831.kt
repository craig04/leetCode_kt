package cn_solution

fun longestEqualSubarray(nums: List<Int>, k: Int): Int {
    return nums.indices.groupByTo(HashMap()) { nums[it] }.maxOf { (_, pos) ->
        var i = 0
        pos.indices.maxOf { j ->
            while (pos[j] - pos[i] - k > j - i)
                i++
            j - i + 1
        }
    }
}