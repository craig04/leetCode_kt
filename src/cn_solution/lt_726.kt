package cn_solution

fun countOfAtoms(formula: String): String {
    val s = arrayListOf(HashMap<String, Int>())
    var i = 0
    val n = formula.length
    while (i != n) {
        fun parseCount(): Int {
            var res = 0
            while (i != n && formula[i].isDigit())
                res = formula[i++] - '0' + res * 10
            return maxOf(1, res)
        }

        val c = formula[i]
        if (c == '(') {
            i++
            s += HashMap()
        } else if (c == ')') {
            i++
            val cnt = parseCount()
            val map = s.removeLast()
            for ((k, v) in map)
                s.last().merge(k, v * cnt, Int::plus)
        } else {
            var j = i + 1
            while (j != n && formula[j].isLowerCase())
                j++
            val atom = formula.substring(i, j)
            i = j
            val cnt = parseCount()
            s.last().merge(atom, cnt, Int::plus)
        }
    }
    return s.last().toSortedMap().entries.joinToString("") { (k, v) ->
        if (v == 1) k else "$k$v"
    }
}