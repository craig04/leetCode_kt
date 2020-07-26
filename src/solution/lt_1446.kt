package solution

fun maxPower(s: String): Int {
    var start = 0
    var power = 0
    s.forEachIndexed { index, c ->
        if (c != s[start]) {
            power = maxOf(power, index - start)
            start = index
        }
    }
    return maxOf(power, s.length - start)
}