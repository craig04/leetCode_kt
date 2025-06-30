package cn_solution

fun minMoves(sx: Int, sy: Int, tx: Int, ty: Int): Int {
    var s = 0
    var x = tx
    var y = ty
    while (x > sx || y > sy) {
        when {
            x >= y * 2 -> {
                if (x % 2 == 1)
                    break
                x /= 2
            }
            y >= x * 2 -> {
                if (y % 2 == 1)
                    break
                y /= 2
            }
            x > y -> x -= y
            y > x -> y -= x
            sx == 0 -> x = 0
            sy == 0 -> y = 0
            else -> break
        }
        s++
    }
    return if (x == sx && y == sy) s else -1
}