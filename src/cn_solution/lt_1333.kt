package cn_solution

fun filterRestaurants(
    restaurants: Array<IntArray>,
    veganFriendly: Int,
    maxPrice: Int,
    maxDistance: Int
): List<Int> {
    return restaurants
        .asSequence()
        .filter { it[2] <= veganFriendly && it[3] <= maxPrice && it[4] <= maxDistance }
        .sortedWith { (i1, r1), (i2, r2) -> if (r1 == r2) i2 - i1 else r2 - r1 }
        .map { it[0] }
        .toList()
}