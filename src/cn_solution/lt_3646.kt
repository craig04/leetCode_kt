package cn_solution

class Solution_3646 {

    companion object {

        val specials = ArrayList<Long>()

        init {
            val mask = 0x155
            val c = IntArray(15)
            for (t in 1 until 512) {
                val odds = t.and(mask).countOneBits()
                if (odds > 1)
                    continue
                var len = 0
                for (i in 1..9)
                    if (1.shl(i - 1).and(t) != 0)
                        repeat(i shr 1) { c[len++] = i }
                if (len * 2 + odds > 15)
                    continue
                c[len] = t.and(mask).countTrailingZeroBits() + 1
                fun nextPermutation(): Boolean {
                    var i = len - 2
                    while (i >= 0 && c[i] >= c[i + 1])
                        i--
                    if (i < 0)
                        return false
                    var j = len - 1
                    while (c[i] >= c[j])
                        j--
                    fun swap(i: Int, j: Int) {
                        val temp = c[i]
                        c[i] = c[j]
                        c[j] = temp
                    }
                    swap(i, j)
                    i++
                    j = len - 1
                    while (i < j)
                        swap(i++, j--)
                    return true
                }

                do {
                    var num = 0L
                    for (i in 0 until len)
                        num = num * 10 + c[i]
                    if (odds == 1)
                        num = num * 10 + c[len]
                    for (i in len - 1 downTo 0)
                        num = num * 10 + c[i]
                    specials.add(num)
                } while (nextPermutation())
            }
            specials.sort()
            specials.add(2666888888886662L)
        }
    }

    fun specialPalindrome(n: Long): Long {
        val i = specials.binarySearch(n + 1)
        return specials[maxOf(i, i.inv())]
    }
}