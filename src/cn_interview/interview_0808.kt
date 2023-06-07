package cn_interview

private fun permutation(S: String): Array<String> {
    val c = S.toCharArray().apply { sort() }
    val result = ArrayList<String>()
    val sb = StringBuilder()
    fun generate() {
        if (sb.length == S.length) {
            result.add(sb.toString())
            return
        }
        for (i in c.indices) {
            if (c[i] != ' ' && (i == 0 || c[i] != c[i - 1])) {
                val temp = c[i]
                c[i] = ' '
                sb.append(temp)
                generate()
                sb.setLength(sb.length - 1)
                c[i] = temp
            }
        }
    }
    generate()
    return Array(result.size) { result[it] }
}