package cn_solution

fun decompressRLElist(nums: IntArray): IntArray {
    val ans = ArrayList<Int>()
    for (i in nums.indices step 2)
        repeat(nums[i]) { ans.add(nums[i + 1]) }
    return ans.toIntArray()
}