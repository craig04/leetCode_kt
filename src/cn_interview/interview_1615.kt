package cn_interview

fun masterMind(solution: String, guess: String): IntArray {
    val result = IntArray(2)
    val s = IntArray(26)
    val g = IntArray(26)
    for (i in 0..3) {
        if (solution[i] == guess[i]) {
            result[0]++
        } else {
            s[solution[i] - 'A']++
            g[guess[i] - 'A']++
        }
    }
    "RYGB".forEach { result[1] += minOf(s[it - 'A'], g[it - 'A']) }
    return result
}