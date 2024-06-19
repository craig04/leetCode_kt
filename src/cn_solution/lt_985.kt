package cn_solution

fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
    fun Int.contribution() = if (this and 1 == 1) 0 else this
    var sum = nums.sumOf { it.contribution() }
    return IntArray(queries.size) {
        val (delta, i) = queries[it]
        val old = nums[i].contribution()
        nums[i] += delta
        sum += nums[i].contribution() - old
        sum
    }
}