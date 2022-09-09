package cn_solution

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val init = image[sr][sc]
    val n = image.size - 1
    val m = image[0].size - 1
    fun fill(x: Int, y: Int) {
        if (image[x][y] == init) {
            image[x][y] = color
            if (x != 0) fill(x - 1, y)
            if (x != n) fill(x + 1, y)
            if (y != 0) fill(x, y - 1)
            if (y != m) fill(x, y + 1)
        }
    }
    if (init != color)
        fill(sr, sc)
    return image
}