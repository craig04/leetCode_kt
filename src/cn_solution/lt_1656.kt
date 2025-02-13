package cn_solution

class OrderedStream(val n: Int) {

    private var ptr = 0
    private val list = Array<String?>(n) { null }

    fun insert(idKey: Int, value: String): List<String> {
        list[idKey - 1] = value
        val result = ArrayList<String>()
        while (ptr != n) {
            result.add(list[ptr] ?: break)
            ptr++
        }
        return result
    }
}