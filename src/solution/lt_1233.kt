package solution

fun removeSubfolders(folder: Array<String>): List<String> {

    var prefix = "GUARD"
    return mutableListOf<String>().apply {
        folder.sorted().forEach {
            if (it.length <= prefix.length || !it.startsWith(prefix) || it[prefix.length] != '/') {
                add(it)
                prefix = it
            }
        }
    }
}