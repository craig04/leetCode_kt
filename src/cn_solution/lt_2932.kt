package cn_solution

class Solution_2932 {

    fun maximumStrongPairXor(nums: IntArray): Int {
        nums.sort()
        var result = 0
        for (i in nums.indices) {
            val a = nums[i]
            var j = i + 1
            while (j != nums.size && nums[j] <= a shl 1)
                result = maxOf(result, a xor nums[j++])
        }
        return result
    }
}