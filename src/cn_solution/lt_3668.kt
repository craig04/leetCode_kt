package cn_solution

fun recoverOrder(order: IntArray, friends: IntArray): IntArray {
    val set = friends.toHashSet()
    val ans = IntArray(friends.size)
    var pos = 0
    for (x in order)
        if (x in set)
            ans[pos++] = x
    return ans
}