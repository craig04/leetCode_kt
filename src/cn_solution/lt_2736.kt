package cn_solution

fun maximumSumQueries(nums1: IntArray, nums2: IntArray, queries: Array<IntArray>): IntArray {
    val n = nums1.size
    val merge = Array(n) {
        intArrayOf(nums1[it], nums2[it], nums1[it] + nums2[it])
    }.apply { sortByDescending { it[0] } }
    val query = Array(queries.size) {
        intArrayOf(queries[it][0], queries[it][1], it)
    }.apply { sortByDescending { it[0] } }
    val result = IntArray(query.size)
    val stack = ArrayList<IntArray>()
    var j = 0
    for ((x, y, i) in query) {
        while (j != n && merge[j][0] >= x) {
            while (stack.lastOrNull()?.let { it[2] <= merge[j][2] } == true)
                stack.removeLast()
            if (stack.lastOrNull()?.let { it[1] < merge[j][1] } != false)
                stack.add(merge[j])
            j++
        }
        var l = 0
        var r = stack.size
        while (l != r) {
            val m = (l + r) shr 1
            if (stack[m][1] >= y)
                r = m
            else
                l = m + 1
        }
        result[i] = if (l == stack.size) -1 else stack[l][2]
    }
    return result
}