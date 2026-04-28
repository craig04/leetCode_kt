package cn_solution

class Solution_788 {

    companion object {
        private val count = IntArray(10001)

        init {
            loop@ for (i in 1 until count.size) {
                count[i] = count[i - 1]
                var flag = false
                var x = i
                while (x != 0) {
                    when (x % 10) {
                        3, 4, 7 -> continue@loop
                        2, 5, 6, 9 -> flag = true
                    }
                    x /= 10
                }
                if (flag)
                    count[i]++
            }
        }
    }

    fun rotatedDigits(n: Int): Int {
        return count[n]
    }
}