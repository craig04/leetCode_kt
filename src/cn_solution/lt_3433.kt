package cn_solution

fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
    val ans = IntArray(numberOfUsers)
    val online = IntArray(numberOfUsers)
    for ((type, time, user) in events.sortedWith(compareBy({ it[1].toInt() }, { 'A' - it[0][0] }))) {
        val t = time.toInt()
        when {
            type[0] == 'O' -> {
                online[user.toInt()] = time.toInt() + 60
            }
            user[0] == 'A' -> {
                for (i in ans.indices)
                    ans[i]++
            }
            user[0] == 'H' -> {
                for (i in ans.indices)
                    if (t >= online[i])
                        ans[i]++
            }
            else -> {
                for (i in user.split(' ').map { it.substring(2).toInt() })
                    ans[i]++
            }
        }
    }
    return ans
}