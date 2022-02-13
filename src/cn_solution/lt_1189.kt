package cn_solution

fun maxNumberOfBalloons(text: String): Int {
    val count = IntArray(26)
    text.forEach { count[it - 'a']++ }
    count['o' - 'a'] /= 2
    count['n' - 'a'] /= 2
    return "ablon".fold(Int.MAX_VALUE) { res, c -> minOf(res, count[c - 'a']) }
}