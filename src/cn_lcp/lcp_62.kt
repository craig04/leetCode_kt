package cn_lcp

fun transportationHub(path: Array<IntArray>): Int {
    val node = HashSet<Int>()
    val input = IntArray(1001)
    val output = IntArray(1001)
    for ((x, y) in path) {
        node.add(x)
        node.add(y)
        input[y]++
        output[x]++
    }
    val n = node.size
    return node.firstOrNull { input[it] == n - 1 && output[it] == 0 } ?: -1
}