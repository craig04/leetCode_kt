package cn_solution

fun maxResult(nums: IntArray, k: Int): Int {
    val q = ArrayDeque<Pair<Int, Int>>()
    var result = nums[0]
    q.add(Pair(nums[0], 0))
    for (i in 1 until nums.size) {
        while (q.first().second + k < i)
            q.removeFirst()
        result = nums[i] + q.first().first
        while (q.isNotEmpty() && q.last().first <= result)
            q.removeLast()
        q.addLast(Pair(result, i))
    }
    return result
}