package cn_solution

fun smallestBeautifulString(s: String, k: Int): String {
    fun pick(a: Char, b: Char): Char {
        return arrayListOf('a', 'b', 'c').run {
            remove(a)
            remove(b)
            first()
        }
    }

    val ca = s.toCharArray(CharArray(s.length + 2), 2)
    for (i in ca.lastIndex downTo 2) {
        for (c in ca[i] + 1..minOf(ca[i] + 3, 'a' + k - 1)) {
            if (c == ca[i - 1] || c == ca[i - 2])
                continue
            ca[i] = c
            val loop = CharArray(3)
            loop[0] = pick(ca[i - 1], ca[i])
            loop[1] = pick(ca[i], loop[0])
            loop[2] = pick(loop[0], loop[1])
            for (j in i + 1 until ca.size)
                ca[j] = loop[(j - i - 1) % 3]
            return String(ca, 2, ca.size - 2)
        }
    }
    return ""
}