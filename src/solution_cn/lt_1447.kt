package solution_cn

fun simplifiedFractions(n: Int): List<String> {
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    val result = ArrayList<String>()
    for (i in 2..n) {
        for (j in 1 until i) {
            if (gcd(i, j) == 1) {
                result.add("$j/$i")
            }
        }
    }
    return result
}