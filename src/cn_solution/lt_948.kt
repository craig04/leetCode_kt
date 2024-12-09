package cn_solution

fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    tokens.sort()
    var ans = 0
    var p = power
    var s = 0
    var i = 0
    var j = tokens.lastIndex
    while (i <= j) {
        if (p >= tokens[i]) {
            p -= tokens[i++]
            s++
            ans = maxOf(ans, s)
        } else if (s > 0) {
            p += tokens[j--]
            s--
        } else
            break
    }
    return ans
}