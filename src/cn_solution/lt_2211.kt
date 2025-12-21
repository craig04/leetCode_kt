package cn_solution

fun countCollisions(directions: String): Int {
    var i = 0
    var j = directions.lastIndex
    while (i <= j && directions[i] == 'L')
        i++
    while (j >= i && directions[j] == 'R')
        j--
    return (i..j).count { directions[it] != 'S' }
}