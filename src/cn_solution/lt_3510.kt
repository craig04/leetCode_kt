package cn_solution

import java.util.*

private fun minimumPairRemoval(nums: IntArray): Int {
    val cast = LongArray(nums.size) { nums[it] + 0L }
    var reverse = 0
    val idx = TreeSet<Int>()
    val set = TreeSet<Pair<Long, Int>> { a, b ->
        val res = a.first.compareTo(b.first)
        if (res != 0) res else a.second - b.second
    }
    for (i in 0 until cast.lastIndex) {
        if (cast[i] > cast[i + 1])
            reverse++
        idx.add(i)
        set.add(Pair(cast[i] + cast[i + 1] + 0L, i))
    }
    idx.add(cast.lastIndex)
    var ans = 0
    while (reverse != 0) {
        val (sum, i) = set.pollFirst() ?: break
        val j = idx.higher(i) ?: break
        if (cast[i] > cast[j])
            reverse--
        idx.lower(i)?.also { prev ->
            if (cast[prev] > cast[i])
                reverse--
            if (cast[prev] > sum)
                reverse++
            set.remove(Pair(cast[prev] + cast[i] + 0L, prev))
            set.add(Pair(cast[prev] + sum, prev))
        }
        idx.higher(j)?.also { next ->
            if (cast[j] > cast[next])
                reverse--
            if (sum > cast[next])
                reverse++
            set.remove(Pair(cast[j] + cast[next] + 0L, j))
            set.add(Pair(sum + cast[next], i))
        }
        idx.remove(j)
        cast[i] = sum
        ans++
    }
    return ans
}