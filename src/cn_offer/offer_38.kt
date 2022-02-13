package cn_offer

fun permutation(s: String): Array<String> {
    fun CharArray.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }

    val c = s.toCharArray().apply { sort() }
    val result = ArrayList<String>()
    while (true) {
        result.add(String(c))
        val i = (c.size - 2 downTo 0).firstOrNull {
            c[it] < c[it + 1]
        } ?: break
        val j = (c.lastIndex downTo i).first {
            c[it] > c[i]
        }
        c.swap(i, j)
        val sum = i + c.size
        for (k in i + 1..sum / 2) {
            c.swap(k, sum - k)
        }
    }
    return result.toTypedArray()
}

class Entry(val c: Char, var count: Int)

fun permutation_2(s: String): Array<String> {
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