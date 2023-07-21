package cn_solution

import kotlin.math.pow
import kotlin.math.sign

fun getMaxGridHappiness(m: Int, n: Int, introvertsCount: Int, extrovertsCount: Int): Int {
    val status = 3.0.pow(n).toInt()
    val adj = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, -60, -10),
        intArrayOf(0, -10, 40)
    )

    fun cube() = Array(status) {
        Array(introvertsCount + 1) {
            IntArray(extrovertsCount + 1) { -1 }
        }
    }

    var pre = cube()
    pre[0][0][0] = 0
    for (pos in 0 until m * n) {
        val cur = cube()
        for (s in 0 until status) {
            val up = s * 3 / status
            val left = s % 3
            val base = s * 3 % status
            for (i in 0..introvertsCount)
                for (e in 0..extrovertsCount) {
                    if (pre[s][i][e] == -1)
                        continue
                    cur[base][i][e] = maxOf(cur[base][i][e], pre[s][i][e])
                    if (i != introvertsCount) {
                        cur[base + 1][i + 1][e] = maxOf(
                            cur[base + 1][i + 1][e],
                            pre[s][i][e] + 120 + adj[1][up] + adj[1][left] * (pos % n).sign
                        )
                    }
                    if (e != extrovertsCount) {
                        cur[base + 2][i][e + 1] = maxOf(
                            cur[base + 2][i][e + 1],
                            pre[s][i][e] + 40 + adj[2][up] + adj[2][left] * (pos % n).sign
                        )
                    }
                }
        }
        pre = cur
    }
    var result = 0
    for (matrix in pre)
        for (line in matrix)
            for (element in line)
                result = maxOf(result, element)
    return result
}