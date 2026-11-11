package cn_solution

fun isFascinating(n: Int): Boolean {
    return n <= 333 && "$n${n * 2}${n * 3}".fold(0) { m, c ->
        1.shl(c - '0').or(m)
    } == 1022
}