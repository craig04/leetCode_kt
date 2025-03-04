package cn_solution

import java.util.*

class Solution {
    fun minReverseOperations(n: Int, p: Int, banned: IntArray, k: Int): IntArray {
        val ans = IntArray(n) { -1 }
        val q = ArrayDeque<Int>()
        val indices = Array(2) { TreeSet<Int>() }
        val ban = banned.toHashSet()
        ans[p] = 0
        q.addFirst(p)
        for (i in 0 until n)
            if (i != p && i !in ban)
                indices[i and 1].add(i)
        while (q.isNotEmpty()) {
            val i = q.removeFirst()
            val lower = maxOf(i - k + 1, k - i - 1)
            val upper = minOf(i + k - 1, 2 * n - k - i - 1)
            val set = indices[lower and 1]
            val it = set.tailSet(lower).iterator()
            while (it.hasNext()) {
                val j = it.next()
                if (j > upper)
                    break
                ans[j] = ans[i] + 1
                q.addLast(j)
                it.remove()
            }
        }
        return ans
    }
}