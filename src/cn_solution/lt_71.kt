package cn_solution

fun simplifyPath(path: String): String {
    val folders = ArrayList<String>()
    var i = 1
    for (j in 1..path.length) {
        val c = if (j == path.length) '/' else path[j]
        if (c != '/')
            continue
        if (path[j - 1] != '/') {
            if (i + 2 == j && path[i] == '.' && path[i + 1] == '.')
                folders.removeLastOrNull()
            else if (i + 1 != j || path[i] != '.')
                folders.add(path.substring(i, j))
        }
        i = j + 1
    }
    return folders.joinToString("/", "/")
}