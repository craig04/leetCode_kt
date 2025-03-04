package cn_solution

private fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
    return fruits.count { fruit ->
        val j = baskets.indexOfFirst { it >= fruit }
        if (j != -1)
            baskets[j] = 0
        j == -1
    }
}