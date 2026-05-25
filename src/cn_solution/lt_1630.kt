package cn_solution

fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
    val seen = BooleanArray(nums.size)
    return l.indices.map {
        val len = r[it] - l[it]
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        for (i in l[it]..r[it]) {
            min = minOf(min, nums[i])
            max = maxOf(max, nums[i])
        }
        if (max == min)
            return@map true
        if ((max - min) % len != 0)
            return@map false
        val diff = (max - min) / len
        seen.fill(false, 0, len + 1)
        for (i in l[it]..r[it]) {
            if ((nums[i] - min) % diff != 0)
                return@map false
            val j = (nums[i] - min) / diff
            if (seen[j])
                return@map false
            seen[j] = true
        }
        true
    }
}