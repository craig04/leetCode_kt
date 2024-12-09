package cn_solution

fun minAnagramLength(s: String): Int {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    val gcd = cnt.asSequence()
        .filter { it != 0 }
        .reduce(::gcd)
    val a = IntArray(26)
    loop@ for (len in 1..s.length / 2) {
        val c = s[len - 1] - 'a'
        a[c]++
        if (len < s.length / gcd || s.length % len != 0)
            continue
        val b = IntArray(26)
        for (i in len until s.length step len) {
            a.copyInto(b)
            for (j in i until i + len)
                if (--b[s[j] - 'a'] < 0)
                    continue@loop
        }
        return len
    }
    return s.length
}