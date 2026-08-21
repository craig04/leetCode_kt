package cn_solution

fun countGroups(position: IntArray, speed: IntArray, distance: Int): Int {
    var min = speed.last()
    var ans = 1
    for (i in speed.size - 2 downTo 0)
        if (speed[i] <= min && position[i + 1] - position[i] > distance) {
            min = speed[i]
            ans++
        }
    return ans
}