package solution

fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
    val sums = IntArray(nums.size + 1)
    nums.forEachIndexed { index, i ->
        sums[index + 1] = sums[index] + i
    }
    val rSum = mutableListOf<Int>()
    sums.forEachIndexed { i, sum ->
        for (j in i + 1 until sums.size) {
            rSum.add(sums[j] - sum)
        }
    }
    rSum.sort()
    return (left..right).fold(0L) { acc, i ->
        acc + rSum[i - 1]
    }.toInt()
}