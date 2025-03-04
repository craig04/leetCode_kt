package cn_solution

fun maxDepth(s: String): Int {
    var cur = 0
    var ans = 0
    for (c in s) {
        if (c == '(')
            ans = Math.max(ans, ++cur)
        else if (c == ')')
            --cur
    }
    return ans
}