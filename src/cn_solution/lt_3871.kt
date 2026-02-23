package cn_solution

fun countCommas(n: Long): Long {
    var ans = 0L
    var low = 1000L
    while (n >= low) {
        ans += n - low + 1
        low *= 1000
    }
    return ans
}