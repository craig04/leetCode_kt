package cn_solution

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val ans = ArrayList<List<Int>>()
    val seq = ArrayList<Int>()
    val arr = candidates.sortedArray()
    fun dfs(i: Int, rest: Int) {
        if (rest == 0) {
            ans += ArrayList(seq)
            return
        }
        for (j in i until arr.size) {
            if (arr[j] > rest)
                break
            if (j != i && arr[j] == arr[j - 1])
                continue
            seq += arr[j]
            dfs(j + 1, rest - arr[j])
            seq.removeLast()
        }
    }
    dfs(0, target)
    return ans
}