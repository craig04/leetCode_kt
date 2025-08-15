package cn_solution

fun minFlips(target: String): Int {
    var pre = '0'
    return target.count { cur ->
        val old = pre
        pre = cur
        cur != old
    }
}