package cn_solution

fun digitCount(num: String): Boolean {
    val cnt = IntArray(10)
    for (c in num)
        cnt[c - '0']++
    return num.indices.all { cnt[it] == num[it] - '0' }
}