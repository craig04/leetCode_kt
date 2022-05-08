package cn_solution

fun maximumPopulation(logs: Array<IntArray>): Int {
    val count = IntArray(101)
    for ((birth, death) in logs) {
        for (i in birth until death) {
            count[i - 1950]++
        }
    }
    var most = 0
    return count.indices.reversed().last {
        most = maxOf(most, count[it])
        count[it] >= most
    } + 1950
}