package cn_solution

fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    var i = 0
    var j = 0
    val n = nums1.size
    val m = nums2.size
    val ans = ArrayList<IntArray>()
    while (i < n && j < m) {
        val id = minOf(nums1[i][0], nums2[j][0])
        var cnt = 0
        if (nums1[i][0] == id)
            cnt += nums1[i++][1]
        if (nums2[j][0] == id)
            cnt += nums2[j++][1]
        ans.add(intArrayOf(id, cnt))
    }
    (i until n).mapTo(ans) { nums1[it] }
    (j until m).mapTo(ans) { nums2[it] }
    return ans.toTypedArray()
}