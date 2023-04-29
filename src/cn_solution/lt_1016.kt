package cn_solution

fun queryString(s: String, n: Int): Boolean {
    if (n == 1) {
        return s.contains('1')
    }
    val len = s.length
    val k = (30 downTo 0).first { 1 shl it <= n }
    val lower = 1.shl(k - 1)
    val upper = 1.shl(k)
    if (len < minOf(lower + k - 1, n - upper + k + 1)) {
        return false
    }
    fun test(k: Int, min: Int, max: Int): Boolean {
        val mask = 1.shl(k) - 1
        val set = HashSet<Int>()
        var num = (0 until k - 1).fold(0) { acc, i ->
            acc.shl(1).or(s[i] - '0')
        }
        return (k - 1 until len).any {
            num = num.shl(1).and(mask).or(s[it] - '0')
            num in min..max && set.add(num) && set.size == max - min + 1
        }
    }
    return test(k, lower, upper - 1) && test(k + 1, upper, n)
}