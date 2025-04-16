package cn_solution

fun countPairs(nums: IntArray, k: Int): Int {
    val map = HashMap<Int, ArrayList<Int>>()
    var ans = 0
    for (i in nums.indices) {
        val pos = map.computeIfAbsent(nums[i]) { ArrayList() }
        ans += pos.count { it * i % k == 0 }
        pos.add(i)
    }
    return ans
}