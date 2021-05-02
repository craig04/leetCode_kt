package solution_cn

fun climbStairs(n: Int): Int {
    var a = 1
    var b = 1
    repeat(n - 1) {
        val c = a + b
        a = b
        b = c
    }
    return b
}