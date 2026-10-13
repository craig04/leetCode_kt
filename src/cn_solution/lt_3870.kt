package cn_solution

fun countCommas(n: Int): Int {
    var ans = 0
    var low = 1000
    while (n >= low) {
        ans += n - low + 1
        low *= 1000
    }
    return ans
}