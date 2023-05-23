package cn_interview

fun hanota(A: MutableList<Int>, B: MutableList<Int>, C: MutableList<Int>): Unit {
    fun move(n: Int, a: MutableList<Int>, b: MutableList<Int>, c: MutableList<Int>) {
        if (n == 1) {
            c.add(a.removeAt(a.lastIndex))
            return
        }
        move(n - 1, a, c, b)
        c.add(a.removeAt(a.lastIndex))
        move(n - 1, b, a, c)
    }
    return move(A.size, A, B, C)
}