package cn_interview

class StreamRank() {

    private val c = IntArray(50002)

    fun track(x: Int) {
        var y = x
        while (y <= c.lastIndex) {
            c[y]++
            y += Integer.lowestOneBit(y)
        }
    }

    fun getRankOfNumber(x: Int): Int {
        var sum = 0
        var y = x
        while (y != 0) {
            sum += c[y]
            y = y xor Integer.lowestOneBit(y)
        }
        return sum
    }
}