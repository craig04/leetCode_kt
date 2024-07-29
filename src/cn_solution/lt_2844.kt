package cn_solution

fun minimumOperations(num: String): Int {
    val n = num.length
    val p = arrayOf("00", "52", "05", "57")
    val c = IntArray(4)
    for (i in num.indices.reversed()) {
        val digit = num[i]
        for (j in p.indices)
            if (c[j] != 2 && digit == p[j][c[j]])
                if (++c[j] == 2)
                    return n - i - 2
    }
    return if (num.contains('0')) n - 1 else n
}