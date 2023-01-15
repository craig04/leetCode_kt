package cn_interview

fun findLongestSubarray(array: Array<String>): Array<String> {
    val map = hashMapOf(0 to -1)
    var diff = 0
    var left = 0
    var length = 0
    array.forEachIndexed { i, s ->
        if (s[0].isLetter()) diff++ else diff--
        val last = map.putIfAbsent(diff, i)
        if (last != null && i - last > length) {
            length = i - last
            left = last + 1
        }
    }
    return Array(length) { array[left + it] }
}