package cn_solution

fun sumGame(num: String): Boolean {
    var sum = 0
    var cnt = 0
    val mid = num.length / 2
    for (i in 0 until mid) {
        if (num[i] == '?')
            cnt++
        else
            sum -= num[i] - '0'
    }
    for (i in mid until num.length) {
        if (num[i] == '?')
            cnt--
        else
            sum += num[i] - '0'
    }
    return sum * 2 != cnt * 9
}