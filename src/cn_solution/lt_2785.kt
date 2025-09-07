package cn_solution

fun sortVowels(s: String): String {
    val vowels = BooleanArray('z' - 'A' + 1)
    val cnt = IntArray(vowels.size)
    "AEIOUaeiou".forEach { vowels[it - 'A'] = true }
    for (c in s)
        cnt[c - 'A']++
    var t = 0
    val c = s.toCharArray()
    for (i in c.indices) {
        if (!vowels[c[i] - 'A'])
            continue
        while (!vowels[t] || cnt[t]-- == 0)
            t++
        c[i] = 'A' + t
    }
    return String(c)
}