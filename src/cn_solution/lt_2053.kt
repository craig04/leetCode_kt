package cn_solution

fun kthDistinct(arr: Array<String>, k: Int): String {
    val cnt = arr.asSequence().groupingBy { it }.eachCount()
    var idx = 0
    for (s in arr)
        if (cnt[s] == 1 && ++idx == k)
            return s
    return ""
}