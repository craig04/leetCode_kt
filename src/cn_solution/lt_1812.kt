package cn_solution

fun squareIsWhite(coordinates: String): Boolean {
    return (coordinates[0] - 'a').xor(coordinates[1] - '0').and(1) == 0
}