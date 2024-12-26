package cn_solution

fun maximumWhiteTiles(tiles: Array<IntArray>, carpetLen: Int): Int {
    tiles.sortBy { it[0] }
    var left = 0
    var cover = 0
    return tiles.indices.maxOf { right ->
        val (l, r) = tiles[right]
        cover += r - l + 1
        val leftmost = r - carpetLen + 1
        while (leftmost > tiles[left][1]) {
            cover -= tiles[left][1] - tiles[left][0] + 1
            left++
        }
        cover - maxOf(0, leftmost - tiles[left][0])
    }
}