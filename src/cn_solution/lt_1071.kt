package cn_solution

fun gcdOfStrings(str1: String, str2: String): String {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    return str1.substring(0, if (str1 + str2 == str2 + str1) gcd(str1.length, str2.length) else 0)
}