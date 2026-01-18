package cn_solution

fun addBinary(a: String, b: String): String {
    fun get(s: String, i: Int) = if (i < 0) 0 else s[i] - '0'
    val ans = StringBuilder()
    var i = a.lastIndex
    var j = b.lastIndex
    var c = 0
    while (i >= 0 || j >= 0 || c > 0) {
        val s = get(a, i--) + get(b, j--) + c
        ans.append(s and 1)
        c = s shr 1
    }
    return ans.reverse().toString()
}