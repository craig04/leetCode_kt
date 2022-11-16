package cn_solution

fun numTilings(n: Int): Int {
    if (n == 1)
        return 1

    class Helper(var a: Int = 0, var b: Int = 0, var c: Int = 0) {
        fun assign(other: Helper) {
            a = other.a
            b = other.b
            c = other.c
        }
    }

    fun Int.add(other: Int) = (this + other) % 1000000007
    val x = Helper(1)
    val y = Helper(2, 1, 1)
    for (i in 2 until n) {
        val z = Helper(x.a.add(y.a).add(y.b).add(y.c), x.a.add(y.c), x.a.add(y.b))
        x.assign(y)
        y.assign(z)
    }
    return y.a
}
