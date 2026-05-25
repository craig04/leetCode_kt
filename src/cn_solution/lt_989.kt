package cn_solution

fun addToArrayForm(num: IntArray, k: Int): List<Int> {
    val ans = ArrayList<Int>()
    var c = 0
    var i = num.lastIndex
    var t = k
    while (t != 0 || i != -1) {
        if (t != 0)
            c += t % 10
        if (i != -1)
            c += num[i--]
        ans.add(c % 10)
        t /= 10
        c /= 10
    }
    if (c != 0)
        ans.add(c)
    return ans.asReversed()
}