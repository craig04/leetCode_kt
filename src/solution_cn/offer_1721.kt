package solution_cn

fun trap(height: IntArray): Int {
    val highest = height.indices.maxBy { height[it] } ?: return 0
    fun calc(progression: IntProgression): Int {
        var temp = 0
        return progression.sumBy {
            temp = maxOf(temp, height[it])
            temp - height[it]
        }
    }
    return calc(0..highest) + calc(height.lastIndex downTo highest)
}