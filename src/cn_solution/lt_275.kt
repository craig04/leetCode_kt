package cn_solution

private fun hIndex(citations: IntArray): Int {
    var l = 0
    var r = citations.lastIndex
    while (l <= r) {
        val mid = (l + r) shr 1
        when (citations.size - mid > citations[mid]) {
            true -> l = mid + 1
            else -> r = mid - 1
        }
    }
    return citations.size - l
}
