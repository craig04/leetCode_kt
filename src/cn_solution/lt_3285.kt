package cn_solution

fun stableMountains(height: IntArray, threshold: Int): List<Int> {
    return (1 until height.size).filter { height[it - 1] > threshold }
}