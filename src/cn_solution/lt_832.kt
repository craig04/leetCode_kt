package cn_solution

fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
    val w = image[0].size
    return Array(image.size) { i -> IntArray(w) { j -> image[i][w - j - 1] xor 1 } }
}