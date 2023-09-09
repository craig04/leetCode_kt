package cn_solution

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    var last = 0
    var count = 0
    return (0 until flowerbed.lastIndex).any {
        val plant = last or flowerbed[it] or flowerbed[it + 1] xor 1
        last = flowerbed[it] or plant
        count += plant
        count >= n
    } || (count + (last or flowerbed.last() xor 1) >= n)
}