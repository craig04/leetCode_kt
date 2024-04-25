package cn_solution

fun wateringPlants(plants: IntArray, capacity: Int): Int {
    var water = capacity
    var total = plants.size
    plants.forEachIndexed { i, plant ->
        water -= plant
        if (water < 0) {
            water = capacity - plant
            total += 2 * i
        }
    }
    return total
}