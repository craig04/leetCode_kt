package cn_solution

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    val q = tickets.indices.toCollection(ArrayDeque())
    var ans = 0
    while (q.isNotEmpty()) {
        ans++
        val idx = q.removeFirst()
        if (--tickets[idx] != 0)
            q.addLast(idx)
        else if (idx == k)
            break
    }
    return ans
}