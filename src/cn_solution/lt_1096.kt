package cn_solution

fun braceExpansionII(expression: String): List<String> {
    val c = expression.toCharArray()
    val n = c.size
    var i = 0
    fun parse(): Collection<String> {
        var ans: Collection<String> = listOf("")
        while (i != n && c[i] != ',' && c[i] != '}') {
            if (c[i].isLetter()) {
                var j = i + 1
                while (j != n && c[j].isLetter())
                    j++
                val str = expression.substring(i, j)
                i = j
                ans = ans.map { it + str }
            } else {
                i++
                val sub = HashSet<String>()
                var symbol: Char
                do {
                    sub.addAll(parse())
                    symbol = c[i++]
                } while (symbol == ',')
                val next = HashSet<String>()
                for (a in ans)
                    for (b in sub)
                        next.add(a + b)
                ans = next
            }
        }
        return ans
    }
    return parse().toMutableList().apply { sort() }
}