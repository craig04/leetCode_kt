package cn_solution

fun removeTrailingZeros(num: String): String {
    val i = num.indices.lastOrNull { num[it] != '0' } ?: return "0"
    return num.substring(0, i + 1)
}