package cn_solution

fun largeGroupPositions(s: String): List<List<Int>> {
    val ans = ArrayList<List<Int>>()
    val n = s.length
    var i = 0
    while (i != n) {
        var j = i + 1
        while (j != n && s[j] == s[i])
            j++
        if (j - i >= 3)
            ans.add(listOf(i, j - 1))
        i = j
    }
    return ans
}