package cn_solution

fun findDuplicate(paths: Array<String>): List<List<String>> {
    val map = HashMap<String, ArrayList<String>>()
    for (path in paths) {
        val split = path.split(" ")
        val dir = split[0]
        for (i in 1 until split.size) {
            val desc = split[i]
            val j = desc.indexOf('(')
            val file = desc.substring(0, j)
            val content = desc.substring(j + 1, desc.lastIndex)
            map.computeIfAbsent(content) { ArrayList() }.add("$dir/$file")
        }
    }
    return map.values.filter { it.size > 1 }
}