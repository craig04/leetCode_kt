package cn_solution

fun maxChunksToSorted(arr: IntArray): Int {
    val s = ArrayList<Int>()
    for (a in arr) {
        if (s.isEmpty() || a > s.last()) {
            s.add(a)
            continue
        }
        val last = s.last()
        while (s.isNotEmpty() && a < s.last())
            s.removeAt(s.lastIndex)
        s.add(last)
    }
    return s.size
}