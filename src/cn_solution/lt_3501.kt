package cn_solution

fun maxActiveSectionsAfterTrade(s: String, queries: Array<IntArray>): List<Int> {
    val n = s.length
    var one = 0
    val zero = ArrayList<IntArray>()
    var (i, j) = intArrayOf(0, 0)
    while (i != n) {
        while (j != n && s[j] == s[i])
            j++
        if (s[i] == '0')
            zero.add(intArrayOf(i, j - 1, j - i))
        else
            one += j - i
        i = j
    }
    if (zero.size <= 1)
        return List(queries.size) { one }

    zero.add(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, 0))
    val t = IntArray(zero.size shl 2)
    fun init(idx: Int, left: Int, right: Int) {
        if (left == right) {
            t[idx] = zero[left][2] + zero[left + 1][2]
            return
        }
        val mid = (left + right) shr 1
        val l = idx.shl(1) + 1
        val r = idx.shl(1) + 2
        init(l, left, mid)
        init(r, mid + 1, right)
        t[idx] = maxOf(t[l], t[r])
    }

    fun query(idx: Int, left: Int, right: Int, low: Int, high: Int): Int {
        if (left == low && right == high)
            return t[idx]
        val mid = (left + right) shr 1
        val l = idx.shl(1) + 1
        val r = idx.shl(1) + 2
        var ans = 0
        if (low <= mid)
            ans = maxOf(ans, query(l, left, mid, low, minOf(mid, high)))
        if (high > mid)
            ans = maxOf(ans, query(r, mid + 1, right, maxOf(mid + 1, low), high))
        return ans
    }
    init(0, 0, zero.size - 3)
    fun search(pos: Int): Int {
        var l = 0
        var r = zero.size
        while (l != r) {
            val m = (l + r) shr 1
            when {
                pos > zero[m][1] -> l = m + 1
                pos < zero[m][1] -> r = m
                else -> return m
            }
        }
        return l
    }

    val ans = ArrayList<Int>()
    for ((left, right) in queries) {
        var add = 0
        do {
            i = search(left)
            if (i >= zero.size - 2)
                break
            j = search(right) - (s[right] - '0')
            if (i >= j)
                break
            val x = minOf(zero[i][1] - left + 1, zero[i][2])
            val y = minOf(right - zero[j][0] + 1, zero[j][2])
            add = if (j - i >= 2) {
                maxOf(x + zero[i + 1][2], y + zero[j - 1][2])
            } else {
                x + y
            }
            if (j - i >= 3)
                add = maxOf(add, query(0, 0, zero.size - 3, i + 1, j - 2))
        } while (false)
        ans.add(one + add)
    }
    return ans
}