package cn_solution

fun diffWaysToCompute(expression: String): List<Int> {
    val len = expression.length
    fun hash(l: Int, r: Int) = l * len + r
    val operations = hashMapOf<Char, (Int, Int) -> Int>(
        '+' to { a, b -> a + b },
        '-' to { a, b -> a - b },
        '*' to { a, b -> a * b },
        '/' to { a, b -> a / b })
    val dp = HashMap<Int, List<Int>>()
    val nums = ArrayList<Int>()
    val ops = ArrayList<(Int, Int) -> Int>()
    var l = 0
    expression.forEachIndexed { r, c ->
        if (!Character.isDigit(c)) {
            nums.add(expression.substring(l, r).toInt())
            l = r + 1
            ops.add(operations[c]!!)
        }
    }
    nums.add(expression.substring(l, len).toInt())

    fun search(l: Int, r: Int): List<Int> {
        return dp.getOrPut(hash(l, r)) {
            if (l == r - 1)
                return@getOrPut listOf(nums[l])
            val result = ArrayList<Int>()
            for (i in l + 1 until r)
                for (left in search(l, i))
                    for (right in search(i, r))
                        result.add(ops[i - 1](left, right))
            result
        }
    }
    return search(0, nums.size)
}