package solution_cn

class Entry(val c: Char, var count: Int)

fun permutation(s: String): Array<String> {
    val m = HashMap<Char, Int>()
    for (c in s) {
        m[c] = (m[c] ?: 0) + 1
    }
    val result = ArrayList<String>()
    permutation(
        m.map { Entry(it.key, it.value) }, s.length - 1, CharArray(s.length), result
    )
    return result.toTypedArray()
}

private fun permutation(m: List<Entry>, i: Int, cs: CharArray, res: ArrayList<String>) {
    if (i == -1) {
        res.add(String(cs))
        return
    }
    m.forEach { e ->
        if (e.count != 0) {
            cs[i] = e.c
            e.count--
            permutation(m, i - 1, cs, res)
            e.count++
        }
    }
}