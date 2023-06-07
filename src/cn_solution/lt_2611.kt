package cn_solution

fun miceAndCheese(reward1: IntArray, reward2: IntArray, k: Int): Int {
    var result = 0
    val n = reward1.size
    val diff = IntArray(n)
    reward2.forEachIndexed { i, r ->
        diff[i] = reward1[i] - r
        result += r
    }
    diff.sort()
    return (n - 1 downTo n - k).sumBy { diff[it] } + result
}