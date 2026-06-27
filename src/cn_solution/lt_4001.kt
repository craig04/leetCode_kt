package cn_solution

fun aggregateTimeSeries(series1: Array<IntArray>, series2: Array<IntArray>): List<List<Int>> {
    val n = series1.size
    val m = series2.size
    var i = 0
    var j = 0
    val ans = ArrayList<List<Int>>()
    while (i != n || j != m) {
        when {
            i == n -> ans.add(series2[j++].asList())
            j == m -> ans.add(series1[i++].asList())
            else -> {
                val e1 = series1[i]
                val e2 = series2[j]
                val ts = minOf(e1[0], e2[0])
                ans.add(listOf(ts, e1[1] + e2[1]))
                if (e1[0] == ts)
                    i++
                if (e2[0] == ts)
                    j++
            }
        }
    }
    return ans
}