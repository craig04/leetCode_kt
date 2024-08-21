package cn_solution

fun numFriendRequests(ages: IntArray): Int {
    val cnt = IntArray(121)
    val pre = IntArray(121)
    ages.forEach { cnt[it]++ }
    for (i in 1..120)
        pre[i] = pre[i - 1] + cnt[i]
    return (15..120).sumOf {
        cnt[it] * (pre[it] - pre[it.shr(1) + 7] - 1)
    }
}