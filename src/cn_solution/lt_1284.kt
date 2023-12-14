package cn_solution

fun minFlips(mat: Array<IntArray>): Int {
    val n = mat.size
    val m = mat[0].size
    val bits = n * m
    val init = (0 until bits).fold(0) { acc, i ->
        mat[i / m][i % m] shl i or acc
    }
    val d = intArrayOf(-1, 0, 0, -1, 0, 0, 0, 1, 1, 0)
    val flip = IntArray(bits) {
        val i = it / m
        val j = it % m
        (d.indices step 2).fold(0) { acc, k ->
            val x = i + d[k]
            val y = j + d[k + 1]
            if (x in 0 until n && y in 0 until m)
                1 shl (x * m + y) or acc
            else
                acc
        }
    }
    val result = (0 until 1.shl(m)).minOf { i ->
        var cnt = i.countOneBits()
        var temp = (0 until m).fold(init) { acc, j ->
            if (1.shl(j).and(i) == 0) acc else acc xor flip[j]
        }
        for (j in m until bits)
            if (1.shl(j - m).and(temp) != 0) {
                temp = temp xor flip[j]
                cnt++
            }
        if (temp == 0) cnt else Int.MAX_VALUE
    }
    return if (result == Int.MAX_VALUE) -1 else result
}