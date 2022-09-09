package cn_solution

fun combine(n: Int, k: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    val temp = ArrayList<Int>()
    fun dfs(i: Int) {
        if (i == n || temp.size == k) {
            result.add(ArrayList(temp))
            return
        }
        if (n - i != k - temp.size)
            dfs(i + 1)
        temp.add(i + 1)
        dfs(i + 1)
        temp.removeAt(temp.lastIndex)
    }
    dfs(0)
    return result
}