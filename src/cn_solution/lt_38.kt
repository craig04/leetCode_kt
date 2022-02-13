package cn_solution

fun countAndSay(n: Int): String {
    var str = "1"
    val next = StringBuilder()
    for (i in 1 until n) {
        next.clear()
        var s = 0
        while (s != str.length) {
            var e = s + 1
            val c = str[s]
            while (e != str.length && c == str[e]) {
                e++
            }
            next.append(e - s).append(str[s])
            s = e
        }
        str = next.toString()
    }
    return str
}