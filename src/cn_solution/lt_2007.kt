package cn_solution

fun findOriginalArray(changed: IntArray): IntArray {
    changed.sort()
    val q = ArrayDeque<Int>()
    var i = 0
    val result = IntArray(changed.size / 2)
    for (c in changed) {
        if (c == q.firstOrNull()) {
            q.removeFirst()
            continue
        }
        q.addLast(c * 2)
        if (i == result.size)
            return IntArray(0)
        result[i++] = c
    }
    return result
}