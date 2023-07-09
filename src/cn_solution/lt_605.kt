package cn_solution

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var plant = 0
    var prev = false
    for (i in 0 until flowerbed.lastIndex) {
        if (flowerbed[i] == 1) {
            prev = true
            continue
        }
        prev = !prev && flowerbed[i + 1] == 0
        if (prev && ++plant >= n)
            return true
    }
    return plant == n || (plant == n - 1 && !prev && flowerbed.last() == 0)
}