package cn_solution

fun chalkReplacer(chalk: IntArray, k: Int): Int {
    val chalks = chalk.fold(0L) { sum, c -> sum + c }
    var remain = (k % chalks).toInt()
    var i = 0
    while (remain >= chalk[i]) {
        remain -= chalk[i]
        if (++i == chalk.size)
            i = 0
    }
    return i
}
