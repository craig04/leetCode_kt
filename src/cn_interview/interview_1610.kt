package cn_interview

fun maxAliveYear(birth: IntArray, death: IntArray): Int {
    val diff = IntArray(102)
    for (i in birth.indices) {
        diff[birth[i] - 1900]++
        diff[death[i] - 1899]--
    }
    var cnt = 0
    var most = 0
    var result = 1900
    diff.forEachIndexed { i, d ->
        cnt += d
        if (cnt > most) {
            most = cnt
            result = i
        }
    }
    return result + 1900
}