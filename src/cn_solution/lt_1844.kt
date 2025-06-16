package cn_solution

fun replaceDigits(s: String): String {
    val c = s.toCharArray()
    for (i in 1 until c.size step 2)
        c[i] = c[i - 1] + (c[i] - '0')
    return String(c)
}