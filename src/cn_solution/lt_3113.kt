package cn_solution

fun numberOfSubarrays(nums: IntArray): Long {
    val s = arrayListOf(intArrayOf(Int.MAX_VALUE, 0))
    var result = 0L
    for (num in nums) {
        while (s.last()[0] < num)
            s.removeLast()
        if (s.last()[0] == num) {
            result += s.last()[1]++
        } else {
            s.add(intArrayOf(num, 1))
        }
    }
    return result + nums.size
}