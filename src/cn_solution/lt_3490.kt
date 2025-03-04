package cn_solution

fun beautifulNumbers(l: Int, r: Int): Int {
    fun count(n: Int): Int {
        val str = n.toString()
        val len = str.length
        val map = HashMap<Long, Int>()
        fun dfs(i: Int, p: Int, s: Int, limit: Boolean): Int {
            if (i == len)
                return if (s != 0 && p % s == 0) 1 else 0
            val key = (p * 100L + s) * 10 + i
            val func: () -> Int = {
                val high = if (limit) str[i] - '0' else 9
                (0..high).sumOf {
                    val sum = s + it
                    dfs(i + 1, if (sum == 0) p else p * it, sum, limit && it == high)
                }
            }
            return if (limit) func.invoke() else map.getOrPut(key, func)
        }
        return dfs(0, 1, 0, true)
    }
    return count(r) - count(l - 1)
}