package cn_solution

fun findHighAccessEmployees(access_times: List<List<String>>): List<String> {
    val emp = access_times.groupByTo(HashMap(), { it[0] }) { it[1].toInt() }
    return emp.entries.asSequence()
        .filter { (_, t) ->
            t.sort()
            (2 until t.size).any { t[it] - t[it - 2] < 100 }
        }
        .map { it.key }
        .toList()
}