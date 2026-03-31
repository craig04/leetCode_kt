package cn_solution

fun areSimilar(mat: Array<IntArray>, k: Int): Boolean {
    val m = mat[0].size
    var move = k % m
    if (move == 0)
        return true
    for (line in mat) {
        var a = 0
        var b = m - move
        while (a != m) {
            if (line[a] != line[b])
                return false
            a++
            b = (b + 1) % m
        }
        move = m - move
    }
    return true
}