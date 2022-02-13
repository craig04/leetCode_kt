package cn_solution

fun minOperations(logs: Array<String>): Int {
    var temp = 0
    for (l in logs) {
        when (l) {
            "../" -> temp = maxOf(temp - 1, 0)
            "./" -> Unit
            else -> temp++
        }
    }
    return temp
}