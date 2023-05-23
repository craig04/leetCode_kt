package cn_interview

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    val oldColor = image[sr][sc]
    if (oldColor == newColor) {
        return image
    }
    fun fill(i: Int, j: Int) {
        if (image[i][j] != oldColor)
            return
        image[i][j] = newColor
        if (i != 0) fill(i - 1, j)
        if (j != 0) fill(i, j - 1)
        if (i != image.lastIndex) fill(i + 1, j)
        if (j != image[0].lastIndex) fill(i, j + 1)
    }
    fill(sr, sc)
    return image
}