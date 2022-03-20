package cn_solution

fun addDigits(num: Int): Int {
    return if (num == 0) 0 else (num - 1) % 9 + 1
}