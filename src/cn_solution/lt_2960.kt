package cn_solution

fun countTestedDevices(batteryPercentages: IntArray): Int {
    var count = 0
    for (it in batteryPercentages)
        if (it > count)
            count++
    return count
}