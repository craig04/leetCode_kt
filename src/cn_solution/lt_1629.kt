package cn_solution

fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
    var char = keysPressed[0]
    var time = releaseTimes[0]
    for (i in 1 until releaseTimes.size) {
        val hold = releaseTimes[i] - releaseTimes[i - 1]
        if (hold > time || hold == time && keysPressed[i] > char) {
            time = hold
            char = keysPressed[i]
        }
    }
    return char
}