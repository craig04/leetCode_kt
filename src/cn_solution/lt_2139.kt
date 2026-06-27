package cn_solution

fun minMoves(target: Int, maxDoubles: Int): Int {
    var x = target
    var y = maxDoubles
    var ans = 0
    while (x != 1 && y != 0) {
        if (x and 1 == 1)
            ans++
        x /= 2
        y--
        ans++
    }
    return ans + x - 1
}