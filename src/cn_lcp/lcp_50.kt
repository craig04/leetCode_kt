package cn_lcp

fun giveGem(gem: IntArray, operations: Array<IntArray>): Int {
    operations.forEach { (x, y) ->
        val num = gem[x] shr 1
        gem[x] -= num
        gem[y] += num
    }
    return gem.max() - gem.min()
}