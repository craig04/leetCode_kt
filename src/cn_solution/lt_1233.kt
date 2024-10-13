package cn_solution

fun removeSubfolders(folder: Array<String>): List<String> {
    folder.sort()
    val ans = ArrayList<String>()
    return folder.filterTo(ans) {
        ans.isEmpty() || !it.startsWith(ans.last()) || it[ans.last().length] != '/'
    }
}