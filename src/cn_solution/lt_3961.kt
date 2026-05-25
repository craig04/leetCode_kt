package cn_solution

fun maxRatings(units: Array<IntArray>): Long {
    if (units.first().size == 1)
        return units.fold(0L) { ans, u -> ans + u[0] }
    var sum = 0L
    var min = Int.MAX_VALUE
    var min2 = Int.MAX_VALUE
    for (unit in units) {
        var x = Int.MAX_VALUE
        var y = Int.MAX_VALUE
        for (u in unit) {
            if (u < x) {
                y = x
                x = u
            } else if (u < y)
                y = u
        }
        sum += y
        min = minOf(min, x)
        min2 = minOf(min2, y)
    }
    return sum + min - min2
}