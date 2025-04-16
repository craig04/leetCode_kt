package cn_solution

fun canThreePartsEqualSum(arr: IntArray): Boolean {
    var sum = arr.sum()
    if (sum % 3 != 0)
        return false
    sum /= 3
    fun find(start: Int): Int {
        var s = 0
        return (start until arr.size).firstOrNull {
            s += arr[it]
            s == sum
        } ?: -1
    }

    var x = find(0)
    if (x == -1)
        return false
    x = find(x + 1)
    return x != -1 && x != arr.lastIndex
}