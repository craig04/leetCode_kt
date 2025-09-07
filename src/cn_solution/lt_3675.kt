package cn_solution

fun minOperations(s: String): Int {
    return s.maxOf { (26 - (it - 'a')) % 26 }
}