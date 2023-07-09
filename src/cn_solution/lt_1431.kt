package cn_solution

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val most = candies.max()!!
    return BooleanArray(candies.size) { candies[it] + extraCandies >= most }.toList()
}