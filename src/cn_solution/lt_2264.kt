package cn_solution

fun largestGoodInteger(num: String): String {
    var c = '0' - 1
    var i = 0
    for (j in num.indices) {
        if (num[i] != num[j])
            i = j
        else if (j - i == 2)
            c = maxOf(c, num[i])
    }
    return if (c < '0') "" else "$c$c$c"
}