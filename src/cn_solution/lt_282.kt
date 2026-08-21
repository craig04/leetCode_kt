package cn_solution

fun addOperators(num: String, target: Int): List<String> {
    val ans = mutableListOf<String>()
    val buf = CharArray(num.length * 2)
    var pos = 0
    fun dfs(i: Int, res: Long, mul: Long) {
        if (i == num.length) {
            if (res == target + 0L)
                ans += String(buf, 1, pos - 1)
            return
        }
        val len = pos
        var x = 0L
        var j = i
        buf[pos++] = ' '
        do {
            buf[pos++] = num[j]
            x = x * 10 + (num[j++] - '0')
            buf[len] = '+'
            dfs(j, res + x, x)
            if (i != 0) {
                buf[len] = '-'
                dfs(j, res - x, -x)
                buf[len] = '*'
                dfs(j, res + (x - 1) * mul, mul * x)
            }
        } while (num[i] != '0' && j != num.length)
        pos = len
    }
    dfs(0, 0, 0)
    return ans
}