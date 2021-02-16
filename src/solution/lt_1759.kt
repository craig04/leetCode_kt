package solution

fun countHomogenous(s: String): Int {
    var result = 0L
    var count = 0
    var cur = ' '
    s.toCharArray().forEach {
        if (it != cur) {
            cur = it
            count = 0
        }
        result += ++count
    }
    return (result % 1000000007).toInt()
}