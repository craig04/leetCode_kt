package cn_solution

fun minEnd(n: Int, x: Int): Long {
    var ans = x.toLong()
    var t = n - 1
    var y = ans.inv()
    while (t != 0) {
        val low = y and -y
        y = y xor low
        if (t and 1 == 1)
            ans = ans or low
        t = t shr 1
    }
    return ans
}