package cn_solution

fun minSwaps(s: String): Int {
    var cnt = 0
    for (c in s)
        if (c == '[' || cnt == 0)
            cnt++
        else
            cnt--
    return cnt / 2
}