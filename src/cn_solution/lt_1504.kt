package cn_solution

fun numSubmat(mat: Array<IntArray>): Int {
    val m = mat[0].size
    val h = IntArray(m)
    val s = Array(m + 1) { IntArray(3) }
    s[0].fill(-1, 0, 2)
    var ans = 0
    for (i in mat.indices) {
        var top = 0
        for (j in 0 until m) {
            h[j] = if (mat[i][j] == 0) 0 else h[j] + 1
            while (h[j] <= s[top][1])
                top--
            val a = s[top++]
            val cnt = h[j] * (j - a[0]) + a[2]
            s[top][0] = j
            s[top][1] = h[j]
            s[top][2] = cnt
            ans += cnt
        }
    }
    return ans
}