package solution_cn

fun isScramble(s1: String, s2: String): Boolean {

    val ca1 = s1.toCharArray()
    val ca2 = s2.toCharArray()
    val map = IntArray(26)
    var cnt = 0
    val mem = HashMap<Int, Boolean>()

    fun update(input: Int) {
        if (input == 0) cnt-- else if (input == 1) cnt++
    }

    fun reset() {
        map.fill(0)
        cnt = 0
    }

    fun scramble(i1: Int, i2: Int, len: Int): Boolean {
        val key = i1.shl(16) or i2.shl(8) or len
        return mem.getOrPut(key) {
            if (len == 1) {
                return@getOrPut ca1[i1] == ca2[i2]
            }
            for (i in 0 until len - 1) {
                val l = i + 1
                update(++map[ca1[i1 + i] - 'a'])
                update(-(--map[ca2[i2 + i] - 'a']))
                if (cnt == 0 && scramble(i1, i2, l)
                        && scramble(i1 + l, i2 + l, len - l)) {
                    return@getOrPut true
                }
            }
            reset()
            for (i in 0 until len - 1) {
                val l = i + 1
                update(++map[ca1[i1 + i] - 'a'])
                update(-(--map[ca2[i2 + len - l] - 'a']))
                if (cnt == 0 && scramble(i1, i2 + len - l, l)
                        && scramble(i1 + l, i2, len - l)) {
                    return@getOrPut true
                }
            }
            reset()
            false
        }
    }

    return scramble(0, 0, ca1.size)
}