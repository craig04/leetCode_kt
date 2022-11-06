package cn_solution

fun ambiguousCoordinates(s: String): List<String> {
    fun String.reproduce(): List<String> {
        val result = ArrayList<String>()
        if (length == 1 || this[0] != '0')
            result.add(this)
        for (i in 1 until length) {
            if (last() != '0' && (i == 1 || this[0] != '0'))
                result.add("${substring(0, i)}.${substring(i)}")
        }
        return result
    }

    val result = ArrayList<String>()
    for (l in 1 until s.length - 2) {
        val first = s.substring(1, l + 1).reproduce()
        if (first.isEmpty())
            continue
        val second = s.substring(l + 1, s.lastIndex).reproduce()
        for (y in second)
            for (x in first)
                result.add("($x, $y)")
    }
    return result
}
