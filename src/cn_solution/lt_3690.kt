package cn_solution

fun minSplitMerge(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    val q = ArrayDeque<ArrayList<Int>>()
    val map = HashMap<ArrayList<Int>, Int>()
    val dest = ArrayList(nums2.asList())
    q.add(ArrayList(nums1.asList()))
    while (q.isNotEmpty()) {
        val curr = q.removeFirst()
        val step = map[curr] ?: 0
        if (curr == dest)
            return step
        for (i in curr.indices) {
            for (j in i + 1..curr.size)
                for (k in 0..n - j + i) {
                    val next = ArrayList<Int>()
                    for (t in curr.indices)
                        if (t !in i until j)
                            next.add(curr[t])
                    next.addAll(k, curr.subList(i, j))
                    if (map.putIfAbsent(next, step + 1) == null)
                        q.add(next)
                }
        }
    }
    return -1
}