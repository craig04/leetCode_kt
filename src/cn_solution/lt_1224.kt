package cn_solution

fun maxEqualFreq(nums: IntArray): Int {
    val count = HashMap<Int, Int>()
    val freq = HashMap<Int, Int>()
    var maxFreq = 0
    return nums.indices.last {
        val old = count[nums[it]] ?: 0
        val new = old + 1
        maxFreq = maxOf(maxFreq, new)
        count[nums[it]] = new
        val s = freq.remove(old) ?: 0
        if (s > 1) {
            freq[old] = s - 1
        }
        freq[new] = (freq[new] ?: 0) + 1
        when (freq.size) {
            1 -> freq[maxFreq] == 1 || maxFreq == 1
            2 -> freq[1] == 1 || (freq[maxFreq] == 1 && maxFreq - 1 in freq)
            else -> false
        }
    } + 1
}