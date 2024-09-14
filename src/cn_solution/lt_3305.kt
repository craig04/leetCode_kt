package cn_solution

private fun countOfSubstrings(word: String, k: Int): Int {
    val vowel = BooleanArray(26)
    "aeiou".forEach { vowel[it - 'a'] = true }
    fun count(t: Int): Int {
        val v = IntArray(26)
        var cat = 0
        var c = 0
        var i = 0
        return word.indices.sumOf { j ->
            val y = word[j] - 'a'
            if (!vowel[y])
                c++
            else if (++v[y] == 1)
                cat++
            while (cat >= 5 && c >= t) {
                val x = word[i++] - 'a'
                if (!vowel[x])
                    c--
                else if (--v[x] == 0)
                    cat--
            }
            i
        }
    }
    return count(k) - count(k + 1)
}