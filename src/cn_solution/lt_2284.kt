package cn_solution

fun largestWordCount(messages: Array<String>, senders: Array<String>): String {
    val map = HashMap<String, Int>()
    for (i in messages.indices) {
        val cnt = messages[i].count { it == ' ' } + 1
        map.merge(senders[i], cnt, Int::plus)
    }
    return map.maxWith(compareBy({ it.value }, { it.key })).key
}