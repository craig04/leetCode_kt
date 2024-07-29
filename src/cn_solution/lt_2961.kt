package cn_solution

fun getGoodIndices(variables: Array<IntArray>, target: Int): List<Int> {
    fun mod(a: Int, b: Int, c: Int): Int {
        var ans = 1L
        var base = a.toLong()
        var time = b
        while (time != 0) {
            if (time and 1 != 0)
                ans = (ans * base) % c
            time = time shr 1
            base = base * base % c
        }
        return ans.toInt()
    }
    return variables.indices.filter {
        val (a, b, c, m) = variables[it]
        mod(mod(a, b, 10), c, m) == target
    }
}