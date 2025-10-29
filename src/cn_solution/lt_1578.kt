package cn_solution

fun minCost(colors: String, neededTime: IntArray): Int {
    val n = colors.length
    var ans = 0
    var max = 0
    for (i in colors.indices) {
        ans += neededTime[i]
        max = maxOf(max, neededTime[i])
        if (i == n - 1 || colors[i] != colors[i + 1]) {
            ans -= max
            max = 0
        }
    }
    return ans
}