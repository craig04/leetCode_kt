package cn_interview

private fun permutation(S: String): Array<String> {
    val c = S.toCharArray()
    fun swap(i: Int, j: Int) {
        val temp = c[i]
        c[i] = c[j]
        c[j] = temp
    }

    fun nextPermutation(): Boolean {
        var i = (c.lastIndex - 1 downTo 0).firstOrNull {
            c[it + 1] > c[it]
        } ?: return false
        var j = (c.lastIndex downTo i).first { c[it] > c[i] }
        swap(i++, j)
        j = c.lastIndex
        while (i < j)
            swap(i++, j--)
        return true
    }
    c.sort()
    val result = ArrayList<String>()
    do {
        result.add(String(c))
    } while (nextPermutation())
    return Array(result.size) { result[it] }
}