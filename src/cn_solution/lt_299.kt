package cn_solution

fun getHint(secret: String, guess: String): String {
    val x = IntArray(10)
    val y = IntArray(10)
    val bulls = secret.indices.count {
        val s = secret[it]
        val g = guess[it]
        if (s != g) {
            x[s - '0']++
            y[g - '0']++
        }
        s == g
    }
    return "${bulls}A${x.indices.sumBy { minOf(x[it], y[it]) }}B"
}