package cn_solution

fun minMovesToMakePalindrome(s: String): Int {
    val c = s.toCharArray()
    var i = 0
    var j = c.lastIndex
    var steps = 0
    var single = s.length / 2
    while (i <= j) {
        val k = (i until j).firstOrNull { c[it] == c[j] }
        if (k == null) {
            single = j--
            continue
        }
        for (t in k downTo i + 1)
            c[t] = c[t - 1]
        steps += k - i
        c[i++] = c[j--]
    }
    return steps + single - s.length / 2
}