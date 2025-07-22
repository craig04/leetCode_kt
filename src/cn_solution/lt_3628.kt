package cn_solution

fun numOfSubsequences(s: String): Long {
    var (l, c, t) = intArrayOf(0, 0, s.count { it == 'T' })
    var (lc, lt, ct, lct) = LongArray(4)
    for (i in s.indices) {
        when (s[i]) {
            'L' -> {
                l++
            }
            'C' -> {
                c++
                lc += l
            }
            'T' -> {
                lct += lc
                ct += c
                t--
            }
        }
        lt = maxOf(lt, 1L * l * t)
    }
    return lct + maxOf(lc, lt, ct)
}