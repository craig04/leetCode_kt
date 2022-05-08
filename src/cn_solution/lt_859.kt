package cn_solution

fun buddyStrings(s: String, goal: String): Boolean {
    if (s.length != goal.length) {
        return false
    }
    var diff = 0
    val cnt1 = IntArray(26)
    val cnt2 = IntArray(26)
    for (i in s.indices) {
        val a = s[i] - 'a'
        val b = goal[i] - 'a'
        cnt1[a]++
        cnt2[b]++
        if (a != b) diff++
    }
    var duplicate = false
    return cnt1.indices.all {
        duplicate = duplicate or (cnt1[it] >= 2)
        cnt1[it] == cnt2[it]
    } && (diff == 2 || (diff == 0) && duplicate)
}