package cn_solution

class OrderedStream(n: Int) {

    private var ptr = 0
    private val list = Array<String?>(n) { null }

    fun insert(idKey: Int, value: String): List<String> {
        list[idKey - 1] = value
        if (idKey - 1 != ptr) {
            return emptyList()
        }
        val result = ArrayList<String>()
        while (ptr != list.size) {
            val str = list[ptr] ?: break
            result.add(str)
            ptr++
        }
        return result
    }
}