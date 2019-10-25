package solution

fun uniqueOccurrences(arr: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    return arr.groupBy { it }.values.all { set.add(it.size) }
}