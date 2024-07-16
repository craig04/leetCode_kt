package cn_solution

import java.util.*

class SORTracker() {

    private val comparator = compareBy<Pair<Int, String>>({ -it.first }, { it.second })
    private val best = Pair(Int.MAX_VALUE, "")
    private val set = TreeSet(comparator).apply { add(best) }
    private var pos = best

    fun add(name: String, score: Int) {
        val pair = Pair(score, name)
        set.add(pair)
        if (comparator.compare(pair, pos) < 0)
            pos = set.lower(pos) ?: best
    }

    fun get(): String {
        pos = set.higher(pos) ?: best
        return pos.second
    }
}