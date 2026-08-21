package cn_solution

import kotlin.math.sqrt

fun getMinDistSum_hillClimbing(positions: Array<IntArray>): Double {
    fun distance(x: Double, y: Double): Double {
        return positions.sumOf { (a, b) ->
            val hor = a - x
            val ver = b - y
            sqrt(hor * hor + ver * ver)
        }
    }

    val dir = intArrayOf(-1, 0, 0, -1, 0, 1, 1, 0)
    var step = 1.0
    var x = 0.0
    var y = 0.0
    for ((a, b) in positions) {
        x += a
        y += b
    }
    x /= positions.size
    y /= positions.size
    var dist = distance(x, y)
    loop@ while (step > 1e-6) {
        for (i in dir.indices.step(2)) {
            val u = x + step * dir[i]
            val v = y + step * dir[i + 1]
            val d = distance(u, v)
            if (d < dist) {
                x = u
                y = v
                dist = d
                continue@loop
            }
        }
        step /= 2
    }
    return distance(x, y)
}

fun getMinDistSum_ternarySearch(positions: Array<IntArray>): Double {
    fun distance(x: Double, y: Double): Double {
        return positions.sumOf { (a, b) ->
            val hor = a - x
            val ver = b - y
            sqrt(hor * hor + ver * ver)
        }
    }

    fun minDistance(x: Double): Double {
        var l = 0.0
        var r = 100.0
        while (r - l > 1e-6) {
            val y1 = (l * 2 + r) / 3.0
            val y2 = (l + r * 2) / 3.0
            if (distance(x, y1) < distance(x, y2))
                r = y2
            else
                l = y1
        }
        return distance(x, (l + r) / 2)
    }

    var l = 0.0
    var r = 100.0
    while (r - l > 1e-6) {
        val x1 = (l * 2 + r) / 3.0
        val x2 = (l + r * 2) / 3.0
        if (minDistance(x1) < minDistance(x2))
            r = x2
        else
            l = x1
    }
    return minDistance((l + r) / 2)
}