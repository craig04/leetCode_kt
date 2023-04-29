package cn_interview

fun compressString(S: String): String {
    var i = 0
    var j = 0
    val compressed = buildString {
        while (i != S.length) {
            while (j != S.length && S[j] == S[i])
                j++
            append(S[i])
            append(j - i)
            i = j
        }
    }
    return if (S.length <= compressed.length) S else compressed
}