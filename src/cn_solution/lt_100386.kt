package cn_solution

fun maxEnergyBoost(energyDrinkA: IntArray, energyDrinkB: IntArray): Long {
    var a = 0L
    var b = 0L
    var x = 0L
    var y = 0L
    for (i in energyDrinkA.indices) {
        val c = maxOf(b, x) + energyDrinkA[i]
        val z = maxOf(a, y) + energyDrinkB[i]
        a = b
        b = c
        x = y
        y = z
    }
    return maxOf(b, y)
}