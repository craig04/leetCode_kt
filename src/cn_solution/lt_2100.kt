package cn_solution

fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
    val n = security.size
    val dec = IntArray(n)
    dec[0] = 0
    for (i in 1 until n)
        if (security[i] <= security[i - 1])
            dec[i] = dec[i - 1] + 1
    val result = ArrayList<Int>()
    var last = Int.MAX_VALUE
    var count = -1
    for (i in n - 1 downTo 0) {
        count = if (security[i] <= last) count + 1 else 0
        last = security[i]
        if (count >= time && dec[i] >= time) {
            result.add(i)
        }
    }
    return result
}