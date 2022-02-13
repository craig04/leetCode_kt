package cn_solution

abstract class VersionControl {

    abstract fun firstBadVersion(n: Int): Int

    fun isBadVersion(n: Int): Boolean = TODO()
}

class Solution_278 : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var l = 1
        var h = n
        while (l != h) {
            val m = l + (h - l).shr(1)
            if (isBadVersion(m)) {
                h = m
            } else {
                l = m + 1
            }
        }
        return l
    }
}