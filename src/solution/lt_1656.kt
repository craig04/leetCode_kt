package solution

class OrderedStream(val n: Int) {

    private var pos = 0
    private val data = Array<String?>(n) { null }

    fun insert(id: Int, value: String): List<String> {
        data[id - 1] = value
        val result = mutableListOf<String>()
        while (pos != n) {
            data[pos]?.also {
                result.add(it)
                pos++
            } ?: break
        }
        return result
    }
}