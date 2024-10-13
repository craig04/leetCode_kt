package cn_solution

fun lengthAfterTransformations(s: String, t: Int): Int {
    val modulo = 1000000007
    val cnt = IntArray(26)
    s.forEach { cnt[it - 'a']++ }
    var pos = 0
    repeat(t) {
        cnt[pos] += cnt[(pos + 25) % 26]
        cnt[pos] %= modulo
        pos = (pos + 25) % 26
    }
    return cnt.fold(0) { ans, c -> (ans + c) % modulo }
}