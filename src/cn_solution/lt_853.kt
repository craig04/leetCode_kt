package cn_solution

fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val n = position.size
    val cars = Array(n) { intArrayOf(target - position[it], speed[it]) }
    cars.sortBy { it[0] }
    var ans = 0
    var i = 0
    while (i != n) {
        var j = i + 1
        while (j != n && 1L * cars[i][0] * cars[j][1] * 1L >= 1L * cars[j][0] * cars[i][1])
            j++
        ans++
        i = j
    }
    return ans
}