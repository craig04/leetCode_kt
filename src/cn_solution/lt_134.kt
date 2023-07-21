package cn_solution

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val n = gas.size
    var i = 0
    while (i < n) {
        var g = 0
        var j = i
        while (true) {
            val pos = j++ % n
            g += gas[pos] - cost[pos]
            if (g < 0)
                break
            if (j == i + n)
                return i
        }
        i = j
    }
    return -1
}