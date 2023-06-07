package cn_solution

class TreeAncestor(private val n: Int, private val parent: IntArray) {

    private val depth = 16
    private val ancestor = Array(n) { IntArray(depth) { -1 } }

    init {
        parent.forEachIndexed { i, p -> ancestor[i][0] = p }
        for (j in 1 until depth) {
            for (i in 0 until n) {
                val a = ancestor[i][j - 1]
                if (a != -1) {
                    ancestor[i][j] = ancestor[a][j - 1]
                }
            }
        }
    }

    fun getKthAncestor(node: Int, k: Int): Int {
        var t = k
        var id = node
        for (i in 0 until depth) {
            if (t == 0 || id == -1)
                break
            val bit = 1 shl i
            if (t and bit != 0) {
                t = t xor bit
                id = ancestor[id][i]
            }
        }
        return id
    }
}