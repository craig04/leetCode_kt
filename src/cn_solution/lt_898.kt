package cn_solution

fun subarrayBitwiseORs(arr: IntArray): Int {
    val set = HashSet<Int>()
    for (i in arr.indices) {
        set.add(arr[i])
        for (j in i - 1 downTo 0) {
            val or = arr[j] or arr[i]
            set.add(or)
            if (arr[j] == or)
                break
            arr[j] = or
        }
    }
    return set.size
}