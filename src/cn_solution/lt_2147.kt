package cn_solution

private const val MOD = 1000000007

fun numberOfWays(corridor: String): Int {
    var s = 0
    var p = 0
    var result = 1L
    for (c in corridor) {
        if (c == 'P')
            p++
        else if (++s % 2 == 0) {
            p = 0
        } else if (s >= 3) {
            result = result * (p + 1) % MOD
        }
    }
    return if (s == 0 || s % 2 == 1) 0 else result.toInt()
}