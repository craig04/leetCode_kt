package cn_solution

fun decimalRepresentation(n: Int): IntArray {
    val ans = ArrayList<Int>()
    var pow = 1
    var num = n
    while (num != 0) {
        val t = num % 10
        if (t != 0)
            ans.add(t * pow)
        pow *= 10
        num /= 10
    }
    ans.reverse()
    return ans.toIntArray()
}