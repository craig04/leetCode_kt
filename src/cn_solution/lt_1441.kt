package cn_solution

fun buildArray(target: IntArray, n: Int): List<String> {
    var idx = 0
    val result = ArrayList<String>()
    for (i in 1..n) {
        result.add("Push")
        if (target[idx] != i)
            result.add("Pop")
        else if (++idx == target.size)
            break
    }
    return result
}