package solution

fun findSpecialInteger(arr: IntArray): Int {

    val threshold = arr.size shr 2
    var i = 0
    while (i < arr.size) {
        var j = i + 1
        while (j < arr.size && arr[j] == arr[i]) {
            j++
        }
        if (j - i > threshold) {
            return arr[j]
        }
        i = j
    }
    return -1
}