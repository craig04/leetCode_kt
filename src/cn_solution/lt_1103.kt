package cn_solution

private fun distributeCandies(candies: Int, num_people: Int): IntArray {
    val ans = IntArray(num_people)
    var i = 0
    var cur = 0
    var left = candies
    while (left > 0) {
        val dist = minOf(left, ++cur)
        left -= dist
        ans[i] += dist
        if (++i == num_people)
            i = 0
    }
    return ans
}