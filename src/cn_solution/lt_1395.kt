package cn_solution

fun numTeams(rating: IntArray): Int {
    return rating.indices.sumOf { j ->
        var inc1 = 0
        var dec1 = 0
        var inc2 = 0
        var dec2 = 0
        for (i in 0 until j)
            when (rating[i].compareTo(rating[j])) {
                -1 -> inc1++
                1 -> dec1++
            }
        for (k in j + 1 until rating.size)
            when (rating[j].compareTo(rating[k])) {
                -1 -> inc2++
                1 -> dec2++
            }
        inc1 * inc2 + dec1 * dec2
    }
}