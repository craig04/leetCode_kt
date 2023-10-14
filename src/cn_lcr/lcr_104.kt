package cn_lcr

fun combinationSum4(nums: IntArray, target: Int): Int {
    val count = IntArray(target + 1)
    count[0] = 1
    for (i in 1..target) {
        for (n in nums) {
            if (n <= i) {
                count[i] += count[i - n]
            }
        }
    }
    return count[target]
}