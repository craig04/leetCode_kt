package cn_solution

fun minMoves(nums: IntArray, k: Int): Int {
    var ans = Long.MAX_VALUE
    val suf = LongArray(nums.size) { Long.MAX_VALUE / 2 }
    var sum = 0L
    var t = (k + 1) / 2
    val q = ArrayDeque<Int>()
    for (i in nums.lastIndex downTo 0) {
        if (nums[i] == 0)
            continue
        sum += i
        q.addFirst(i)
        if (q.size == t) {
            suf[i] = sum - (i + i + t - 1L) * t / 2
            sum -= q.removeLast()
        }
    }
    sum = 0L
    t = k - t + 1
    q.clear()
    for (i in nums.indices) {
        if (nums[i] == 0)
            continue
        sum += i
        q.addLast(i)
        if (q.size == t) {
            val pre = (i + i - t + 1L) * t / 2 - sum
            sum -= q.removeFirst()
            ans = minOf(ans, pre + suf[i])
        }
    }
    return ans.toInt()
}