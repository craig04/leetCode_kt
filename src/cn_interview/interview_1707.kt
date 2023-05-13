package cn_interview

fun trulyMostPopular(names: Array<String>, synonyms: Array<String>): Array<String> {
    val p = HashMap<String, String>()
    fun find(x: String): String? {
        var y = p[x] ?: return null
        if (y != x) {
            y = find(y) ?: return null
            p[x] = y
        }
        return y
    }

    fun union(x: String, y: String) {
        val a = find(x) ?: return
        val b = find(y) ?: return
        if (a < b)
            p[b] = a
        else if (a > b)
            p[a] = b
    }
    synonyms.forEach {
        val pos = it.indexOf(',')
        val x = it.substring(1, pos)
        val y = it.substring(pos + 1, it.lastIndex)
        p.putIfAbsent(x, x)
        p.putIfAbsent(y, y)
        union(x, y)
    }
    val count = HashMap<String, Int>()
    names.forEach {
        val pos = it.indexOf('(')
        var name = it.substring(0, pos)
        name = find(name) ?: name
        count[name] = (count[name] ?: 0) + it.substring(pos + 1, it.lastIndex).toInt()
    }
    val result = Array(count.size) { "" }
    count.entries.forEachIndexed { i, (k, v) ->
        result[i] = "$k($v)"
    }
    return result
}