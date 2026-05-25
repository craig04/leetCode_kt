package cn_solution

fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
    val n = s.length
    val f = BooleanArray(n)
    f[0] = true
    var j = 0
    for (i in s.indices) {
        if (!f[i])
            continue
        while (j <= minOf(n - 1, i + maxJump)) {
            if (j >= i + minJump && s[j] == '0')
                f[j] = true
            j++
        }
    }
    return f[n - 1]
}