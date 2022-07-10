package cn_solution

fun reformat(s: String): String {
    val sb = Array(2) { StringBuilder() }
    for (c in s) {
        sb[if (c <= '9') 0 else 1].append(c)
    }
    if (Math.abs(sb[0].length - sb[1].length) > 1) {
        return ""
    }
    if (sb[0].length < sb[1].length) {
        val t = sb[0]
        sb[0] = sb[1]
        sb[1] = t
    }
    val result = StringBuilder()
    for (i in 0 until sb[0].length + sb[1].length) {
        result.append(sb[i % 2][i / 2])
    }
    return result.toString()
}