package cn_solution

fun isBalanced(num: String): Boolean {
    return num.indices.sumOf {
        val c = num[it] - '0'
        if (it and 1 == 0) c else -c
    } == 0
}