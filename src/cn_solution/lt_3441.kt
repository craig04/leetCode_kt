package cn_solution

import kotlin.math.abs

fun minCostGoodCaption(caption: String): String {
    if (caption.length < 3)
        return ""
    val s = caption.toCharArray()
    val n = s.size
    val f = IntArray(n + 1) { Int.MAX_VALUE / 2 }
    val c = IntArray(n + 1)
    val t = IntArray(n + 1)
    val opt = IntArray(6)
    val seg = IntArray(6)
    f[n] = 0
    for (i in n - 3 downTo 0) {
        for (j in i + 3..minOf(i + 5, n)) {
            val len = j - i
            for (k in 0 until len)
                seg[k] = s[i + k] - 'a'
            seg.sort(0, len)
            val mid = seg[(len - 1) / 2]
            val cnt = (0 until len).sumOf { abs(seg[it] - mid) } + f[j]
            seg.fill(mid, 0, len)
            seg.fill(c[j], len, 6)
            fun update(): Boolean {
                if (cnt != f[i])
                    return cnt < f[i]
                if (mid != c[i])
                    return mid < c[i]
                for (k in seg.indices)
                    if (seg[k] != opt[k])
                        return seg[k] < opt[k]
                return false
            }
            if (update()) {
                f[i] = cnt
                c[i] = mid
                t[i] = j
                seg.copyInto(opt)
            }
        }
    }
    val ans = StringBuilder()
    var i = 0
    while (i != n) {
        repeat(t[i] - i) { ans.append('a' + c[i]) }
        i = t[i]
    }
    return ans.toString()
}