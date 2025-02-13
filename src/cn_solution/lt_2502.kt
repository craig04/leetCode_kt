package cn_solution

class Allocator(val n: Int) {

    private val blocks = IntArray(n)

    fun allocate(size: Int, mID: Int): Int {
        if (size > n)
            return -1
        var i = 0
        for (j in 0 until n) {
            if (blocks[j] != 0) {
                i = j + 1
            } else if (j - i + 1 == size) {
                for (k in i..j)
                    blocks[k] = mID
                return i
            }
        }
        return -1
    }

    fun freeMemory(mID: Int): Int {
        var ans = 0
        for (i in 0 until n)
            if (blocks[i] == mID) {
                blocks[i] = 0
                ans++
            }
        return ans

    }
}