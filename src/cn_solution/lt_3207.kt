package cn_solution

fun maximumPoints(enemyEnergies: IntArray, currentEnergy: Int): Long {
    var sum = 0L
    var min = Int.MAX_VALUE
    for (energy in enemyEnergies) {
        sum += energy
        min = minOf(min, energy)
    }
    if (currentEnergy < min)
        return 0
    return (sum - min + currentEnergy) / min
}