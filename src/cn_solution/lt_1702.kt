package cn_solution

fun maximumBinaryString(binary: String): String {
    var all = 0
    var pre = 0
    var inc = 1
    val len = binary.length
    for (c in binary) {
        if (c == '1') {
            all++
            pre += inc
        } else {
            inc = 0
        }
    }
    if (all == len)
        return binary
    val str = CharArray(len) { '1' }
    str[binary.lastIndex - all + pre] = '0'
    return String(str)
}