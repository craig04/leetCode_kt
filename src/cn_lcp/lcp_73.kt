package cn_lcp

fun adventureCamp(expeditions: Array<String>): Int {
    val site = HashSet<String>()
    fun camp(s: String): Int {
        var cnt = 0
        var i = 0
        while (i < s.length) {
            var j = i + 1
            while (j != s.length && s[j] != '-')
                j++
            if (site.add(s.substring(i, j)))
                cnt++
            i = j + 2
        }
        return cnt
    }
    camp(expeditions[0])
    var most = 0
    var ans = -1
    for (i in 1 until expeditions.size) {
        val cnt = camp(expeditions[i])
        if (most < cnt) {
            most = cnt
            ans = i
        }
    }
    return ans
}