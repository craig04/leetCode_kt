package cn_solution

fun stoneGameVIII(stones: IntArray): Int {
    var pre = stones.sum()
    return (stones.lastIndex downTo 2).fold(pre) { ans, i ->
        pre -= stones[i]
        maxOf(ans, pre - ans)
    }
}