package cn_solution

fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
    val deg = IntArray(n)
    for (i in 0 until n) {
        val l = leftChild[i]
        if (l != -1 && ++deg[l] == 2)
            return false
        val r = rightChild[i]
        if (r != -1 && ++deg[r] == 2)
            return false
    }
    var root = -1
    for (i in deg.indices)
        if (deg[i] == 0) {
            if (root != -1)
                return false
            root = i
        }
    fun dfs(i: Int) {
        if (i == -1)
            return
        deg[i] = 0
        dfs(leftChild[i])
        dfs(rightChild[i])
    }
    dfs(root)
    return deg.all { it == 0 }
}