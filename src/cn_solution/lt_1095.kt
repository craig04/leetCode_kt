package cn_solution

interface MountainArray {
    fun get(index: Int): Int
    fun length(): Int
}

fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
    var l = 0
    var r = mountainArr.length() - 1
    while (l != r) {
        val m = (l + r) shr 1
        if (mountainArr.get(m) < mountainArr.get(m + 1)) {
            l = m + 1
        } else {
            r = m
        }
    }
    val index = binarySearch(target, mountainArr, 0, l, false)
    if (index != -1)
        return index
    return binarySearch(target, mountainArr, l + 1, mountainArr.length() - 1, true)
}

private fun binarySearch(target: Int, mountainArr: MountainArray, left: Int, right: Int, desc: Boolean): Int {
    var l = left
    var r = right
    while (l <= r) {
        val m = (l + r) shr 1
        val value = mountainArr.get(m)
        when {
            value == target -> return m
            (value < target) xor desc -> l = m + 1
            else -> r = m - 1
        }
    }
    return -1
}