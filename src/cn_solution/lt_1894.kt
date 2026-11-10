package cn_solution

fun chalkReplacer(chalk: IntArray, k: Int): Int {
    val chalks = chalk.sumOf(Int::toLong)
    var remain = (k % chalks).toInt()
    var i = 0
    while (remain >= chalk[i]) {
        remain -= chalk[i]
        if (++i == chalk.size)
            i = 0
    }
    return i
}
