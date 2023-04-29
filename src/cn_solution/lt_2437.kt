package cn_solution

fun countTime(time: String): Int {
    var result = 1
    val h1 = time[0]
    val h2 = time[1]
    if (h1 == '?') {
        result = when {
            h2 == '?' -> 24
            h2 <= '3' -> 3
            else -> 2
        }
    } else if (h2 == '?') {
        result = when {
            h1 <= '1' -> 9
            else -> 4
        }
    }
    if (time[3] == '?')
        result *= 6
    if (time[4] == '?')
        result *= 10
    return result
}