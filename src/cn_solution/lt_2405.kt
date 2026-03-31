package cn_solution

private fun partitionString(s: String): Int {
    var ans = 1
    var x = 0
    for (c in s) {
        val t = 1 shl (c - 'a')
        if (x and t != 0) {
            ans++
            x = 0
        }
        x = x or t
    }
    return ans
}