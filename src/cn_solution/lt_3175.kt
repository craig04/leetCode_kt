package cn_solution

fun findWinningPlayer(skills: IntArray, k: Int): Int {
    var ans = 0
    var win = 0
    for (i in 1 until skills.size) {
        if (skills[ans] < skills[i + 1]) {
            ans = i
            win = 0
        }
        if (++win == k)
            break
    }
    return ans
}