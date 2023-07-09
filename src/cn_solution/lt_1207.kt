package cn_solution

fun uniqueOccurrences(arr: IntArray): Boolean {
    val map = HashMap<Int, Int>()
    arr.forEach { map[it] = (map[it] ?: 0) + 1 }
    val set = HashSet<Int>()
    return map.all { set.add(it.value) }
}