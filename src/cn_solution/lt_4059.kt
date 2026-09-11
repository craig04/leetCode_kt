package cn_solution


fun largestPower_intervals(nums: IntArray): IntArray {
    var curr = arrayListOf(nums.asList())
    val ans = IntArray(15)
    for (i in 14 downTo 0) {
        val next = ArrayList<List<Int>>()
        var cnt = 0
        for (j in curr.indices) {
            val list = curr[j]
            val p = { x: Int -> x.shr(i).and(1) == 1 }
            if (list.all(p)) {
                next += list
                cnt += list.size
                continue
            }
            val (a, b) = list.partition(p)
            if (a.isNotEmpty()) {
                next += a
                cnt += a.size
            }
            next += b
            next.addAll(curr.subList(j + 1, curr.size))
            break
        }
        curr = next
        ans[14 - i] = cnt
    }
    return ans
}

fun largestPower_sort(nums: IntArray): IntArray {
    val n = nums.size
    val w = 32 - nums.max().countLeadingZeroBits()
    val ans = IntArray(15)
    for (i in w - 1 downTo 0) {
        nums.sortDescending()
        var j = 0
        while (j != n && nums[j].shr(i).and(1) == 1)
            j++
        ans[14 - i] = j
        while (j != n) {
            nums[j] = 1.shl(i).inv().and(nums[j])
            j++
        }
    }
    return ans
}