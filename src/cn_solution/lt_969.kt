package cn_solution

fun pancakeSort(arr: IntArray): List<Int> {
    fun reverse(from: Int, to: Int) {
        var l = from
        var r = to
        while (l < r) {
            val temp = arr[l]
            arr[l++] = arr[r]
            arr[r--] = temp
        }
    }

    val result = ArrayList<Int>()
    for (i in arr.indices.reversed()) {
        if (arr[i] == i + 1) continue
        val j = (0 until i).first { arr[it] == i + 1 }
        reverse(0, j)
        reverse(0, i)
        result.add(j + 1)
        result.add(i + 1)
    }
    return result
}