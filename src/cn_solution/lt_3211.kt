package cn_solution

fun validStrings(n: Int): List<String> {
    val ans = ArrayList<String>()
    val sb = StringBuilder()
    fun dfs() {
        if (sb.length == n) {
            ans.add(sb.toString())
            return
        }
        if (sb.lastOrNull() != '0') {
            sb.append('0')
            dfs()
            sb.deleteAt(sb.lastIndex)
        }
        sb.append('1')
        dfs()
        sb.deleteAt(sb.lastIndex)
    }
    dfs()
    return ans
}