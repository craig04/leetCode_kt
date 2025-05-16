package cn_solution

class TreeAncestor(n: Int, parent: IntArray) {

    val m = 33 - (n - 1).countLeadingZeroBits()
    val p = Array(n) { IntArray(m) { -1 } }


    init {
        for (i in 0 until n)
            p[i][0] = parent[i]
        for (j in 1 until m)
            for (i in 0 until n) {
                val k = p[i][j - 1]
                if (k != -1)
                    p[i][j] = p[k][j - 1]
            }
    }

    fun getKthAncestor(node: Int, k: Int): Int {
        var ans = node
        var t = k
        while (t > 0) {
            ans = p[ans][t.countTrailingZeroBits()]
            if (ans == -1)
                break
            t = t and (t - 1)
        }
        return ans
    }
}