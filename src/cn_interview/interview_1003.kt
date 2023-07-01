package cn_interview

fun search(arr: IntArray, target: Int): Int {
    var l = 0
    var r = arr.lastIndex
    while (l < r) {
        val m = (l + r) shr 1
        if (arr[l] == target) {
            return l
        } else if (arr[m] == target) {
            r = m
        } else if (arr[r] == target) {
            l = m + 1
        } else if (arr[l] == arr[m] && arr[m] == arr[r]) {
            l++
            r--
        } else if (arr[l] <= arr[m]) {
            if (target in arr[l]..arr[m])
                r = m
            else
                l = m + 1
        } else {
            if (target in arr[m]..arr[r])
                l = m
            else
                r = m - 1
        }
    }
    return if (arr[l] == target) l else -1
}