package cn_solution

fun complexNumberMultiply(num1: String, num2: String): String {
    fun String.toComplex() = indexOf('+').let {
        Pair(substring(0, it).toInt(), substring(it + 1, lastIndex).toInt())
    }

    val c1 = num1.toComplex()
    val c2 = num2.toComplex()
    return "${c1.first * c2.first - c1.second * c2.second}+${c1.first * c2.second + c1.second * c2.first}i"
}