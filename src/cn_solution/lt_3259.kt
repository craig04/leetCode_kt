package cn_solution

private fun maxEnergyBoost(energyDrinkA: IntArray, energyDrinkB: IntArray): Long {
    var a = 0L
    var b = 0L
    var c = 0L
    for (i in energyDrinkA.indices) {
        val x = c
        c = maxOf(a, b)
        a = maxOf(a, x) + energyDrinkA[i]
        b = maxOf(b, x) + energyDrinkB[i]
    }
    return maxOf(a, b)
}