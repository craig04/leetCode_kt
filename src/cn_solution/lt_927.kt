package cn_solution

fun threeEqualParts(arr: IntArray): IntArray {
    val sum = arr.sum()
    if (sum % 3 != 0)
        return intArrayOf(-1, -1)
    if (sum == 0)
        return intArrayOf(0, 2)
    val one = sum / 3
    val two = one * 2
    var i = 0
    var j = 0
    var k = 0
    var temp = 0
    for (t in arr.indices) {
        if (arr[t] == 1) {
            when (temp++) {
                0 -> i = t
                one -> j = t
                two -> k = t
            }
        }
    }
    val len = arr.size - k
    return if (k - j >= len && j - i >= len && (0 until len).all {
            arr[i + it] == arr[j + it] && arr[j + it] == arr[k + it]
        }) intArrayOf(i + len - 1, j + len) else intArrayOf(-1, -1)
}
