package solution_cn

fun longestSubsequence(arr: IntArray, difference: Int): Int {
    val map = HashMap<Int, Int>()
    var result = 1
    for (a in arr) {
        val len = (map[a - difference] ?: 0) + 1
        map[a] = len
        result = maxOf(result, len)
    }
    return result
}