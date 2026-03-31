package cn_solution

class Robot(width: Int, height: Int) {

    private val w = width
    private val h = height
    private var s = 0

    fun step(num: Int) {
        s = (s + num - 1) % (2 * (w + h - 2)) + 1
    }

    fun getPos(): IntArray {
        val (x, y) = getState()
        return intArrayOf(x, y)
    }

    fun getDir(): String {
        return getState().third
    }

    fun getState(): Triple<Int, Int, String> {
        return when {
            s < w -> Triple(s, 0, "East")
            s < w + h - 1 -> Triple(w - 1, s - w + 1, "North")
            s < w * 2 + h - 2 -> Triple(w * 2 + h - 3 - s, h - 1, "West")
            else -> Triple(0, 2 * (w + h - 2) - s, "South")
        }
    }
}