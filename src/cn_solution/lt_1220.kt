package cn_solution

fun countVowelPermutation(n: Int): Int {
    var a = 1
    var e = 1
    var i = 1
    var o = 1
    var u = 1
    val rem = 1000000007
    repeat(n - 1) {
        val aa = (e + i) % rem + u
        val ee = a + i
        val ii = e + o
        val oo = i
        val uu = i + o
        a = aa % rem
        e = ee % rem
        i = ii % rem
        o = oo % rem
        u = uu % rem
    }
    return ((((a + e) % rem + i) % rem + o) % rem + u) % rem
}