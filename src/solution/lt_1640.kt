package solution

fun canFormArray(arr: IntArray, pieces: Array<IntArray>): Boolean {
    val map = pieces.associateBy { it[0] }
    var idx = 0
    while (idx != arr.size) {
        val p = map[arr[idx]] ?: return false
        if (p.indices.any { p[it] != arr[idx + it] }) {
            return false
        }
        idx += p.size
    }
    return true
}