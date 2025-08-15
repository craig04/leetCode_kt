package cn_solution

fun maxTotal(value: IntArray, limit: IntArray): Long {
    val n = value.size
    val a = Array(n) { intArrayOf(value[it], limit[it]) }
    a.sortWith(compareBy({ it[1] }, { -it[0] }))
    var ans = 0L
    var cnt = 0
    var i = 0
    var j = 0
    while (j != n) {
        if (a[i][1] != a[j][1]) {
            cnt = 0
            i = j
        }
        if (cnt++ < a[j][1])
            ans += a[j][0]
        j++
    }
    return ans
}