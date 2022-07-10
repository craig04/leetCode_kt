package cn_solution

fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    val result = IntArray(n)
    val stack = ArrayList<IntArray>()
    for (log in logs) {
        val first = log.indexOf(':')
        val second = log.indexOf(':', first + 1)
        val idx = log.substring(0, first).toInt()
        val start = second - first == 6
        val t = log.substring(second + 1).toInt()
        if (start) {
            stack.add(intArrayOf(t, 0))
        } else {
            val temp = stack.removeAt(stack.lastIndex)
            val time = t - temp[0] + 1
            result[idx] += time - temp[1]
            if (stack.isNotEmpty()) {
                stack.last()[1] += time
            }
        }
    }
    return result
}