package solution_cn

fun totalHammingDistance(nums: IntArray): Int {
    val bits = IntArray(32)
    for (n in nums) {
        var temp = n
        while (temp != 0) {
            bits[Integer.numberOfTrailingZeros(temp)]++
            temp = temp xor Integer.lowestOneBit(temp)
        }
    }
    return bits.sumBy { it * (nums.size - it) }
}