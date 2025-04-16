package cn_solution

fun findCommonResponse(responses: List<List<String>>): String {
    val map = HashMap<String, Int>()
    for (resp in responses)
        for (word in resp.toHashSet())
            map.merge(word, 1, Int::plus)
    return map.minWith(compareBy({ -it.value }, { it.key })).key
}