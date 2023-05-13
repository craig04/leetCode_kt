package cn_solution


class SnapshotArray(length: Int) {

    private val map = HashMap<Int, Int>()
    private var snapCount = 0
    private var setCount = 0
    private val records = Array(length) { ArrayList<Pair<Int, Int>>() }

    fun set(index: Int, `val`: Int) {
        records[index].add(Pair(`val`, ++setCount))
    }

    fun snap(): Int {
        map[snapCount] = setCount
        return snapCount++
    }

    fun get(index: Int, snap_id: Int): Int {
        val operationIdx = map[snap_id] ?: return 0
        val pairs = records[index]
        var l = -1
        var r = pairs.lastIndex
        while (l != r) {
            val m = (l + r + 1) shr 1
            when (pairs[m].second > operationIdx) {
                true -> r = m - 1
                else -> l = m
            }
        }
        return if (r == -1) 0 else pairs[r].first
    }
}