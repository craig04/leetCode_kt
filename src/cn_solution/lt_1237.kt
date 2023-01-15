package cn_solution

class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    fun f(x: Int, y: Int): Int = TODO()
}

fun findSolution(customfunction: CustomFunction, z: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    var x = 1
    var y = 1000
    while (x <= 1000 && y >= 1) {
        val t = customfunction.f(x, y)
        if (t == z) result.add(listOf(x, y))
        if (t <= z) x++
        if (t >= z) y--
    }
    return result
}