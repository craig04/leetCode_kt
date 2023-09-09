package cn_lcr

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val n = temperatures.size
    val result = IntArray(n)
    val indices = ArrayList<Int>()
    temperatures.forEachIndexed { i, temp ->
        while (indices.isNotEmpty() && temp > temperatures[indices.last()]) {
            val t = indices.last()
            result[t] = i - t
            indices.removeAt(indices.lastIndex)
        }
        indices.add(i)
    }
    indices.forEach { result[it] = 0 }
    return result
}