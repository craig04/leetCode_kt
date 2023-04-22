package cn_solution

fun minimumRecolors(blocks: String, k: Int): Int {
    var white = (0 until k).count { blocks[it] == 'W' }
    return (k until blocks.length).fold(white) { res, i ->
        white += (blocks[i] - blocks[i - k]) / 21
        minOf(res, white)
    }
}