package cn_solution

fun maxStudents(seats: Array<CharArray>): Int {
    val m = seats[0].size
    var pre = IntArray(1 shl m) { -1 }
    var cur = IntArray(1 shl m)
    pre[0] = 0
    var lastAvail = 0
    for (seat in seats) {
        val avail = seat.fold(0) { acc, c -> acc shl 1 or (if (c == '.') 1 else 0) }
        var s = avail
        cur.fill(-1)
        while (s != 0) {
            if (s.shr(1).and(s) == 0) {
                val people = s.countOneBits()
                var j = lastAvail
                while (j != 0) {
                    if (pre[j] != -1 && j.shl(1).and(s) == 0 && j.shr(1).and(s) == 0)
                        cur[s] = maxOf(cur[s], pre[j] + people)
                    j = lastAvail.and(j - 1)
                }
                cur[s] = maxOf(cur[s], people + pre[0])
            }
            s = avail.and(s - 1)
        }
        cur[0] = pre.max()
        val tmp = pre
        pre = cur
        cur = tmp
        lastAvail = avail
    }
    return pre.max()
}