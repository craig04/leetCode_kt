package cn_solution

fun maximumMEX(nums: IntArray): IntArray {
    val n = nums.size
    val pos = Array(n + 1) { ArrayDeque<Int>() }
    for (i in nums.indices)
        if (nums[i] < n)
            pos[nums[i]].addLast(i)
    val ans = ArrayList<Int>()
    var i = 0
    while (i != n) {
        var mex = 0
        var j = i
        do {
            val q = pos[mex]
            while (q.isNotEmpty() && q.first() < i)
                q.removeFirst()
            if (q.isEmpty())
                break
            mex++
            j = maxOf(j, q.removeFirst())
        } while (true)
        i = j + 1
        ans.add(mex)
    }
    return ans.toIntArray()
}