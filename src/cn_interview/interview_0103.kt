package cn_interview

fun replaceSpaces(S: String, length: Int): String {
    val ca = S.toCharArray()
    var i = length
    var j = ca.size
    while (i != 0) {
        if (S[--i] == ' ') {
            ca[--j] = '0'
            ca[--j] = '2'
            ca[--j] = '%'
        } else {
            ca[--j] = S[i]
        }
    }
    return String(ca, j, ca.size - j)
}