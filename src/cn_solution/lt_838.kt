package cn_solution

fun pushDominoes(dominoes: String): String {
    var i = -1
    var d = 'L'
    val c = dominoes.toCharArray()
    for (j in dominoes.indices) {
        if (dominoes[j] == '.')
            continue
        if (dominoes[j] == d) {
            c.fill(d, i + 1, j)
        } else if (d == 'R') {
            c.fill('R', i + 1, (i + j + 1) / 2)
            c.fill('L', (i + j) / 2 + 1, j)
        }
        i = j
        d = dominoes[j]
    }
    if (d == 'R')
        c.fill('R', i + 1)
    return String(c)
}