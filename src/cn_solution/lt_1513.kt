package cn_solution

fun numSub(s: String): Int {
    var cnt = 0
    var ans = 0L
    for (c in s) {
        if (c == '0')
            cnt = 0
        else
            ans += ++cnt
    }
    return ans.mod(1000000007)
}