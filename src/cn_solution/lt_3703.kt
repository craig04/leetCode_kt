package cn_solution

fun removeSubstring(s: String, k: Int): String {
    val st = arrayListOf(intArrayOf(0, 0))
    for (c in s) {
        if (st.last()[0] != c.code)
            st.add(intArrayOf(c.code, 0))
        st.last()[1]++
        val n = st.size
        if (n >= 3 && c == ')' && minOf(st[n - 1][1], st[n - 2][1]) >= k) {
            st.removeLast()
            st.last()[1] -= k
            if (st.last()[1] == 0)
                st.removeLast()
        }
    }
    val sb = StringBuilder()
    st.forEach { (c, n) -> repeat(n) { sb.append(c.toChar()) } }
    return sb.toString()
}