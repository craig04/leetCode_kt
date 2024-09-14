package cn_solution

fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
    val family = intArrayOf(30, 120, 480)
    val m = reservedSeats.size
    var ans = 0
    var pre = 1
    var i = 0
    var f: Int
    reservedSeats.sortWith(compareBy({ it[0] }, { it[1] }))
    while (i != m) {
        f = 1023
        val (u, _) = reservedSeats[i]
        var j = i
        while (j != reservedSeats.size && reservedSeats[j][0] == u)
            f = 1.shl(reservedSeats[j++][1] - 1).xor(f)
        ans += (u - pre) * 2
        if (f.and(510) == 510)
            ans += 2
        else if (family.any { f and it == it })
            ans++
        pre = u + 1
        i = j
    }
    return ans + (n + 1 - pre) * 2
}