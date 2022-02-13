package cn_solution

class Node(var `val`: Boolean, var isLeaf: Boolean) {
    var topLeft: Node? = null
    var topRight: Node? = null
    var bottomLeft: Node? = null
    var bottomRight: Node? = null
}

fun construct(grid: Array<IntArray>): Node {
    var n = grid.size
    val temp = Array(n) { line ->
        Array(n) { Node(grid[line][it] == 1, true) }
    }
    while (n != 1) {
        for (i in 0 until n / 2) {
            for (j in 0 until n / 2) {
                val c = arrayOf(
                    temp[i * 2 + 0][j * 2 + 0],
                    temp[i * 2 + 0][j * 2 + 1],
                    temp[i * 2 + 1][j * 2 + 0],
                    temp[i * 2 + 1][j * 2 + 1]
                )
                val leaf = c.all { it.isLeaf && it.`val` == c[0].`val` }
                val `val` = leaf && c[0].`val`
                val node = Node(`val`, leaf)
                if (!leaf) {
                    node.topLeft = c[0]
                    node.topRight = c[1]
                    node.bottomLeft = c[2]
                    node.bottomRight = c[3]
                }
                temp[i][j] = node
            }
        }
        n /= 2
    }
    return temp[0][0]
}