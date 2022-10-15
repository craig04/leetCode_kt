package cn_solution

fun subdomainVisits(cpdomains: Array<String>): List<String> {
    val count = HashMap<String, Int>()
    for (s in cpdomains) {
        var p = s.indexOf(' ')
        val num = s.substring(0, p).toInt()
        while (p++ != -1) {
            val domain = s.substring(p)
            count[domain] = (count[domain] ?: 0) + num
            p = s.indexOf('.', p)
        }
    }
    return count.map { "${it.value} ${it.key}" }
}
