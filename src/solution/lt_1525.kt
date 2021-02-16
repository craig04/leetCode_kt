package solution

fun numSplits(s: String): Int {
    val set = hashSetOf<Char>()
    val left = s.map {
        set.add(it)
        set.size
    }
    var res = 0
    set.clear()
    solve@ for (i in s.length - 1 downTo 1) {
        set.add(s[i])
        when {
            set.size == left[i - 1] -> res++
            set.size > left[i - 1] -> break@solve
        }
    }
    return res
}