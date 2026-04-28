package cn_solution

fun videoStitching(clips: Array<IntArray>, time: Int): Int {
    clips.sortBy { it[0] }
    var ans = 0
    var cur = 0
    var max = 0
    for ((b, e) in clips) {
        if (b > cur) {
            if (b > max)
                break
            ans++
            cur = max
        }
        max = maxOf(max, e)
        if (max >= time)
            break
    }
    return if (max >= time) ans + 1 else -1
}