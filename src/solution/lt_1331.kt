package solution

fun arrayRankTransform(arr: IntArray): IntArray {
    val rate = HashMap<Int, Int>()
    val copy = arr.sortedArray()
    var index = 0
    var lastInt = if (arr.isEmpty()) 0 else arr[0] - 1
    copy.forEach {
        if (it != lastInt) {
            rate[it] = ++index
            lastInt = it
        }
    }
    return IntArray(arr.size) { rate[arr[it]]!! }
}