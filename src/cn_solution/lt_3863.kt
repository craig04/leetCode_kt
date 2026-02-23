package cn_solution

private fun minOperations(s: String): Int {
    val n = s.length
    var min = s[0]
    var max = s[0]
    var minPos = 0
    var maxPos = 0
    var sorted = true
    for (i in 1 until n) {
        if (s[i - 1] > s[i])
            sorted = false
        if (s[i] < min) {
            min = s[i]
            minPos = i
        }
        if (s[i] >= max) {
            max = s[i]
            maxPos = i
        }
    }
    return when {
        sorted -> 0
        s.length == 2 -> -1
        minPos == 0 || maxPos == n - 1 -> 1
        minPos != n - 1 || maxPos != 0 -> 2
        else -> 3
    }
}