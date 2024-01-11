package cn_solution

fun maximumRobots(chargeTimes: IntArray, runningCosts: IntArray, budget: Long): Int {
    val charge = ArrayDeque<Int>()
    var running = 0L
    var result = 0
    var i = -1
    for (j in chargeTimes.indices) {
        val c = chargeTimes[j]
        val r = runningCosts[j]
        while (charge.lastOrNull()?.let { it < c } == true)
            charge.removeLast()
        charge.addLast(c)
        running += r
        while (charge.firstOrNull()?.let { it + running * (j - i) > budget } == true) {
            if (charge.first() == chargeTimes[++i])
                charge.removeFirst()
            running -= runningCosts[i]
        }
        result = maxOf(result, j - i)
    }
    return result
}