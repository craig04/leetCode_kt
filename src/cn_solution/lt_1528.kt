package cn_solution

fun restoreString(s: String, indices: IntArray): String {
    val ans = CharArray(s.length)
    for (i in indices.indices)
        ans[indices[i]] = s[i]
    return String(ans)
}