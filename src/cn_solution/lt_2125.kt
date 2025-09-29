package cn_solution

fun numberOfBeams(bank: Array<String>): Int {
    var ans = 0
    var pre = 0
    for (s in bank) {
        val cnt = s.sumOf { it - '0' }
        if (cnt != 0) {
            ans += cnt * pre
            pre = cnt
        }
    }
    return ans
}