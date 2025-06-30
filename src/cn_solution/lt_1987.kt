package cn_solution

fun numberOfUniqueGoodSubsequences(binary: String): Int {
    val modulo = 1000000007
    var x = 0
    var y = 0
    var z = 0
    for (c in binary) {
        if (c == '1') {
            y = (x + y + 1) % modulo
        } else {
            x = (x + y) % modulo
            z = 1
        }
    }
    return (x + y + z) % modulo
}