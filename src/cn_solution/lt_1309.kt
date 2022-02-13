package cn_solution

fun freqAlphabets(s: String): String {
    return buildString {
        var i = 0
        val c = s.toCharArray()
        while (i != c.size) {
            val sharp = i + 2
            if (sharp < c.size && c[sharp] == '#') {
                append('a' + c[i].seq() * 10 + c[i + 1].seq() - 1)
                i += 3
            } else {
                append('a' + c[i].seq() - 1)
                i++
            }
        }
    }
}

private fun Char.seq() = this - '0'
