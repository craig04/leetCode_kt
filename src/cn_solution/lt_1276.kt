package cn_solution

fun numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): List<Int> {
    if (tomatoSlices and 1 == 1 || tomatoSlices !in (2 * cheeseSlices..4 * cheeseSlices))
        return emptyList()
    val jumbo = (tomatoSlices - 2 * cheeseSlices) / 2
    return listOf(jumbo, cheeseSlices - jumbo)
}