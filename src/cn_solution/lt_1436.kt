package cn_solution

fun destCity(paths: List<List<String>>): String {
    val dest = paths.mapTo(HashSet()) { it[0] }
    return paths.first { it[1] !in dest }[1]
}