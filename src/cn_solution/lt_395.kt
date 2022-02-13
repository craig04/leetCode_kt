package cn_solution

fun longestSubstring(s: String, k: Int): Int {
    val cs = s.toCharArray()
    fun longestSubstring(l: Int, r: Int): Int {
        if (l == r) {
            return 0
        }
        val map = HashMap<Char, Int>()
        for (i in l until r) {
            map[cs[i]] = (map[cs[i]] ?: 0) + 1
        }
        val set = map.filter { it.value < k }.keys
        if (set.isEmpty()) {
            return r - l
        }
        var result = 0
        var b = l
        while (b < r) {
            if (cs[b] in set) {
                b++
                continue
            }
            var e = b + 1
            while (e < r && cs[e] !in set) {
                e++
            }
            result = maxOf(result, longestSubstring(b, e))
            b = e
        }
        return result
    }
    return longestSubstring(0, cs.size)
}