package cn_solution

fun calculateScore(instructions: Array<String>, values: IntArray): Long {
    val n = instructions.size
    val used = BooleanArray(n)
    var i = 0
    var ans = 0L
    while (i in 0 until n && !used[i]) {
        used[i] = true
        if (instructions[i] == "add")
            ans += values[i++]
        else
            i += values[i]
    }
    return ans
}